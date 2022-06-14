package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.CustomerNotFoundException;
import com.example.FE019W_beadando.model.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer selectCustomer(int id) throws CustomerNotFoundException;

    List selectEveryCustomer();

    boolean idInUse(int id);

    void updateCustomer(int id, Customer customer) throws CustomerNotFoundException;

    void insertCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
