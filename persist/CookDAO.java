package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.model.Cook;

import java.util.List;

public interface CookDAO {
    Cook selectCook(int id) throws CookNotFoundException;

    List selectEveryCook();

    boolean idInUse(int id);

    void updateCook(int id, Cook cook) throws CookNotFoundException;

    void insertCook(Cook cook);

    void deleteCook(Cook cook);
}
