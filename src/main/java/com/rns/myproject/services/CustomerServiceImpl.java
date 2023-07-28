package com.rns.myproject.services;

import com.rns.myproject.ORMConnection;
import com.rns.myproject.entities.Customer;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();

        try (Connection connection = ORMConnection.getConnection()) {
            String query = "SELECT * FROM customers";
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String email = resultSet.getString("email");

                        Customer customer = new Customer(id, firstName, lastName, email);
                        customerList.add(customer);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        try (Connection connection = ORMConnection.getConnection()) {
            String query = "INSERT INTO customers (first_name, last_name, email) VALUES (?, ?, ?)";
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, customer.getFirstName());
                    statement.setString(2, customer.getLastName());
                    statement.setString(3, customer.getEmail());

                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        try (Connection connection = ORMConnection.getConnection()) {
            String query = "SELECT * FROM customers WHERE id = ?";
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            String firstName = resultSet.getString("first_name");
                            String lastName = resultSet.getString("last_name");
                            String email = resultSet.getString("email");

                            return new Customer(id, firstName, lastName, email);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteCustomer(int id) {
        try (Connection connection = ORMConnection.getConnection()) {
            String query = "DELETE FROM customers WHERE id = ?";
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, id);
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
