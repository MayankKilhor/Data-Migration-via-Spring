package com.spaceage.logistics.Service;

import com.spaceage.logistics.Exceptions.DatabaseException;
import com.spaceage.logistics.Model.MySQL.CustomerMaster;
import com.spaceage.logistics.Model.MySQL.ProjectMaster;
import com.spaceage.logistics.Model.Postgres.Security.ApiAccessControl;
import com.spaceage.logistics.Model.Postgres.Security.Authority;
import com.spaceage.logistics.Model.Postgres.Security.User;
import com.spaceage.logistics.Model.Postgres.Security.UserRole;
import com.spaceage.logistics.Model.Postgres.Uploading.EndCustomer;
import com.spaceage.logistics.Model.Postgres.Uploading.Model;
import com.spaceage.logistics.Model.Postgres.Uploading.OriginCustomer;
import com.spaceage.logistics.Model.Postgres.Uploading.Project;
import com.spaceage.logistics.Payload.Request.Role.CreateRoleRequest;
import com.spaceage.logistics.Payload.Response.ApiAccessControlResult;
import com.spaceage.logistics.Repository.MySQL.CustomerMasterRepository;
import com.spaceage.logistics.Repository.MySQL.ProjectMasterRepository;
import com.spaceage.logistics.Repository.Postgres.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


import com.spaceage.logistics.Exceptions.DatabaseException;
import com.spaceage.logistics.Model.MySQL.CustomerMaster;
import com.spaceage.logistics.Model.MySQL.ProjectMaster;
import com.spaceage.logistics.Model.Postgres.Security.ApiAccessControl;
import com.spaceage.logistics.Model.Postgres.Security.Authority;
import com.spaceage.logistics.Model.Postgres.Security.User;
import com.spaceage.logistics.Model.Postgres.Security.UserRole;
import com.spaceage.logistics.Model.Postgres.Uploading.EndCustomer;
import com.spaceage.logistics.Model.Postgres.Uploading.Model;
import com.spaceage.logistics.Model.Postgres.Uploading.OriginCustomer;
import com.spaceage.logistics.Model.Postgres.Uploading.Project;
import com.spaceage.logistics.Payload.Request.Role.CreateRoleRequest;
import com.spaceage.logistics.Payload.Response.ApiAccessControlResult;
import com.spaceage.logistics.Repository.MySQL.CustomerMasterRepository;
import com.spaceage.logistics.Repository.MySQL.ProjectMasterRepository;
import com.spaceage.logistics.Repository.Postgres.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class DefaultConfigService {

    @Autowired
    ApiAccessControlRepository apiAccessControlRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    OriginCustomerRepository originCustomerRepository;

    @Autowired
    EndCustomerRepository endCustomerRepository;


    //MYSQL Repository

    @Autowired
    ProjectMasterRepository projectMasterRepository;

    @Autowired
    CustomerMasterRepository customerMasterRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Transactional
    public void transferData() {

    }


    public User createAdminUser() {
        // Check if GOD role already exists
        try {
            Optional<UserRole> adminRoleOptional = userRoleRepository.findById("ROLE_ADMIN");

            UserRole adminRole;
            if (!adminRoleOptional.isPresent()) {
                // Create GOD role with full permissions
                adminRole = new UserRole();
                adminRole.setRoleId("ROLE_ADMIN");
                adminRole.setName("Admin");
                adminRole.setDescription("Full access to manage users, roles, and permissions");
                Date creationDate = new Date();
                adminRole.setCreated_at(creationDate);
                adminRole.setUpdated_at(creationDate);


                userRoleRepository.save(adminRole);
            } else {
                adminRole = adminRoleOptional.get();
            }

            // Check if GOD user already exists
            Optional<User> adminUserOptional = Optional.ofNullable(userRepository.findByUsername("admin@dynasas"));

            User adminUser;
            if (!adminUserOptional.isPresent()) {
                // Create GOD user
                adminUser = new User();
                adminUser.setUserId("ADMIN");
                adminUser.setName("Admin");
                adminUser.setUsername("admin@dynasas");
                adminUser.setPassword_hash(encoder.encode("password")); // This should be a securely hashed password
                adminUser.setVerified(true);
                adminUser.setPhoneNo("0000000000");
                adminUser.setUserRole(adminRole);
                Date creationUserDate =new Date();
                adminUser.setCreatedAt(creationUserDate);
                adminUser.setUpdatedAt(creationUserDate);

                userRepository.save(adminUser);
            } else {
                adminUser = adminUserOptional.get();
            }

            return adminUser;
        }catch(Exception e){

            throw new RuntimeException("Not able to create Admin User, Error:- "+e.getMessage());
        }
    }



    public ApiAccessControlResult defaultApiAccessControl(User adminUser) {
        try {
            // Fetch user role
            UserRole role = userRoleRepository.findById(adminUser.getUserRole().getRoleId())
                    .orElseThrow(() -> new RuntimeException("UserRole not found"));

            Set<ApiAccessControl> apiAccessControls = new HashSet<>();
            List<String> authoritiesErrors = new ArrayList<>();

            // List of endpoints to create
            List<String> publicEndpoints = Arrays.asList(
                    "/api/contact/submit",
                    "/api/auth/sendOtp",
                    "/api/auth/verifyOtp",
                    "/api/auth/signUp",
                    "/api/auth/login"
            );
            Map<String, Set<String>> authoritiesEndpoints = new HashMap<>();
            authoritiesEndpoints.put("/api/authorities/createRole", new HashSet<>(Arrays.asList("ADD_ROLE","FULL_ACCESS")));
            authoritiesEndpoints.put("/api/authorities/assignAuthority", new HashSet<>(Arrays.asList( "ASSIGN_AUTHORITY","FULL_ACCESS")));
            authoritiesEndpoints.put("/api/authorities/removeAuthority", new HashSet<>(Arrays.asList("REMOVE_AUTHORITY","FULL_ACCESS")));
            authoritiesEndpoints.put("/api/authorities/createAuthority", new HashSet<>(Arrays.asList( "ADD_AUTHORITY","FULL_ACCESS")));
//            authoritiesEndpoints.put("/api/bom/upload", new HashSet<>(Arrays.asList( "BOM_UPLOAD","FULL_ACCESS")));
//            authoritiesEndpoints.put("/api/authorities/createAuthority", new HashSet<>(Arrays.asList( "ADD_AUTHORITY","FULL_ACCESS")));


            // Iterate through endpoints and attempt to create ApiAccessControl for each
            for (String endpoint : publicEndpoints) {
                try {
                    apiAccessControls.add(createApiAccessControl(endpoint, "POST", new HashSet<>(), true));
                } catch (Exception e) {
                    authoritiesErrors.add("Error creating access control for endpoint: " + endpoint + " - " + e.getMessage());
                }
            }
            for (Map.Entry<String, Set<String>> entry : authoritiesEndpoints.entrySet()) {
                String endpoint = entry.getKey();
                Set<String> authorityNames = entry.getValue();
                try {

                    apiAccessControls.add(createApiAccessControl(endpoint, "POST", authorityNames, false));
                } catch (Exception e) {
                    authoritiesErrors.add("Error creating access control for endpoint: " + endpoint + " - " + e.getMessage());
                }
            }

            // Return both successful ApiAccessControl and errors in the response object
            return new ApiAccessControlResult(apiAccessControls, authoritiesErrors);

        } catch (Exception e) {
            throw e;  // Rethrow the exception if any general error occurs
        }
    }

    public UserRole createUserRole(User user) {
        try {
            Optional<UserRole> userRoleOptional = userRoleRepository.findByName("USER");
            UserRole userRole;
            if (!userRoleOptional.isPresent()) {
                userRole = new UserRole();
                userRole.setRoleId("ROLE_USER");
                userRole.setName("User");
                userRole.setDescription("A Basic User");
                userRole.setCreatedBy(user);
                userRole.setAuthorities(new HashSet<>());
                userRole.setCreated_at(new Date());
                userRole.setUpdated_at(new Date());
                try {
                    userRoleRepository.save(userRole);
                } catch (Exception e) {
                    throw new DatabaseException("Unable to save USER Role in user_role table, Error= " + e.getMessage());
                }
            } else {
                System.out.println("USER Role  was already present user_role table!");
                userRole = userRoleOptional.get();
            }
            return userRole;
        }catch (DatabaseException de){
            throw de;
        }catch(Exception e){
            throw e;
        }

    }

    public UserRole createRole(User creatorUser, CreateRoleRequest createRoleRequest) {
        try {
            Optional<UserRole> userRoleOptional = userRoleRepository.findById(createRoleRequest.getRoleId());
            UserRole newRole;
            if (!userRoleOptional.isPresent()) {
                newRole = new UserRole();
                newRole.setRoleId(createRoleRequest.getRoleId());
                newRole.setName(createRoleRequest.getName());
                newRole.setDescription(createRoleRequest.getDescription());
                newRole.setCreatedBy(creatorUser);
                newRole.setCreated_at(new Date());
                try {
                    userRoleRepository.save(newRole);
                } catch (Exception e) {
                    throw new DatabaseException("Unable to save "+ createRoleRequest.getRoleId()+" Role in user_role table, Error= " + e.getMessage());
                }
            } else {
                System.out.println(createRoleRequest.getRoleId() + " Role  was already present in user_role table!");
                newRole = userRoleOptional.get();
            }
            return newRole;
        }catch (DatabaseException de){
            throw de;
        }catch(Exception e){
            throw e;
        }

    }

    public Set<Authority> defaultAuthority(User adminUser) {
        try {
            UserRole role = userRoleRepository.findById(adminUser.getUserRole().getRoleId())
                    .orElseThrow(() -> new RuntimeException("UserRole not found"));

            Set<Authority> authorities = new HashSet<>();
            authorities.add(createOrGetAuthority(adminUser, "ADD_ROLE"));
            authorities.add(createOrGetAuthority(adminUser, "ADD_AUTHORITY"));
            authorities.add(createOrGetAuthority(adminUser, "CHANGE_ROLE"));
            authorities.add(createOrGetAuthority(adminUser, "ASSIGN_AUTHORITY"));
            authorities.add(createOrGetAuthority(adminUser, "REMOVE_AUTHORITY"));
            authorities.add(createOrGetAuthority(adminUser, "BOM_UPLOAD"));
            authorities.add(createOrGetAuthority(adminUser, "BOM_GET"));
            authorities.add(createOrGetAuthority(adminUser, "QUALITY_CHECK"));
            authorities.add(createOrGetAuthority(adminUser, "FULL_ACCESS"));
            role.setAuthorities(authorities);
            userRoleRepository.save(role);
            return authorities;
        }catch(Exception e){
            throw e;
        }
    }


    private Authority createOrGetAuthority(User user, String authorityName) {
        try {
            Optional<Authority> authorityOptional = authorityRepository.findByName(authorityName);

            Authority authority;
            if (!authorityOptional.isPresent()) {
                authority = new Authority();
                authority.setAuthorityId("ID_"+authorityName);
                authority.setName(authorityName);
                authority.setDescription("Permission to " + authorityName);
                authority.setCreated_at(new Date());
                authority.setCreatedBy(user);
                authority.setUpdated_at(new Date());
                authorityRepository.save(authority);
            } else {
                authority = authorityOptional.get();
            }

            return authority;
        }catch (Exception e){
            System.out.println("not able to create Authorities, error:- "+e.getMessage());
            return null;
        }
    }

    public ApiAccessControl createApiAccessControl(String endpointPath, String httpMethod, Set<String> authorityNames, Boolean isPublic) {
        Optional<ApiAccessControl> existingAccessControl = apiAccessControlRepository.findByEndpointPath(endpointPath);
        ApiAccessControl apiAccessControl;
        if (existingAccessControl.isPresent()) {
            // If the endpoint already exists, update it
            apiAccessControl = existingAccessControl.get();
            apiAccessControl.setPublic(isPublic);  // Update public status
            // Clear existing authorities and update with new ones
            apiAccessControl.getAuthorities().clear();
        } else {
            // Create a new ApiAccessControl if it doesn't exist
            apiAccessControl = new ApiAccessControl();
            apiAccessControl.setEndpointPath(endpointPath);
            apiAccessControl.setPublic(isPublic);
        }
        if(!authorityNames.isEmpty()) {
            // Fetch authorities by their names and assign them to ApiAccessControl
            Set<Authority> authorities = new HashSet<>();
            for (String authorityName : authorityNames) {
                Authority authority = authorityRepository.findByName(authorityName).orElseThrow(() ->
                        new RuntimeException("Authority not found: " + authorityName));
                authorities.add(authority);
            }
            apiAccessControl.setAuthorities(authorities);
        }

        // Save the ApiAccessControl entity (either created or updated) to the database
        return apiAccessControlRepository.save(apiAccessControl);
    }

    public List<Project> createDefaultProjects(User adminUser) {
        List<String> projectNames = Arrays.asList("LCV", "MDV","OLD_SYSTEM");
        List<Project> projects = new ArrayList<>();

        for (String projectName : projectNames) {
            Optional<Project> existingProject = projectRepository.findById(projectName);
            if (existingProject.isEmpty()) {
                Project newProject = new Project();
                newProject.setProjectId(projectName);
                newProject.setName(projectName);
                newProject.setDescription("Default project for " + projectName);
                newProject.setCreatedBy(adminUser);
                Date creationDate = new Date();
                newProject.setCreatedAt(creationDate);
                newProject.setUpdatedAt(creationDate);

                Project savedProject = projectRepository.save(newProject);
                projects.add(savedProject);
            } else {
                projects.add(existingProject.get());
            }
        }
        return projects;
    }

    public List<Model> createDefaultModelsForProject(Project project) {
        List<Model> models = new ArrayList<>();
        if (project.getName().equalsIgnoreCase("LCV")) {
            List<String> lcvModelNames = Arrays.asList("PARTNER_TRIMMED","PARTNER_SHELL","BADA_DOST_TRIMMED","BADA_DOST_SHELL","DOST_TRIMMED","DOST_LEO_TRIMMED","DOST_SHELL","DOST_PLUS_TRIMMED","DOST_PLUS_SHELL","MITR");
            for (String modelName : lcvModelNames) {
                Optional<Model> existingModel = modelRepository.findByModelIdAndProject(modelName, project);
                if (existingModel.isEmpty()) {
                    Model newModel = new Model();
                    newModel.setModelId(modelName);
                    newModel.setName(modelName);
                    newModel.setDescription("Default model for " + modelName);
                    newModel.setCreatedBy(project.getCreatedBy());
                    newModel.setCreatedAt(new Date());
                    newModel.setUpdatedAt(new Date());
                    newModel.setUpdatedBy(project.getCreatedBy());
                    newModel.setProject(project);

                    Model savedModel = modelRepository.save(newModel);
                    models.add(savedModel);
                } else {
                    models.add(existingModel.get());
                }
            }
        }

        if (project.getName().equalsIgnoreCase("MDV")) {
            List<String> mdvModelNames = Arrays.asList("1616iL_SL","1212_DAY","1214_SL","1214_DAY","1012_DAY","1618_2C_SL","1618_3C_SL","2518H_SL","2518T_DAY","9016_DAY");
            for (String modelName : mdvModelNames) {
                Optional<Model> existingModel = modelRepository.findByModelIdAndProject(modelName, project);
                if (existingModel.isEmpty()) {
                    Model newModel = new Model();
                    newModel.setModelId(modelName);
                    newModel.setName(modelName);
                    newModel.setDescription("Default model for " + modelName);
                    newModel.setCreatedBy(project.getCreatedBy());
                    newModel.setCreatedAt(new Date());
                    newModel.setUpdatedAt(new Date());
                    newModel.setUpdatedBy(project.getCreatedBy());
                    newModel.setProject(project);

                    Model savedModel = modelRepository.save(newModel);
                    models.add(savedModel);
                } else {
                    models.add(existingModel.get());
                }
            }
        }
        if (project.getName().equalsIgnoreCase("OLD_SYSTEM")) {
            List<ProjectMaster> legacyProjects = projectMasterRepository.findAll(); // assumes JPA repo for MySQL ProjectMaster
            for (ProjectMaster pm : legacyProjects) {
                String modelId = pm.getProjectName().replaceAll("\\s+", "_");
                String finalModelId = "OLD_"+pm.getProjectId()+":"+modelId;
                Optional<Model> existingModel = modelRepository.findByModelIdAndProject(finalModelId, project);
                if (existingModel.isEmpty()) {
                    Model newModel = new Model();
                    newModel.setModelId(finalModelId);
                    newModel.setName(modelId);
                    newModel.setDescription(
                            "projectCode=" + pm.getProjectCode() + ", " +
                                    "location=" + pm.getProjectLocation() + ", " +
                                    "city=" + pm.getCity() + ", " +
                                    "postalCode=" + pm.getPostalCode() + ", " +
                                    "state=" + pm.getState() + ", " +
                                    "country=" + pm.getCountry() + ", " +
                                    "destinationLocation=" + pm.getDestinationLocation() + ", " +
                                    "buyerName=" + pm.getBuyerName() + ", " +
                                    "designation=" + pm.getDesignation() + ", " +
                                    "telephone=" + pm.getTelephone() + ", " +
                                    "mobile=" + pm.getMobile() + ", " +
                                    "email=" + pm.getEmail() + ", " +
                                    "webAddress=" + pm.getWebAddress() + ", " +
                                    "status=" + pm.getStatus()
                    );
                    newModel.setCreatedBy(project.getCreatedBy());
                    newModel.setCreatedAt(java.sql.Timestamp.valueOf(pm.getCreatedDate()));
                    newModel.setUpdatedAt(java.sql.Timestamp.valueOf(pm.getCreatedDate()));
                    newModel.setUpdatedBy(project.getCreatedBy());
                    newModel.setProject(project);

                    models.add(modelRepository.save(newModel));
                } else {
                    models.add(existingModel.get());
                }
            }
        }

        return models;
    }

    public List<OriginCustomer> createDefaultOriginCustomers(User adminUser) {
        List<OriginCustomer> customers = new ArrayList<>();
        List<String> customerNames = Arrays.asList("ALH1_IND","ALH2_IND","VST_IND","OLD_IND","OLD_PHL","OLD_KEN","OLD_BGD");

        for (String name : customerNames) {
            Optional<OriginCustomer> existingCustomer = originCustomerRepository.findById(name);
            if (existingCustomer.isEmpty()) {
                OriginCustomer newCustomer = new OriginCustomer();
                String[] parts = name.split("_", 2);
                String customerName = parts[0].isEmpty() ? "DefaultCustomer" : parts[0];
                String countryCode = parts.length > 1 ? parts[1] : "Unknown";
                newCustomer.setOriginCustomerId(name);
                newCustomer.setName(name);
                newCustomer.setDescription("Default customer " + name);
                newCustomer.setCountry(countryCode);
                newCustomer.setCity("City");
                newCustomer.setAddress("Address for " + name);
                newCustomer.setPostalCode("000000");
                newCustomer.setContactName(customerName);
                newCustomer.setContactPhoneNo("1234567890");
                newCustomer.setCreatedBy(adminUser);
                newCustomer.setUpdatedBy(adminUser);
                newCustomer.setCreatedAt(new Date());
                newCustomer.setUpdatedAt(new Date());

                OriginCustomer savedCustomer = originCustomerRepository.save(newCustomer);
                customers.add(savedCustomer);
            } else {
                customers.add(existingCustomer.get());
            }
        }
        return customers;
    }



    public List<EndCustomer> createDefaultEndCustomers(User adminUser) {
        List<EndCustomer> customers = new ArrayList<>();
        List<String> customerNames = Arrays.asList("RAK_UAE","IFAP_BGD","LAL_LKA","AL_KEN","_UGA","_AU","_MAR");

        for (String name : customerNames) {
            Optional<EndCustomer> existingCustomer = endCustomerRepository.findById(name);
            if (existingCustomer.isEmpty()) {
                EndCustomer newCustomer = new EndCustomer();
                String[] parts = name.split("_", 2);
                String customerName = parts[0].isEmpty() ? "DefaultCustomer" : parts[0];
                String countryCode = parts.length > 1 ? parts[1] : "Unknown";
                newCustomer.setEndCustomerId(name);
                newCustomer.setName(name);
                newCustomer.setDescription("Default customer " + name);
                newCustomer.setCountry(countryCode);
                newCustomer.setCity("City");
                newCustomer.setAddress("Address for " + name);
                newCustomer.setPostalCode("000000");
                newCustomer.setContactName(customerName);
                newCustomer.setContactPhoneNo("1234567890");
                newCustomer.setCreatedBy(adminUser);
                newCustomer.setUpdatedBy(adminUser);
                newCustomer.setCreatedAt(new Date());
                newCustomer.setUpdatedAt(new Date());

                EndCustomer savedCustomer = endCustomerRepository.save(newCustomer);
                customers.add(savedCustomer);
            } else {
                customers.add(existingCustomer.get());
            }
        }

        List<CustomerMaster> customerMasters = customerMasterRepository.findAll();

        for (CustomerMaster cm : customerMasters) {
            String nameCleaned = cm.getName().replaceAll("\\s+", "");
            String endCustomerId = "OLD_"+cm.getCustomerId() + ":" + nameCleaned;

            if (!endCustomerRepository.existsById(endCustomerId)) {
                EndCustomer ec = new EndCustomer();

                ec.setEndCustomerId(endCustomerId);
                ec.setName(cm.getName());

                ec.setCountry(cm.getCountry() != null ? cm.getCountry() : "Unknown");
                ec.setState(cm.getState());
                ec.setCity(cm.getCity());

                ec.setAddress((cm.getAddress1() != null ? cm.getAddress1() : "") +
                        (cm.getAddress2() != null ? ", " + cm.getAddress2() : ""));

                ec.setPostalCode((cm.getPostalCode() != null && !cm.getPostalCode().isBlank())
                        ? cm.getPostalCode()
                        : "000000");

                ec.setContactName((cm.getContactName() != null && !cm.getContactName().isBlank())
                        ? cm.getContactName()
                        : "Default Contact");

                ec.setContactDesignation(cm.getDesignation());

                ec.setContactPhoneNo((cm.getPhone() != null && !cm.getPhone().isBlank())
                        ? cm.getPhone()
                        : "0000000000");

                ec.setWebsite(cm.getWebAddress());

                // Description assembled from all other fields
                String description = String.format(
                        "Customer Code: %s, Email: %s, Mobile: %s, Country: %s, State: %s, City: %s, " +
                                "Postal: %s, Contact Name: %s, Designation: %s, Phone: %s, Web: %s, " +
                                "Customer Location: %s, Logo: %s",
                        cm.getCustomerCode(), cm.getEmail(), cm.getMobile(), cm.getCountry(), cm.getState(),
                        cm.getCity(), cm.getPostalCode(), cm.getContactName(), cm.getDesignation(),
                        cm.getPhone(), cm.getWebAddress(), cm.getCustomerLocation(), cm.getCustomerLogo()
                );
                ec.setDescription(description);

                ec.setCreatedBy(adminUser);
                ec.setUpdatedBy(adminUser);
                ec.setCreatedAt(cm.getCreatedDate() != null ? java.sql.Timestamp.valueOf(cm.getCreatedDate()) : new Date());
                ec.setUpdatedAt(new Date());

                customers.add(endCustomerRepository.save(ec));
            }
        }


        return customers;
    }




    public EndCustomer convertCustomerToEndCustomer(CustomerMaster cm, User adminUser) {
        EndCustomer ec = new EndCustomer();

        // Generate ID: <customerId>:<name without whitespace>
        String nameCleaned = cm.getName().replaceAll("\\s+", "");
        ec.setEndCustomerId(cm.getCustomerId() + ":" + nameCleaned);

        ec.setName(cm.getName());
        ec.setCountry(cm.getCountry());
        ec.setState(cm.getState());
        ec.setCity(cm.getCity());
        ec.setAddress((cm.getAddress1() != null ? cm.getAddress1() : "") +
                (cm.getAddress2() != null ? ", " + cm.getAddress2() : ""));
        ec.setPostalCode(cm.getPostalCode());
        ec.setContactName(cm.getContactName());
        ec.setContactDesignation(cm.getDesignation());
        ec.setContactPhoneNo(cm.getPhone());
        ec.setWebsite(cm.getWebAddress());

        // Build description from remaining fields
        String description = String.format(
                "Customer Code: %s, Email: %s, Mobile: %s, Country: %s, State: %s, City: %s, " +
                        "Postal: %s, Contact Name: %s, Designation: %s, Phone: %s, Web: %s, " +
                        "Customer Location: %s, Logo: %s",
                cm.getCustomerCode(), cm.getEmail(), cm.getMobile(), cm.getCountry(), cm.getState(),
                cm.getCity(), cm.getPostalCode(), cm.getContactName(), cm.getDesignation(),
                cm.getPhone(), cm.getWebAddress(), cm.getCustomerLocation(), cm.getCustomerLogo()
        );
        ec.setDescription(description);

        ec.setCreatedBy(adminUser);
        ec.setUpdatedBy(adminUser);
        ec.setCreatedAt(java.sql.Timestamp.valueOf(cm.getCreatedDate()));
        ec.setUpdatedAt(java.sql.Timestamp.valueOf(cm.getCreatedDate()));

        return ec;
    }


}
