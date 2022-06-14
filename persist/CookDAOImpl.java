package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.model.Cook;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CookDAOImpl implements CookDAO {

    private Map<Integer, Cook> cookMap;

    public CookDAOImpl() {
        cookMap = new HashMap<>();
        cookMap.put(1, new Cook(1, "Jamie Oliver", 47, 250000, 1));
        cookMap.put(2, new Cook(2, "Széll Tamás", 39, 280000, 3));
        cookMap.put(3, new Cook(3, "Gordon Ramsay", 55, 300000, 5));
    }

    @Override
    public Cook selectCook(int id) throws CookNotFoundException {
        if (!cookMap.containsKey(id)) {
            throw new CookNotFoundException();
        }
        return cookMap.get(id);
    }

    public boolean idInUse(int id) {
        return cookMap.containsKey(id);
    }

    @Override
    public List selectEveryCook() {
        List<Cook> cookList = cookMap.values().stream().collect(Collectors.toList());
        return cookList;
    }

    @Override
    public void updateCook(int id, Cook cook) throws CookNotFoundException {
        if (!cookMap.containsKey(id)) {
            throw new CookNotFoundException("The given object not found.");
        }
        cookMap.replace(id, cook);
    }

    @Override
    public void insertCook(Cook cook) { cookMap.put(cook.getId(), cook); }

    @Override
    public void deleteCook(Cook cook) {
        cookMap.remove(cook.getId());
    }
}
