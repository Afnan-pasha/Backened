//package com.loanmanagement.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.time.LocalDateTime;
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//@Table(name = "customers")
//public class Customer implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "First name is required")
//    @Column(name = "first_name", nullable = false)
//    private String firstName;
//
//    @NotBlank(message = "Last name is required")
//    @Column(name = "last_name", nullable = false)
//    private String lastName;
//
//    @Email(message = "Please provide a valid email")
//    @NotBlank(message = "Email is required")
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    @NotBlank(message = "Password is required")
//    @Column(nullable = false)
//    private String password;
//
//    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    @Column(name = "date_of_birth")
//    private String dateOfBirth;
//
//    private String address;
//
//    @Column(name = "annual_income")
//    private Double annualIncome;
//
//    @Column(name = "employment_status")
//    private String employmentStatus;
//
//    @Column(name = "credit_score")
//    private Integer creditScore;
//
//    @Column(name = "created_at")
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDateTime.now();
//        updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDateTime.now();
//    }
//
//    // Constructors
//    public Customer() {}
//
//    public Customer(String firstName, String lastName, String email, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//    }
//
//    // UserDetails implementation
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getFirstName() { return firstName; }
//    public void setFirstName(String firstName) { this.firstName = firstName; }
//
//    public String getLastName() { return lastName; }
//    public void setLastName(String lastName) { this.lastName = lastName; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//
//    public String getPhoneNumber() { return phoneNumber; }
//    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
//
//    public String getDateOfBirth() { return dateOfBirth; }
//    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
//
//    public String getAddress() { return address; }
//    public void setAddress(String address) { this.address = address; }
//
//    public Double getAnnualIncome() { return annualIncome; }
//    public void setAnnualIncome(Double annualIncome) { this.annualIncome = annualIncome; }
//
//    public String getEmploymentStatus() { return employmentStatus; }
//    public void setEmploymentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; }
//
//    public Integer getCreditScore() { return creditScore; }
//    public void setCreditScore(Integer creditScore) { this.creditScore = creditScore; }
//
//    public LocalDateTime getCreatedAt() { return createdAt; }
//    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
//
//    public LocalDateTime getUpdatedAt() { return updatedAt; }
//    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
//}
