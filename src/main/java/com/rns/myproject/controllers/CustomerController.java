package com.rns.myproject.controllers;

import com.rns.myproject.entities.Customer;
import com.rns.myproject.ORMConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.rns.myproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    public CustomerController(CustomerService customerService) {}
    @RequestMapping("")
    @GetMapping
    public String homePage() {
        return "homePage";
    }
}