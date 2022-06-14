package com.example.FE019W_beadando.persist;

import com.example.FE019W_beadando.exception.CourierNotFoundException;
import com.example.FE019W_beadando.model.Courier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CourierDAOImpl implements CourierDAO {

    private Map<Integer, Courier> courierMap;

    public CourierDAOImpl() {
        courierMap = new HashMap<>();
        courierMap.put(1, new Courier(1, "Gyors Gyula", 28, 150000, "Babetta"));
        courierMap.put(2, new Courier(2, "Fürge Fritz", 34, 170000, "Simson"));
        courierMap.put(3, new Courier(3, "Sebes Lehel", 32, 190000, "KTM"));
    }

    @Override
    public Courier selectCourier(int id) throws CourierNotFoundException {
        if (!courierMap.containsKey(id)) {
            throw new CourierNotFoundException();
        }
        return courierMap.get(id);
    }

    public boolean idInUse(int id) {
        return courierMap.containsKey(id);
    }

    @Override
    public List selectEveryCourier() {
        List<Courier> courierList = courierMap.values().stream().collect(Collectors.toList());
        return courierList;
    }

    @Override
    public void updateCourier(int id, Courier courier) throws CourierNotFoundException {
        if (!courierMap.containsKey(id)) {
            throw new CourierNotFoundException("The given object not found.");
        }
        courierMap.replace(id, courier);
    }

    @Override
    public void insertCourier(Courier courier) { courierMap.put(courier.getId(), courier); }

    @Override
    public void deleteCourier(Courier courier) {
        courierMap.remove(courier.getId());
    }
}
