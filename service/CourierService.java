package com.example.FE019W_beadando.service;

import com.example.FE019W_beadando.exception.CourierNotFoundException;
import com.example.FE019W_beadando.model.Courier;

import java.util.List;

public interface CourierService {

    Courier getCourier(int id) throws CourierNotFoundException;

    List getAllCourier();

    void addCourier(Courier courier);

    void updateCourier(int id, Courier courier) throws CourierNotFoundException;

    void removeCourier(Courier courier);
}
