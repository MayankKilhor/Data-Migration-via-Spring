package com.spaceage.logistics;

import com.spaceage.logistics.Model.Postgres.Security.Authority;
import com.spaceage.logistics.Model.Postgres.Security.User;
import com.spaceage.logistics.Model.Postgres.Security.UserRole;
import com.spaceage.logistics.Model.Postgres.Uploading.EndCustomer;
import com.spaceage.logistics.Model.Postgres.Uploading.Model;
import com.spaceage.logistics.Model.Postgres.Uploading.OriginCustomer;
import com.spaceage.logistics.Model.Postgres.Uploading.Project;
import com.spaceage.logistics.Payload.Response.ApiAccessControlResult;
import com.spaceage.logistics.Payload.Response.ApiErrorResponse;
import com.spaceage.logistics.Payload.Response.ApiResponse;
import com.spaceage.logistics.Service.DatatransferService;
import com.spaceage.logistics.Service.DefaultConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/transfer")
public class DataTransferController {

    @Autowired
    private DefaultConfigService defaultConfigService;

    @Autowired
    private DatatransferService datatransferService;

    @Value("${cdn.url}")
    private String cdnURL;


    @PostMapping("/defaultConfiguration")
    public ResponseEntity<?> defaultConfiguration() {
        try {
            Map<String, Object> adminUserDetails = new HashMap<>();
            Map<String, Object> userRoleDetails = new HashMap<>();
            Map<String, Object> defaultAuthorityDetails = new HashMap<>();
            Map<String, Object> apiAccessControlDetails = new HashMap<>();
            Map<String, Object> projectDetails = new HashMap<>();
            List<Map<String, Object>> projectListDetails = new ArrayList<>();
            Map<String, Object> endCustomerDetails = new HashMap<>();
            Map<String, Object> originCustomerDetails = new HashMap<>();
            try {
                User adminUser = defaultConfigService.createAdminUser();
                adminUserDetails.put("success",true);
                adminUserDetails.put("name",adminUser.getName());
                adminUserDetails.put("userName",adminUser.getUsername());
                adminUserDetails.put("userId",adminUser.getUserId());
//                adminUserDetails.put("userRole",adminUser.getUserRole());
                adminUserDetails.put("created_at",adminUser.getCreatedAt());
                adminUserDetails.put("updated_at",adminUser.getUpdatedAt());
                System.out.println("Successfully created Admin User with userId:- "+adminUser.getUserId());
                try{
                    UserRole userRole = defaultConfigService.createUserRole(adminUser);
                    userRoleDetails.put("success", true);
                    userRoleDetails.put("roleId", userRole.getRoleId());
                    userRoleDetails.put("name", userRole.getName());
//                    userRoleDetails.put("createdBy", userRole.getCreatedBy().getUsername());
                    userRoleDetails.put("description", userRole.getDescription());
//                    userRoleDetails.put("authorities", userRole.getAuthorities());
                    userRoleDetails.put("createdAt", userRole.getCreated_at());
                    userRoleDetails.put("updatedAt", userRole.getUpdated_at());
                }catch(Exception e){
                    userRoleDetails.put("success", false);
                    userRoleDetails.put("error","Not able to create USER Role, Error:- "+e.getMessage());
                }
                try{
                    Set<Authority> authorities =  defaultConfigService.defaultAuthority(adminUser);
                    defaultAuthorityDetails.put("success", true);
                    defaultAuthorityDetails.put("authorities",authorities);
                }catch(Exception e){
                    defaultAuthorityDetails.put("success",false);
                    defaultAuthorityDetails.put("error","Not able to create Default Authorities, Error:- "+e.getMessage());
                }
                try{
                    ApiAccessControlResult result= defaultConfigService.defaultApiAccessControl(adminUser);
                    if(result.getErrors().size()>0){
                        apiAccessControlDetails.put("errors",result.getErrors());
                    }
                    apiAccessControlDetails.put("accessControl",result.getSuccessfulApiAccessControls());
                }catch(Exception e){
                    apiAccessControlDetails.put("success",false);
                    apiAccessControlDetails.put("error","Not able to create Api AccessControl, Error:- "+e.getMessage());
                }
                try {
                    List<Project> defaultProjects = defaultConfigService.createDefaultProjects(adminUser);


                    for (Project project : defaultProjects) {
                        Map<String, Object> projectInfo = new HashMap<>();
                        projectInfo.put("projectId", project.getProjectId());
                        projectInfo.put("name", project.getName());
                        projectInfo.put("description", project.getDescription());

                        List<Model> models = defaultConfigService.createDefaultModelsForProject(project);
                        List<Map<String, Object>> modelListDetails = models.stream().map(model -> {
                            Map<String, Object> modelDetails = new HashMap<>();
                            modelDetails.put("modelId", model.getModelId());
                            modelDetails.put("name", model.getName());
                            modelDetails.put("description", model.getDescription());
//                            modelDetails.put("createdBy", model.getCreatedBy() != null ? model.getCreatedBy().getUsername() : null);
//                            modelDetails.put("updatedBy", model.getUpdatedBy() != null ? model.getUpdatedBy().getUsername() : null);
                            modelDetails.put("createdAt", model.getCreatedAt());
                            modelDetails.put("updatedAt", model.getUpdatedAt());
                            return modelDetails;
                        }).collect(Collectors.toList());

                        projectInfo.put("models", modelListDetails);
                        projectListDetails.add(projectInfo);
                    }

                    projectDetails.put("success", true);
                    projectDetails.put("projects", projectListDetails);
                } catch (Exception e) {
                    projectDetails.put("success", false);
                    projectDetails.put("error", "Failed to create default projects and models, Error: " + e.getMessage());
                }

                // Creating Default Origin Customers
                try {
                    List<OriginCustomer> originCustomers = defaultConfigService.createDefaultOriginCustomers(adminUser);
                    List<Map<String, Object>> originCustomerListDetails = originCustomers.stream().map(customer -> {
                        Map<String, Object> customerDetails = new HashMap<>();
                        customerDetails.put("originCustomerId", customer.getOriginCustomerId());
                        customerDetails.put("name", customer.getName());
                        customerDetails.put("description", customer.getDescription());
                        customerDetails.put("country", customer.getCountry());
                        customerDetails.put("city", customer.getCity());
                        customerDetails.put("address", customer.getAddress());
                        customerDetails.put("postalCode", customer.getPostalCode());
                        customerDetails.put("contactName", customer.getContactName());
                        customerDetails.put("contactPhoneNo", customer.getContactPhoneNo());
//                        customerDetails.put("createdBy",customer.getCreatedBy().getUsername());
//                        customerDetails.put("updatedBy",customer.getUpdatedBy().getUsername());
                        customerDetails.put("createdAt", customer.getCreatedAt());
                        customerDetails.put("updatedAt", customer.getUpdatedAt());
                        return customerDetails;
                    }).collect(Collectors.toList());

                    originCustomerDetails.put("success", true);
                    originCustomerDetails.put("customers", originCustomerListDetails);
                } catch (Exception e) {
                    originCustomerDetails.put("success", false);
                    originCustomerDetails.put("error", "Failed to create default Origin Customers, Error: " + e.getMessage());
                }

                // Creating Default End Customers
                try {
                    List<EndCustomer> endCustomers = defaultConfigService.createDefaultEndCustomers(adminUser);
                    List<Map<String, Object>> originCustomerListDetails = endCustomers.stream().map(customer -> {
                        Map<String, Object> customerDetails = new HashMap<>();
                        customerDetails.put("endCustomerId", customer.getEndCustomerId());
                        customerDetails.put("name", customer.getName());
                        customerDetails.put("description", customer.getDescription());
                        customerDetails.put("country", customer.getCountry());
                        customerDetails.put("city", customer.getCity());
                        customerDetails.put("address", customer.getAddress());
                        customerDetails.put("postalCode", customer.getPostalCode());
                        customerDetails.put("contactName", customer.getContactName());
                        customerDetails.put("contactPhoneNo", customer.getContactPhoneNo());
//                        customerDetails.put("createdBy",customer.getCreatedBy().getUsername());
//                        customerDetails.put("updatedBy",customer.getUpdatedBy().getUsername());
                        customerDetails.put("createdAt", customer.getCreatedAt());
                        customerDetails.put("updatedAt", customer.getUpdatedAt());
                        return customerDetails;
                    }).collect(Collectors.toList());

                    endCustomerDetails.put("success", true);
                    endCustomerDetails.put("customers", originCustomerListDetails);
                } catch (Exception e) {
                    endCustomerDetails.put("success", false);
                    endCustomerDetails.put("error", "Failed to create default Origin Customers, Error: " + e.getMessage());
                }

            }catch(Exception e){
                System.out.println("Failed to create Admin User, Error:- "+e.getMessage());
                adminUserDetails.put("success", false);
                adminUserDetails.put("error", "Failed to create Admin User, Error:- "+e.getMessage());
                userRoleDetails.put("success", false);
                userRoleDetails.put("error","Admin Role wasn't created!");
                defaultAuthorityDetails.put("success",false);
                defaultAuthorityDetails.put("error","Admin role wasn't created!");
                apiAccessControlDetails.put("succcess",false);
                apiAccessControlDetails.put("error","Admin role wasn't created!");

                ApiErrorResponse errorResponse = new ApiErrorResponse(false,"Failed to initialize Default Configuration!");
                errorResponse.addDetail("admin",adminUserDetails);
                errorResponse.addDetail("userRole",userRoleDetails);
                errorResponse.addDetail("defaultAuthority", defaultAuthorityDetails);
                errorResponse.addDetail("apiAccessControl", apiAccessControlDetails);

                System.out.println("Failed to initialize Default Configuration, Error:- "+e.getMessage());
                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
            }

            ApiResponse apiResponse = new ApiResponse(true,"Successfully initialized Default Configuration!","/");
            apiResponse.addDetail("adminDetails",adminUserDetails);
//            apiResponse.addDetail("userRoleDetails",userRoleDetails);
//            apiResponse.addDetail("defaultAuthorityDetails", defaultAuthorityDetails);
//            apiResponse.addDetail("apiAccessControlDetails", apiAccessControlDetails);
                apiResponse.addDetail("projectDetails",projectDetails);
            apiResponse.addDetail("originCustomerDetails",originCustomerDetails);
            apiResponse.addDetail("endCustomerDetails",endCustomerDetails);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }catch(Exception e){
            ApiErrorResponse errorResponse = new ApiErrorResponse(false,"Failed to initialize Default Configuration!");
            errorResponse.addDetail("error",e.getMessage());
            System.out.println("Failed to initialize Default Configuration, Error:- "+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/transferBOM")
    public ResponseEntity<?> transferBom(){
        try{

            List<String> bomTableIds = datatransferService.transferBOMTable();

            ApiResponse apiResponse = new ApiResponse(true,"Successfully transfered BomTables!","/");
            apiResponse.addDetail("bomTableIds",bomTableIds);
            apiResponse.addDetail("count",bomTableIds.size());

            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        }catch(Exception e){
            ApiErrorResponse errorResponse = new ApiErrorResponse(false,"Failed to do BOM Transfer!");
            errorResponse.addDetail("error",e.getMessage());
            System.out.println("Failed to do Bom transfer , Error:- "+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
