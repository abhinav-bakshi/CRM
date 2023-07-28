package com.rns.myproject.services;

import com.rns.myproject.entities.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
    Customer getCustomerById(int id);
    void deleteCustomer(int id);
}
