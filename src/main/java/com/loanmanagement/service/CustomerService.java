//package com.loanmanagement.service;
//
//import com.loanmanagement.model.Customer;
//import com.loanmanagement.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomerService implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public CustomerService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return customerRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));
//    }
//
//    public Customer registerCustomer(Customer customer) {
//        if (customerRepository.existsByEmail(customer.getEmail())) {
//            throw new RuntimeException("Email already exists");
//        }
//
//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//        return customerRepository.save(customer);
//    }
//
//    public Optional<Customer> findByEmail(String email) {
//        return customerRepository.findByEmail(email);
//    }
//
//    public Customer updateCustomer(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public Optional<Customer> findById(Long id) {
//        return customerRepository.findById(id);
//    }
//}
