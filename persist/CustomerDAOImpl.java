package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.CustomerNotFoundException;
import com.example.FE019W_beadando.model.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomerDAOImpl implements CustomerDAO {

    private Map<Integer, Customer> customerMap;

    public CustomerDAOImpl() {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "Kajás Balázs", 304445566, "Miskolc, nem létező utca 3", 1));
        customerMap.put(2, new Customer(2, "Éhes Péter", 306662233, "Tardona, xy utca 10", 3));
        customerMap.put(3, new Customer(3, "Haspók Jankó", 305555555, "Mályi, valamilyen utca 26", 1));
        customerMap.put(4, new Customer(4, "Bélpoklos Jeromos", 304444444, "Miskolc, bármilyen utca 6", 2));
        customerMap.put(5, new Customer(5, "Falánk Fanni", 308888888, "Putnok, ottani utca 7", 1));
        customerMap.put(6, new Customer(6, "Ebéd Elek", 306666666, "Miskolc, hosszú utca 19", 2));
    }

    @Override
    public Customer selectCustomer(int id) throws CustomerNotFoundException {
        if (!customerMap.containsKey(id)) {
            throw new CustomerNotFoundException();
        }
        return customerMap.get(id);
    }

    public boolean idInUse(int id) {
        return customerMap.containsKey(id);
    }

    @Override
    public List selectEveryCustomer() {
        List<Customer> cookList = customerMap.values().stream().collect(Collectors.toList());
        return cookList;
    }

    @Override
    public void updateCustomer(int id, Customer customer) throws CustomerNotFoundException {
        if (!customerMap.containsKey(id)) {
            throw new CustomerNotFoundException("The given object not found.");
        }
        customerMap.replace(id, customer);
    }

    @Override
    public void insertCustomer(Customer customer) { customerMap.put(customer.getId(), customer); }

    @Override
    public void deleteCustomer(Customer customer) {
        customerMap.remove(customer.getId());
    }
}
