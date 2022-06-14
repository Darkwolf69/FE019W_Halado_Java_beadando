package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.CustomerNotFoundException;
import com.example.FE019W_beadando.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(int id) throws CustomerNotFoundException;

    List getAllCustomer();

    void addCustomer(Customer customer);

    void updateCustomer(int id, Customer customer) throws CustomerNotFoundException;

    void removeCustomer(Customer customer);
}
