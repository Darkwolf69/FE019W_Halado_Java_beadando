package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.CustomerNotFoundException;
import com.example.FE019W_beadando.model.Customer;
import com.example.FE019W_beadando.persist.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer getCustomer(int id) throws CustomerNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return customerDAO.selectCustomer(id);
    }

    @Override
    public List getAllCustomer() {
        return customerDAO.selectEveryCustomer();
    }

    @Override
    public void addCustomer(Customer customer) {
        if (customer.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (customerDAO.idInUse(customer.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        customerDAO.insertCustomer(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) throws CustomerNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        customerDAO.updateCustomer(id, customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        if (customer.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        customerDAO.deleteCustomer(customer);
    }
}
