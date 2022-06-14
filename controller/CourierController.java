package com.example.FE019W_beadando.controller;

import com.example.FE019W_beadando.exception.BadCookFormatException;
import com.example.FE019W_beadando.exception.BadCourierFormatException;
import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.exception.CourierNotFoundException;
import com.example.FE019W_beadando.model.Cook;
import com.example.FE019W_beadando.model.Courier;
import com.example.FE019W_beadando.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class CourierController {

    private CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @RequestMapping(value = "courierSuccess", method = RequestMethod.GET)
    @ResponseBody
    public String courierSuccess() {
        return "courierSuccess";
    }

    @GetMapping("getCourier")
    @ResponseBody
    public Courier getCourier(@RequestParam("id") int id) throws CourierNotFoundException {
        return courierService.getCourier(id);
    }

    @GetMapping("getAllCourier")
    @ResponseBody
    public List getCourier() {
        return courierService.getAllCourier();
    }

    @RequestMapping(value = "/addCourier")
    public String addCourier(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("age") int age,
                                @RequestParam("salary") int salary,
                                @RequestParam("scooterType") String scooterType) {
        courierService.addCourier(new Courier(id, name, age, salary, scooterType));
        return "redirect:/courierSuccess";
    }

    @PostMapping(value = "/AddCourier", consumes = "application/json")
    public String addCourierObj(@Valid @RequestBody Courier courier, BindingResult bindingResult) throws BadCourierFormatException {
        if (bindingResult.hasErrors()) {
            throw new BadCourierFormatException();

        }

        courierService.addCourier(courier);
        return "redirect:/courierSuccess";
    }

    @RequestMapping(value = "/updateCourier")
    public String updateCourier(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("salary") int salary,
                             @RequestParam("scooterType") String scooterType) throws CourierNotFoundException {
        courierService.updateCourier(id, new Courier(id, name, age, salary, scooterType));
        return "redirect:/courierSuccess";
    }

    @PostMapping(value = "/UpdateCourier", consumes = "application/json")
    public String updateCourierObj(@RequestParam int id, @Valid @RequestBody Courier courier, BindingResult bindingResult) throws BadCourierFormatException, CourierNotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadCourierFormatException();
        }
        courierService.updateCourier(id, courier);
        return "redirect:/courierSuccess";
    }

    @GetMapping("deleteCourier")
    public String deleteCourier(@RequestParam("id") int id) throws CourierNotFoundException {
        courierService.removeCourier(courierService.getCourier(id));
        return "redirect:/courierSuccess";
    }

    @ExceptionHandler(CourierNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String CourierNotFoundHandler() {
        return "No couriers found with that id";
    }

    @ExceptionHandler(CourierNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String badCourierExceptionHandler() {
        return "bad format for a courier";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String invalidParameterExceptionHandler() {
        return "id cannot be less than one";
    }
}
