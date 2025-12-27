// SpringappApplicationTests.java
package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void Day3_test_Controller_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller").isDirectory());
    }

    @Test
    @Order(2)
    void Day3_test_Model_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model").isDirectory());
    }

    @Test
    @Order(3)
    void Day3_test_Service_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service").isDirectory());
    }

    @Test
    @Order(4)
    void Day3_test_Repository_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository").isDirectory());
    }

    @Test
    @Order(5)
    void Day4_test_CustomerModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Customer.java").isFile());
    }

    @Test
    @Order(6)
    void Day4_test_LoanTypeModel_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/LoanType.java").isFile());
    }

    @Test
    @Order(7)
    void Day4_test_Loan_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Loan.java").isFile());
    }

    @Test
    @Order(8)
    void Day4_test_Payment_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Payment.java").isFile());
    }

    @Test
    @Order(9)
    void Day4_test_Guarantor_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/model/Guarantor.java").isFile());
    }

    @Test
    @Order(10)
    void Day4_test_Loan_Has_Entity_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.model.Loan");
            Class<?> annotation = Class.forName("jakarta.persistence.Entity");

            assertTrue(clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Entity annotation is missing on Loan class");

        } catch (ClassNotFoundException e) {
            fail("❌ Loan class not found.");
        } catch (Exception e) {
            fail("❌ Unable to check @Entity annotation on Loan.");
        }
    }

    @Test
    @Order(11)
    void test_Loan_Has_Id_Annotation_On_Field() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.model.Loan");
            Class<?> idAnnotation = Class.forName("jakarta.persistence.Id");

            boolean found = false;

            for (var field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent((Class<? extends Annotation>) idAnnotation)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No field in Loan class is annotated with @Id");

        } catch (ClassNotFoundException e) {
            fail("❌ Loan class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Id annotation in Loan class.");
        }
    }

    @Test
    @Order(12)
    void Day5_testCustomerRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/CustomerRepo.java").isFile());
    }

    @Test
    @Order(13)
    void Day5_testLoanTypeRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/LoanTypeRepo.java").isFile());
    }

    @Test
    @Order(14)
    void Day5_testLoanRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/LoanRepo.java").isFile());
    }



    @Test
    @Order(15)
    void Day5_testGuarantorRepo_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/repository/GuarantorRepo.java").isFile());
    }

    @Test
    @Order(16)
    void Day5_test_LoanRepo_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.LoanRepo");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Repository annotation is missing on LoanRepo class");

        } catch (ClassNotFoundException e) {
            fail("❌ LoanRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on LoanRepo.");
        }
    }

    @Test
    @Order(17)
    void Day5_test_CustomerRepo_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.CustomerRepo");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Repository annotation is missing on CustomerRepo class");

        } catch (ClassNotFoundException e) {
            fail("❌ CustomerRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on CustomerRepo.");
        }
    }

    @Test
    @Order(18)
    void Day5_test_GuarantorRepo_Has_Repository_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.repository.GuarantorRepo");
            Class<?> annotation = Class.forName("org.springframework.stereotype.Repository");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @Repository annotation is missing on GuarantorRepo class");

        } catch (ClassNotFoundException e) {
            fail("❌ GuarantorRepo class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @Repository annotation on GuarantorRepo.");
        }
    }

    @Test
    @Order(19)
    void Day6_test_CustomerController_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/controller/CustomerController.java").isFile());
    }


    @Test
    @Order(20)
    void Day6_test_LoanController_Has_RestController_Annotation() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.LoanController");
            Class<?> annotation = Class.forName("org.springframework.web.bind.annotation.RestController");

            assertTrue(
                    clazz.isAnnotationPresent((Class<? extends Annotation>) annotation),
                    "❌ @RestController annotation is missing on LoanController class");

        } catch (ClassNotFoundException e) {
            fail("❌ LoanController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RestController annotation on LoanController.");
        }
    }

    @Test
    @Order(21)
    void Day6_test_CustomerController_Has_PostMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CustomerController");
            Class<?> postMapping = Class.forName("org.springframework.web.bind.annotation.PostMapping");

            boolean found = false;

            for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) postMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No method with @PostMapping found in CustomerController");

        } catch (ClassNotFoundException e) {
            fail("❌ CustomerController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PostMapping annotation in CustomerController.");
        }
    }

    @Test
    @Order(22)
    void Day6_test_CustomerController_Has_GetMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CustomerController");
            Class<?> getMapping = Class.forName("org.springframework.web.bind.annotation.GetMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) getMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @GetMapping method found in CustomerController");

        } catch (ClassNotFoundException e) {
            fail("❌ CustomerController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @GetMapping in CustomerController.");
        }
    }

    @Test
    @Order(23)
    void Day6_test_CustomerController_Has_PutMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CustomerController");
            Class<?> putMapping = Class.forName("org.springframework.web.bind.annotation.PutMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) putMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @PutMapping method found in CustomerController");

        } catch (ClassNotFoundException e) {
            fail("❌ CustomerController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PutMapping in CustomerController.");
        }
    }

    @Test
    @Order(24)
    void Day6_test_CustomerController_Has_DeleteMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CustomerController");
            Class<?> deleteMapping = Class.forName("org.springframework.web.bind.annotation.DeleteMapping");

            boolean found = false;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent((Class<? extends Annotation>) deleteMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @DeleteMapping method found in CustomerController");

        } catch (ClassNotFoundException e) {
            fail("❌ CustomerController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @DeleteMapping in CustomerController.");
        }
    }

    @Test
    @Order(25)
    public void Day6_testCreateCustomer_NoBody_StatusBadRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    @Order(26)
    void Day7_test_CustomerController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CustomerController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on CustomerController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ CustomerController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in CustomerController.");
        }
    }

    @Test
    @Order(27)
    void Day7_test_CustomerController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.CustomerController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

            assertTrue(found, "❌ No @PathVariable annotation found in any method parameter of CustomerController");

        } catch (ClassNotFoundException e) {
            fail("❌ CustomerController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in CustomerController.");
        }
    }

    @Test
    @Order(28)
    void Day7_test_LoanController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.LoanController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on LoanController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ LoanController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in LoanController.");
        }
    }

    @Test
    @Order(29)
    void Day7_test_LoanTypeController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.LoanTypeController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on LoanTypeController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ LoanTypeController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in LoanTypeController.");
        }
    }

    @Test
    @Order(30)
    void Day7_test_LoanController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.LoanController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of LoanController");

        } catch (ClassNotFoundException e) {
            fail("❌ LoanController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in LoanController.");
        }
    }

    @Test
    @Order(31)
    void Day7_test_LoanTypeController_Has_PathVariable() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.LoanTypeController");
            Class<?> pathVariable = Class.forName("org.springframework.web.bind.annotation.PathVariable");

            boolean found = false;

            for (Method method : clazz.getDeclaredMethods()) {
                for (Parameter param : method.getParameters()) {
                    if (param.isAnnotationPresent((Class<? extends Annotation>) pathVariable)) {
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

            assertTrue(found, "❌ No @PathVariable found in any method parameter of LoanTypeController");

        } catch (ClassNotFoundException e) {
            fail("❌ LoanTypeController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @PathVariable in LoanTypeController.");
        }
    }

    @Test
    @Order(32)
    void Day7_test_PaymentController_Has_RequestMapping() {
        try {
            Class<?> clazz = Class.forName("com.examly.springapp.controller.PaymentController");
            Class<?> requestMapping = Class.forName("org.springframework.web.bind.annotation.RequestMapping");

            boolean found = false;

            if (clazz.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                found = true;
            }

            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent((Class<? extends Annotation>) requestMapping)) {
                    found = true;
                    break;
                }
            }

            assertTrue(found, "❌ No @RequestMapping found on PaymentController (class or methods)");

        } catch (ClassNotFoundException e) {
            fail("❌ PaymentController class not found.");
        } catch (Exception e) {
            fail("❌ Unable to verify @RequestMapping in PaymentController.");
        }
    }

    @Test
    @Order(33)
    void Day8_test_CustomerService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/CustomerService.java").isFile());
    }

    @Test
    @Order(34)
    void Day8_test_LoanTypeService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/LoanTypeService.java").isFile());
    }

    @Test
    @Order(35)
    void Day8_test_LoanService_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/service/LoanService.java").isFile());
    }



    @Test
    @Order(36)
    public void Day8_testAddCustomer() throws Exception {
        String requestBody = "{ \"customerName\": \"John Doe\", \"email\": \"john@example.com\", \"phoneNumber\": \"1234567890\", \"address\": \"123 Main St\", \"creditScore\": 750.0 }";
    
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerName").value("John Doe"))
                .andReturn();
    }
    

    @Test
    @Order(37)
    public void Day8_testGetAllCustomers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].customerName").value("John Doe"))
                .andReturn();
    }

    @Test
    @Order(38)
    public void Day8_testGetCustomerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerName").value("John Doe"))
                .andReturn();
    }
    @Test
    @Order(39)
    public void Day8_testUpdateCustomer() throws Exception {
        String requestBody = "{ \"customerName\": \"John Updated\", \"email\": \"john.updated@example.com\", \"phoneNumber\": \"1234567890\", \"address\": \"456 New St\", \"creditScore\": 800.0 }";
    
        mockMvc.perform(MockMvcRequestBuilders.put("/api/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerName").value("John Updated"))
                .andReturn();
    }
    

    @Test
    @Order(40)
    public void Day9_testPagination_PageNumberApplied() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageNumber").value(0));
    }

    @Test
    @Order(41)
    public void Day9_testPagination_PageSizeApplied() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/page/1/10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.pageSize").value(10));
    }

    @Test
    @Order(42)
    public void Day9_testPagination_SortingPresent() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pageable.sort.sorted").isBoolean());
    }

    @Test
    @Order(43)
    public void Day9_testPagination_ContentArrayExists() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray());
    }

    @Test
    @Order(44)
    public void Day9_testPagination_TotalElementsExists() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").exists());
    }

    @Test
    @Order(45)
    public void Day9_testPagination_TotalPagesExists() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/page/0/5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").exists());
    }
    @Test
    @Order(46)
    public void Day10_testAddLoanType() throws Exception {
        String requestBody = "{ \"typeName\": \"Home Loan\", \"description\": \"Loan for home purchase\", \"interestRate\": 7.5 }";
    
        mockMvc.perform(MockMvcRequestBuilders.post("/api/loantypes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeName").value("Home Loan"))
                .andReturn();
    }
    

    @Test
    @Order(47)
    public void Day10_testGetAllLoanTypes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/loantypes")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].typeName").value("Home Loan"))
                .andReturn();
    }


    @Test
    @Order(48)
    public void Day10_testUpdateLoanType() throws Exception {
        String requestBody = "{ \"typeName\": \"Home Loan Updated\", \"description\": \"Updated description\", \"interestRate\": 7.0 }";
    
        mockMvc.perform(MockMvcRequestBuilders.put("/api/loantypes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.typeName").value("Home Loan Updated"))
                .andReturn();
    }
    

    @Test
    @Order(49)
    public void Day10_testAddLoan() throws Exception {
        String requestBody = "{ \"loanAmount\": 500000.0, \"interestRate\": 7.5, \"tenureMonths\": 240, \"status\": \"PENDING\", \"customer\": { \"customerId\": 1 }, \"loanType\": { \"loanTypeId\": 1 } }";
    
        mockMvc.perform(MockMvcRequestBuilders.post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.loanAmount").value(500000.0))
                .andReturn();
    }
    

    @Test
    @Order(50)
    public void Day10_testGetAllLoans() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/loans")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].loanAmount").value(500000.0))
                .andReturn();
    }

    @Test
    @Order(51)
    public void Day10_testGetLoanById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/loans/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loanId").value(1))
                .andReturn();
    }

    @Test
    @Order(52)
    public void Day10_testUpdateLoan() throws Exception {
        String requestBody = "{ \"loanAmount\": 600000.0, \"interestRate\": 7.0, \"tenureMonths\": 240, \"status\": \"APPROVED\", \"customer\": { \"customerId\": 1 }, \"loanType\": { \"loanTypeId\": 1 } }";
    
        mockMvc.perform(MockMvcRequestBuilders.put("/api/loans/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("APPROVED"))
                .andReturn();
    }
    

    @Test
    @Order(53)
    public void Day11_testGetLoansByStatus() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/loans/status/APPROVED")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("APPROVED"))
                .andReturn();
    }

    @Test
    @Order(54)
    public void Day12_testGetCustomerByEmail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/email/john.updated@example.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerName").value("John Updated"))
                .andReturn();
    }

    @Test
    @Order(55)
    public void Day12_testGetCustomersByCreditScore() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/creditScore/700.0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].customerName").value("John Updated"))
                .andReturn();
    }

    @Test
    @Order(56)
    public void Day12_testGetLoansByStatus_NotFound() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/loans/status/REJECTED")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().string("No loans found with status: REJECTED"));
    }

    @Test
    @Order(57)
    public void Day12_testGetCustomersByCreditScore_NotFound() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/creditScore/900.0")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("No customers found with credit score >= 900.0"));
    }
 
    @Test
    @Order(58)
    public void Day12_testGetCustomerByEmail_NotFound() throws Exception {
    
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/email/notfound@example.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(
                    org.hamcrest.Matchers.containsString("Customer not found with email: notfound@example.com")
                ));
    }


    @Test
    @Order(59)
    void Day13_test_exception_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception").isDirectory());
    }

    @Test
    @Order(60)
    void Day13_test_GlobalException_File_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/exception/GlobalExceptionHandler.java").isFile());
    }

    @Test
    @Order(61)
    void Day14_test_configuration_Directory_Exists() {
        assertTrue(new File("src/main/java/com/examly/springapp/configuration").isDirectory());
    }

    @Test
    @Order(62)
    public void Day15_testAOPLogFileExists() {
        assertTrue(new File("src/main/java/com/examly/springapp/aop").isDirectory());
    }

}