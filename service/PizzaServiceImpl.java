package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.PizzaNotFoundException;
import com.example.FE019W_beadando.model.Pizza;
import com.example.FE019W_beadando.persist.PizzaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    private PizzaDAO pizzaDAO;

    @Autowired
    public PizzaServiceImpl(PizzaDAO pizzaDAO) {
        this.pizzaDAO = pizzaDAO;
    }

    @Override
    public Pizza getPizza(int id) throws PizzaNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return pizzaDAO.selectPizza(id);
    }

    @Override
    public List getAllPizza() {
        return pizzaDAO.selectEveryPizza();
    }

    @Override
    public void addPizza(Pizza pizza) {
        if (pizza.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (pizzaDAO.idInUse(pizza.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        pizzaDAO.insertPizza(pizza);
    }

    @Override
    public void updatePizza(int id, Pizza pizza) throws PizzaNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        pizzaDAO.updatePizza(id, pizza);
    }

    @Override
    public void removePizza(Pizza pizza) {
        if (pizza.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        pizzaDAO.deletePizza(pizza);
    }
}
