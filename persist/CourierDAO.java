package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.CourierNotFoundException;
import com.example.FE019W_beadando.model.Courier;

import java.util.List;

public interface CourierDAO {
    Courier selectCourier(int id) throws CourierNotFoundException;

    List selectEveryCourier();

    boolean idInUse(int id);

    void updateCourier(int id, Courier courier) throws CourierNotFoundException;

    void insertCourier(Courier courier);

    void deleteCourier(Courier courier);
}
