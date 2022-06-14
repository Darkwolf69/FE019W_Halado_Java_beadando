package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.CourierNotFoundException;
import com.example.FE019W_beadando.model.Courier;
import com.example.FE019W_beadando.persist.CourierDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

    private CourierDAO courierDAO;

    @Autowired
    public CourierServiceImpl(CourierDAO courierDAO) {
        this.courierDAO = courierDAO;
    }

    @Override
    public Courier getCourier(int id) throws CourierNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        return courierDAO.selectCourier(id);
    }

    @Override
    public List getAllCourier() {
        return courierDAO.selectEveryCourier();
    }

    @Override
    public void addCourier(Courier courier) {
        if (courier.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (courierDAO.idInUse(courier.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        courierDAO.insertCourier(courier);
    }

    @Override
    public void updateCourier(int id, Courier courier) throws CourierNotFoundException {
        if (id < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        courierDAO.updateCourier(id, courier);
    }

    @Override
    public void removeCourier(Courier courier) {
        if (courier.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        courierDAO.deleteCourier(courier);
    }
}
