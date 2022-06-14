package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.PizzaNotFoundException;
import com.example.FE019W_beadando.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PizzaDAOImpl implements PizzaDAO {
    
    private Map<Integer, Pizza> pizzaMap;

    public PizzaDAOImpl() {
        pizzaMap = new HashMap<>();
        pizzaMap.put(1, new Pizza(1, "margherita", 30, 2000, 2));
        pizzaMap.put(2, new Pizza(2, "bolognese", 35, 3500, 1));
        pizzaMap.put(3, new Pizza(3, "magyaros", 40, 4000, 3));
        pizzaMap.put(4, new Pizza(4, "szalámis", 30, 2500, 1));
        pizzaMap.put(5, new Pizza(5, "carbonara", 45, 6000, 2));
    }

    @Override
    public Pizza selectPizza(int id) throws PizzaNotFoundException {
        if (!pizzaMap.containsKey(id)) {
            throw new PizzaNotFoundException();
        }
        return pizzaMap.get(id);
    }

    public boolean idInUse(int id) {
        return pizzaMap.containsKey(id);
    }

    @Override
    public List selectEveryPizza() {
        List<Pizza> pizzaList = pizzaMap.values().stream().collect(Collectors.toList());
        return pizzaList;
    }

    @Override
    public void updatePizza(int id, Pizza pizza) throws PizzaNotFoundException {
        if (!pizzaMap.containsKey(id)) {
            throw new PizzaNotFoundException("The given object not found.");
        }
        pizzaMap.replace(id, pizza);
    }

    @Override
    public void insertPizza(Pizza pizza) { pizzaMap.put(pizza.getId(), pizza); }

    @Override
    public void deletePizza(Pizza pizza) {
        pizzaMap.remove(pizza.getId());
    }
}
