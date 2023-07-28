package com.rns.myproject.dao;

import com.rns.myproject.entities.Customer;
import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(int id);
    void deleteCustomer(int id);
}
