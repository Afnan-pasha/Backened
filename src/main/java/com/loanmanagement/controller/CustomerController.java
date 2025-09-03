//package com.loanmanagement.controller;
//
//import com.loanmanagement.model.Customer;
//import com.loanmanagement.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/customers")
//@CrossOrigin(origins = "*")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping("/profile")
//    public ResponseEntity<CustomerProfileResponse> getProfile(Authentication authentication) {
//        Customer customer = (Customer) authentication.getPrincipal();
//        CustomerProfileResponse profile = new CustomerProfileResponse(customer);
//        return ResponseEntity.ok(profile);
//    }
//
//    @PutMapping("/profile")
//    public ResponseEntity<?> updateProfile(@RequestBody CustomerUpdateRequest request,
//                                           Authentication authentication) {
//        try {
//            Customer customer = (Customer) authentication.getPrincipal();
//
//            // Update customer fields
//            if (request.getFirstName() != null) customer.setFirstName(request.getFirstName());
//            if (request.getLastName() != null) customer.setLastName(request.getLastName());
//            if (request.getPhoneNumber() != null) customer.setPhoneNumber(request.getPhoneNumber());
//            if (request.getDateOfBirth() != null) customer.setDateOfBirth(request.getDateOfBirth());
//            if (request.getAddress() != null) customer.setAddress(request.getAddress());
//            if (request.getAnnualIncome() != null) customer.setAnnualIncome(request.getAnnualIncome());
//            if (request.getEmploymentStatus() != null) customer.setEmploymentStatus(request.getEmploymentStatus());
//            if (request.getCreditScore() != null) customer.setCreditScore(request.getCreditScore());
//
//            Customer updatedCustomer = customerService.updateCustomer(customer);
//            CustomerProfileResponse profile = new CustomerProfileResponse(updatedCustomer);
//
//            return ResponseEntity.ok(profile);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Profile update failed: " + e.getMessage());
//        }
//    }
//
//    // Inner classes for DTOs
//    public static class CustomerProfileResponse {
//        private Long id;
//        private String firstName;
//        private String lastName;
//        private String email;
//        private String phoneNumber;
//        private String dateOfBirth;
//        private String address;
//        private Double annualIncome;
//        private String employmentStatus;
//        private Integer creditScore;
//
//        public CustomerProfileResponse(Customer customer) {
//            this.id = customer.getId();
//            this.firstName = customer.getFirstName();
//            this.lastName = customer.getLastName();
//            this.email = customer.getEmail();
//            this.phoneNumber = customer.getPhoneNumber();
//            this.dateOfBirth = customer.getDateOfBirth();
//            this.address = customer.getAddress();
//            this.annualIncome = customer.getAnnualIncome();
//            this.employmentStatus = customer.getEmploymentStatus();
//            this.creditScore = customer.getCreditScore();
//        }
//
//        // Getters and Setters
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getFirstName() {
//            return firstName;
//        }
//
//        public void setFirstName(String firstName) {
//            this.firstName = firstName;
//        }
//
//        public String getLastName() {
//            return lastName;
//        }
//
//        public void setLastName(String lastName) {
//            this.lastName = lastName;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getPhoneNumber() {
//            return phoneNumber;
//        }
//
//        public void setPhoneNumber(String phoneNumber) {
//            this.phoneNumber = phoneNumber;
//        }
//
//        public String getDateOfBirth() {
//            return dateOfBirth;
//        }
//
//        public void setDateOfBirth(String dateOfBirth) {
//            this.dateOfBirth = dateOfBirth;
//        }
//
//        public String getAddress() {
//            return address;
//        }
//
//        public void setAddress(String address) {
//            this.address = address;
//        }
//
//        public Double getAnnualIncome() {
//            return annualIncome;
//        }
//
//        public void setAnnualIncome(Double annualIncome) {
//            this.annualIncome = annualIncome;
//        }
//
//        public String getEmploymentStatus() {
//            return employmentStatus;
//        }
//
//        public void setEmploymentStatus(String employmentStatus) {
//            this.employmentStatus = employmentStatus;
//        }
//
//        public Integer getCreditScore() {
//            return creditScore;
//        }
//
//        public void setCreditScore(Integer creditScore) {
//            this.creditScore = creditScore;
//        }
//    }
//
//    public static class CustomerUpdateRequest {
//        private String firstName;
//        private String lastName;
//        private String phoneNumber;
//        private String dateOfBirth;
//        private String address;
//        private Double annualIncome;
//        private String employmentStatus;
//        private Integer creditScore;
//
//        // Getters and Setters
//        public String getFirstName() {
//            return firstName;
//        }
//
//        public void setFirstName(String firstName) {
//            this.firstName = firstName;
//        }
//
//        public String getLastName() {
//            return lastName;
//        }
//
//        public void setLastName(String lastName) {
//            this.lastName = lastName;
//        }
//
//        public String getPhoneNumber() {
//            return phoneNumber;
//        }
//
//        public void setPhoneNumber(String phoneNumber) {
//            this.phoneNumber = phoneNumber;
//        }
//
//        public String getDateOfBirth() {
//            return dateOfBirth;
//        }
//
//        public void setDateOfBirth(String dateOfBirth) {
//            this.dateOfBirth = dateOfBirth;
//        }
//
//        public String getAddress() {
//            return address;
//        }
//
//        public void setAddress(String address) {
//            this.address = address;
//        }
//
//        public Double getAnnualIncome() {
//            return annualIncome;
//        }
//
//        public void setAnnualIncome(Double annualIncome) {
//            this.annualIncome = annualIncome;
//        }
//
//        public String getEmploymentStatus() {
//            return employmentStatus;
//        }
//
//        public void setEmploymentStatus(String employmentStatus) {
//            this.employmentStatus = employmentStatus;
//        }
//
//        public Integer getCreditScore() {
//            return creditScore;
//        }
//
//        public void setCreditScore(Integer creditScore) {
//            this.creditScore = creditScore;
//        }
//    }
//}
