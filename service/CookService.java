package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.model.Cook;

import java.util.List;

public interface CookService {

    Cook getCook(int id) throws CookNotFoundException;

    List getAllCook();

    void addCook(Cook cook);

    void updateCook(int id, Cook cook) throws CookNotFoundException;

    void removeCook(Cook cook);
}
