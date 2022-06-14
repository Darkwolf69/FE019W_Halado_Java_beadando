package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.PizzaNotFoundException;
import com.example.FE019W_beadando.model.Pizza;

import java.util.List;

public interface PizzaService {
    
    Pizza getPizza(int id) throws PizzaNotFoundException;

    List getAllPizza();

    void addPizza(Pizza pizza);

    void updatePizza(int id, Pizza pizza) throws PizzaNotFoundException;

    void removePizza(Pizza pizza);
}
