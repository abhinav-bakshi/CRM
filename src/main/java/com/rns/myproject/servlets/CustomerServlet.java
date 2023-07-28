package com.rns.myproject.servlets;

import com.rns.myproject.entities.Customer;
import com.rns.myproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet{

//    private final CustomerService customerService;
//
//    @Autowired
//    public CustomerServlet(CustomerService customerService) {
//        this.customerService = customerService;
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Perform any server-side logic here if needed

        // Forward the request to the customerPage.jsp
        request.getRequestDispatcher("/WEB-INF/jsp/customerPage.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters from "customerPage.jsp"
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");


//        Customer customer = new Customer(1, firstName, lastName, email);
//
//        customerService.addCustomer(customer);

        // Process the form data and save/update the customer entity (You can add your own logic here)

        // Redirect back to the home page or any other appropriate page
        response.sendRedirect("/");
    }
}
