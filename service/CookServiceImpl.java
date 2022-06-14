package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.model.Cook;
import com.example.FE019W_beadando.persist.CookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FE019W_beadando.persist.PizzaDAOImpl;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class CookServiceImpl implements CookService {

    private CookDAO cookDAO;

    @Autowired
    public CookServiceImpl(CookDAO cookDAO) {
        this.cookDAO = cookDAO;
    }

    @Override
    public Cook getCook(int id) throws CookNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return cookDAO.selectCook(id);
    }

    @Override
    public List getAllCook() {
        return cookDAO.selectEveryCook();
    }

    @Override
    public void addCook(Cook cook) {
        if (cook.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (cookDAO.idInUse(cook.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        cookDAO.insertCook(cook);
    }

    @Override
    public void updateCook(int id, Cook cook) throws CookNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        cookDAO.updateCook(id, cook);
    }

    @Override
    public void removeCook(Cook cook) {
        if (cook.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        cookDAO.deleteCook(cook);
    }
}
