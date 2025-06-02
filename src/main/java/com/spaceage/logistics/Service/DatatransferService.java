package com.spaceage.logistics.Service;

import com.spaceage.logistics.Exceptions.DatabaseException;
import com.spaceage.logistics.Model.MySQL.CustomerMaster;
import com.spaceage.logistics.Model.MySQL.ItemMaster;
import com.spaceage.logistics.Model.MySQL.ProjectMaster;
import com.spaceage.logistics.Model.MySQL.Tblbom;
import com.spaceage.logistics.Model.Postgres.Security.ApiAccessControl;
import com.spaceage.logistics.Model.Postgres.Security.Authority;
import com.spaceage.logistics.Model.Postgres.Security.User;
import com.spaceage.logistics.Model.Postgres.Security.UserRole;
import com.spaceage.logistics.Model.Postgres.Uploading.*;
import com.spaceage.logistics.Payload.Request.Role.CreateRoleRequest;
import com.spaceage.logistics.Payload.Response.ApiAccessControlResult;
import com.spaceage.logistics.Payload.enums.*;
import com.spaceage.logistics.Repository.MySQL.CustomerMasterRepository;
import com.spaceage.logistics.Repository.MySQL.ItemMasterRepository;
import com.spaceage.logistics.Repository.MySQL.ProjectMasterRepository;
import com.spaceage.logistics.Repository.MySQL.TblbomRepository;
import com.spaceage.logistics.Repository.Postgres.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class DatatransferService {
    @Autowired
    BomTableRepository bomTableRepository;

    @Autowired
    BomPartRepository bomPartRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    EndCustomerRepository endCustomerRepository;

    @Autowired
    OriginCustomerRepository originCustomerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemMasterRepository itemMasterRepository;

    @Autowired
    TblbomRepository tblbomRepository;

    @Value("${cdn.url}")
    private String cdnURL;

//    public List<String> transferBOMTable(){
//
//        List<String> bomTablesId = new ArrayList<>();
//        List<BomTable> bomTables = new ArrayList<>();
//
////        List<ItemMaster> itemMasters =  itemMasterRepository.findAll();
//
//        LocalDateTime cutoff = LocalDateTime.of(2025, 5, 1, 0, 0);
//        List<ItemMaster> itemMasters = itemMasterRepository.findItemsCreatedBefore(cutoff);
//
//
//
//        for (ItemMaster itemMaster : itemMasters) {
//            // Check if LotRefNo is not null and status is 1
//            if (itemMaster.getLotRefNo() != null && itemMaster.getStatus() != null && itemMaster.getStatus()) {
//                // Create BomTable for the valid ItemMaster
//                List<BomPart> bomPartList =  new ArrayList<>();
//                BomTable bomTable;
//                String bomTableId = "OLDBOM_"+itemMaster.getItemId();
//                Optional<BomTable> existingBomTable = bomTableRepository.findByBomTableId(bomTableId);
//                if(existingBomTable.isEmpty()){
//                    bomTable = createBomTableFromItemMaster(itemMaster);
//                    bomTableRepository.save(bomTable);
//                    bomTables.add(bomTable);
//                    bomTablesId.add(bomTable.getBomTableId());
//                }else{
//                    bomTable = existingBomTable.get();
//                    bomTables.add(bomTable);
//                    bomTablesId.add(bomTable.getBomTableId());
//                }
//
//                List<Tblbom> tblbomList = tblbomRepository.findByItemId(itemMaster.getItemId());
//
//                for (Tblbom tblbom : tblbomList) {
//                    String bomPartId = bomTable.getBomTableId() + ":BOMPART_" + tblbom.getBomId();
//
//                    // Check if BomPart already exists by bomPartId
//                    Optional<BomPart> existBomPart = bomPartRepository.findById(bomPartId);
//                    if (!existBomPart.isEmpty()) {
//                        bomPartList.add(existBomPart.get());
//                    }else{
//                        BomPart bomPart = createBomPart(tblbom,bomTable);
//                        bomPartRepository.save(bomPart);
//                        bomPartList.add(bomPart);
//                    }
//                }
//                bomTable.setPartCount((long) bomPartList.size());
//                bomTable.setBomcompletePartCount((long) bomPartList.size());
//                bomTableRepository.save(bomTable);
//            }
//
//        }
//
//
//        // Return the list of BomTable objects
//        return bomTablesId;
//
//    }

public List<String> transferBOMTable() {
    List<String> bomTablesId = new ArrayList<>();
    List<BomTable> bomTables = new ArrayList<>();

    // Define the cutoff date
    LocalDateTime cutoff = LocalDateTime.of(2025, 5, 1, 0, 0);
    List<ItemMaster> itemMasters = itemMasterRepository.findItemsCreatedBefore(cutoff);

    for (ItemMaster itemMaster : itemMasters) {
        // Proceed only if LotRefNo is not null and status is true
        if (itemMaster.getLotRefNo() != null && Boolean.TRUE.equals(itemMaster.getStatus())) {

            String bomTableId = "OLDBOM_" + itemMaster.getItemId();
            Optional<BomTable> existingBomTable = bomTableRepository.findByBomTableId(bomTableId);

            // If BomTable already exists, skip it
            if (existingBomTable.isPresent()) {
                bomTables.add(existingBomTable.get());
                bomTablesId.add(existingBomTable.get().getBomTableId());
                System.out.println("DYNASAS:- It exists: "+ existingBomTable.get().getBomTableId());
                continue;
            }

            // Create new BomTable
            BomTable bomTable = createBomTableFromItemMaster(itemMaster);
            bomTable.setPartList(new ArrayList<>());
            bomTableRepository.save(bomTable);
            System.out.println("DYNASAS:- It is created: "+ bomTableId);
            bomTables.add(bomTable);
            bomTablesId.add(bomTable.getBomTableId());

            List<Tblbom> tblbomList = tblbomRepository.findByItemId(itemMaster.getItemId());

            List<BomPart> bomPartList = new ArrayList<>();
            for (Tblbom tblbom : tblbomList) {
                String bomPartId = bomTable.getBomTableId() + ":BOMPART_" + tblbom.getBomId();

                Optional<BomPart> existBomPart = bomPartRepository.findById(bomPartId);
                if (existBomPart.isPresent()) {
                    bomPartList.add(existBomPart.get());
                } else {
                    BomPart bomPart = createBomPart(tblbom, bomTable);
                    bomPartRepository.save(bomPart);
                    bomPartList.add(bomPart);
                }
            }
            System.out.println(bomPartList);
            if (bomTable.getBomPartList() == null) {
                bomTable.setBomPartList(new ArrayList<>());
            }
            bomTable.getBomPartList().clear();
            for (BomPart part : bomPartList) {
                bomTable.getBomPartList().add(part);
            }
            bomTable.setPartCount((long) bomPartList.size());
            bomTable.setBomcompletePartCount((long) bomPartList.size());

            bomTableRepository.save(bomTable);
            bomTablesId.add(bomTable.getBomTableId());
        }
    }

    return bomTablesId;
}


    public BomPart createBomPart(Tblbom tblbom,BomTable bomTable){
        BomPart bomPart = new BomPart();

        bomPart.setBomPartId(bomTable.getBomTableId() +":BOMPART_" + tblbom.getBomId()); // Or generate some unique ID logic
        bomPart.setBomNo(parseIntOrNull(tblbom.getBomNo()));
        if(tblbom.getPartNo()==null){
            bomPart.setPartNo("-");
        }else{
            bomPart.setPartNo(tblbom.getPartNo());
        }
        if(tblbom.getPartDescription()==null){
            bomPart.setPartDescription("-");
        }else{
            bomPart.setPartDescription(tblbom.getPartDescription());
        }
        bomPart.setVersion(parseLongOrNull(tblbom.getVersion()));
        if(bomPart.getStLocation()==null){
            bomPart.setStLocation("-");
        }else{
            bomPart.setStLocation(tblbom.getStLocation());
        }


        if(tblbom.getValidity()==null){
            bomPart.setValidity("-");
        }else{
            bomPart.setValidity(tblbom.getValidity());
        }

        if(tblbom.getCatDescription()==null){
            bomPart.setCatDescription("-");
        }else {
            bomPart.setCatDescription(tblbom.getCatDescription());
        }
        bomPart.setQtyRequired(parseLongOrNull(tblbom.getQtyRequired()));
        bomPart.setQtyPerLot(parseLongOrNull(tblbom.getQtyLot()));
        bomPart.setPrimaryNo("-");
        bomPart.setLayerNo("-");
        if(tblbom.getSecondaryNo() ==null){
            bomPart.setSecondaryNo("-");
        }else{
            bomPart.setSecondaryNo(tblbom.getSecondaryNo());
        }
        if(tblbom.getPackCode()==null){
            bomPart.setPackCode("-");
        }else{
            bomPart.setPackCode(tblbom.getPackCode());
        }
        bomPart.setPackQty(parseLongOrNull(tblbom.getPackQty()));

        if(tblbom.getPackingGroup()==null){
            bomPart.setPackingGroup("-");
        }else{
            bomPart.setPackingGroup(tblbom.getPackingGroup());
        }

        bomPart.setTotalNoOfPackingGroup(parseLongOrNull(tblbom.getTotalNoOfPackingGroup()));
        bomPart.setMixGroup(parseLongOrNull(tblbom.getMixGroup()));
        bomPart.setMixBox(parseLongOrNull(tblbom.getMix()));
        bomPart.setMixPartType(-1L);
        bomPart.setMixLayer(-1L);

        bomPart.setCaseMap(parseLongOrNull(tblbom.getCaseMap()));
        bomPart.setImages(cdnURL+ "PARTIMAGE/" + tblbom.getPartNo());
        if(tblbom.getPrimaryNo()==null){
            bomPart.setPartType("-");
        }else{
            bomPart.setPartType(tblbom.getPrimaryNo());
        }

        bomPart.setUploadDate(tblbom.getCreatedDate());
        bomPart.setAcknowledgedDate(tblbom.getAckDate());
        bomPart.setQualityCheckDate(tblbom.getAckDate());
        bomPart.setPartLabelDate(tblbom.getReceivedDate());

        bomPart.setStatus(BomPartStatus.BOM_COMPLETE);

        bomPart.setBomTable(bomTable);

        return bomPart;

    }
    private static Long parseLongOrNull(String value) {
        try {
            return value != null ? Long.parseLong(value.trim()) : -1L;
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    private static Integer parseIntOrNull(String value) {
        try {
            return value != null ? Integer.parseInt(value.trim()) : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public BomTable createBomTableFromItemMaster(ItemMaster itemMaster) {
        // Create a new BomTable object
        BomTable bomTable = new BomTable();

        // Set the LotRefNo from ItemMaster
        bomTable.setLotRefNo(itemMaster.getLotRefNo());
        String BomTableId = "OLDBOM_"+itemMaster.getItemId();
        bomTable.setBomTableId(BomTableId);
        bomTable.setPartCount(0L);
        bomTable.setMirnPartCount(0L);  // Default to 0 for now
        bomTable.setPendingForPickupPartCount(0L);  // Default to 0 for now
        bomTable.setAcknowledgedPartCount(0L);  // Default to 0 for now
        bomTable.setQcFailedPartCount(0L);  // Default to 0 for now
        bomTable.setPartlabelPartCount(0L);  // Default to 0 for now
        bomTable.setBomcompletePartCount(0L);  // Default to 0 for now
        bomTable.setErrorPartCount(0L);  // Default to 0 for now
        bomTable.setS3Location(null);  // Placeholder for now
        bomTable.setS3Key(null);  // Placeholder for now
        bomTable.setMIRN_Url(null);  // Placeholder for now
        bomTable.setQualityCheckUrl(null);  // Placeholder for now
        bomTable.setPartLabelUrl(null);  // Placeholder for now
        if (itemMaster.getLotSize() != null) {
            // Check if the LotSize value is a valid number (digits only)
            try {
                Long lotSizeValue = Long.parseLong(itemMaster.getLotSize());
                bomTable.setLotSize(lotSizeValue); // Convert to String and set it
            } catch (NumberFormatException e) {
                // Handle the case where the value is not a valid number, e.g., log the error or leave it unset
                bomTable.setLotSize(null); // or leave it empty, depending on your requirement
            }
        }

        if (itemMaster.getContainers() != null && itemMaster.getContainers().matches("\\d+")) {
            // Check if the Containers value is a valid number (digits only)
            Long containerCountValue = Long.parseLong(itemMaster.getContainers());
            bomTable.setContainerCount(containerCountValue); // Set the value as Long
        } else {
            // Handle the case where Containers is not a valid number or is null
            bomTable.setContainerCount(null); // or leave it empty, depending on your requirement
        }  // Placeholder for now

        String modelIdPattern = "OLD_" + itemMaster.getProjectCode() + ":%"; // Regex-like pattern

        // Find the model using the pattern
        Optional<Model> existingModel = modelRepository.findByModelIdPattern(modelIdPattern);
        if (!existingModel.isEmpty()) {
            bomTable.setModel(existingModel.get());
            bomTable.setProject(existingModel.get().getProject());
        } else {
            bomTable.setModel(null);
            bomTable.setProject(null);
        }

        String endCustomerIdPattern = "OLD_" + itemMaster.getCustomerCode() + ":%";

        Optional<EndCustomer> existingEndCustomer = endCustomerRepository.findByEndCustomerIdPattern(endCustomerIdPattern);
        if (existingEndCustomer.isPresent()) {
            bomTable.setEndCustomer(existingEndCustomer.get());
        } else {
            bomTable.setEndCustomer(null);
        }


        if(itemMaster.getOrgCountryId()==99){
            Optional<OriginCustomer> originCustomerOptional = originCustomerRepository.findById("OLD_IND");

            // If found, set the OriginCustomer
            if (originCustomerOptional.isPresent()) {
                OriginCustomer originCustomer = originCustomerOptional.get();
                bomTable.setOriginCustomer(originCustomer); // Set the found OriginCustomer
            } else {
                // Handle case if no customer found with ID = 1 (optional)
                bomTable.setOriginCustomer(null);
                System.out.println("OriginCustomer with ID OLD_IND not found.");
            }
        }else if(itemMaster.getOrgCountryId()==110){
            Optional<OriginCustomer> originCustomerOptional = originCustomerRepository.findById("OLD_KEN");

            // If found, set the OriginCustomer
            if (originCustomerOptional.isPresent()) {
                OriginCustomer originCustomer = originCustomerOptional.get();
                bomTable.setOriginCustomer(originCustomer); // Set the found OriginCustomer
            } else {
                // Handle case if no customer found with ID = 1 (optional)
                bomTable.setOriginCustomer(null);
                System.out.println("OriginCustomer with ID OLD_KEN not found.");
            }
        }else if(itemMaster.getOrgCountryId()==18){
            Optional<OriginCustomer> originCustomerOptional = originCustomerRepository.findById("OLD_BGD");

            // If found, set the OriginCustomer
            if (originCustomerOptional.isPresent()) {
                OriginCustomer originCustomer = originCustomerOptional.get();
                bomTable.setOriginCustomer(originCustomer); // Set the found OriginCustomer
            } else {
                // Handle case if no customer found with ID = 1 (optional)
                bomTable.setOriginCustomer(null);
                System.out.println("OriginCustomer with ID OLD_BGD not found.");
            }
        }else if(itemMaster.getOrgCountryId()==169){
            Optional<OriginCustomer> originCustomerOptional = originCustomerRepository.findById("OLD_PHL");

            // If found, set the OriginCustomer
            if (originCustomerOptional.isPresent()) {
                OriginCustomer originCustomer = originCustomerOptional.get();
                bomTable.setOriginCustomer(originCustomer); // Set the found OriginCustomer
            } else {
                // Handle case if no customer found with ID = 1 (optional)
                bomTable.setOriginCustomer(null);
                System.out.println("OriginCustomer with ID OLD_PHL not found.");
            }
        }else{
            bomTable.setOriginCustomer(null);
        }



        //Shipping Loc
        if(itemMaster.getPackingType()==5){
            bomTable.setShippingLoc(ShippingLoc.INTERNATIONAL);
        }else if(itemMaster.getPackingType()==6){
            bomTable.setShippingLoc(ShippingLoc.DOMESTIC);
        }else if(itemMaster.getPackingType()==7){
            bomTable.setShippingLoc(ShippingLoc.IUT);
        }else{
            bomTable.setShippingLoc(ShippingLoc.OTHER);
        }
        Optional<User> adminUserOptional = userRepository.findOptionalUserByUsername("admin@dynasas");
        if(adminUserOptional.isPresent()){
            bomTable.setCreatedBy(adminUserOptional.get());  // Placeholder for now
            bomTable.setUpdatedBy(adminUserOptional.get());
        }else{
            bomTable.setCreatedBy(null);  // Placeholder for now
            bomTable.setUpdatedBy(null);
        }
        LocalDateTime localDateTime = itemMaster.getCreatedDate();

        Date date = Date.from(localDateTime.toInstant(ZoneOffset.UTC));

        bomTable.setCreatedAt(date);
        bomTable.setUpdatedAt(date);  // Assuming current date for now
        bomTable.setStatus(BomTableStatus.OLDSYSTEM);  // Placeholder for now
        bomTable.setAcknowledgementStatus(BomAcknowledgementStatus.COMPLETED);  // Placeholder for now
        bomTable.setQualityCheckStatus(BomQualityCheckStatus.COMPLETED);  // Placeholder for now
        bomTable.setPartLabelStatus(BomPartLabelStatus.COMPLETED);  // Placeholder for now
        bomTable.setUploadStatus(null);
        // Placeholder for now

        // Return the populated BomTable object
        return bomTable;
    }

}
