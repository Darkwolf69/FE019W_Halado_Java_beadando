package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.PizzaNotFoundException;
import com.example.FE019W_beadando.model.Customer;
import com.example.FE019W_beadando.model.Pizza;

import java.util.List;

public interface PizzaDAO {
    Pizza selectPizza(int id) throws PizzaNotFoundException;

    List selectEveryPizza();

    boolean idInUse(int id);

    void updatePizza(int id, Pizza pizza) throws PizzaNotFoundException;

    void insertPizza(Pizza pizza);

    void deletePizza(Pizza pizza);
}
