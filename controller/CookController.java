package com.example.FE019W_beadando.controller;

import com.example.FE019W_beadando.exception.BadCookFormatException;
import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.model.Cook;
import com.example.FE019W_beadando.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class CookController {

    private CookService cookService;

    @Autowired
    public CookController(CookService cookService) {
        this.cookService = cookService;
    }

    @RequestMapping(value = "cookSuccess", method = RequestMethod.GET)
    @ResponseBody
    public String cookSuccess() {
        return "cookSuccess";
    }

    @GetMapping("getCook")
    @ResponseBody
    public Cook getCook(@RequestParam("id") int id) throws CookNotFoundException {
        return cookService.getCook(id);
    }

    @GetMapping("getAllCook")
    @ResponseBody
    public List getCook() {
        return cookService.getAllCook();
    }

    @RequestMapping(value = "/addCook")
    public String addCook(@RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("age") int age,
                          @RequestParam("salary") int salary,
                          @RequestParam("pizzaID") int pizzaID) {
        cookService.addCook(new Cook(id, name, age, salary, pizzaID));
        return "redirect:/cookSuccess";
    }

    @PostMapping(value = "/AddCook", consumes = "application/json")
    public String addCookObj(@Valid @RequestBody Cook cook, BindingResult bindingResult) throws BadCookFormatException {
        if (bindingResult.hasErrors()) {
            throw new BadCookFormatException();
        }

        cookService.addCook(cook);
        return "redirect:/cookSuccess";
    }

    @RequestMapping(value = "/updateCook")
    public String updateCook(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("salary") int salary,
                             @RequestParam("salary") int pizzaID) throws CookNotFoundException {
        cookService.updateCook(id, new Cook(id, name, age, salary, pizzaID));
        return "redirect:/cookSuccess";
    }

    @PostMapping(value = "/UpdateCook", consumes = "application/json")
    public String updateCookObj(@RequestParam int id, @Valid @RequestBody Cook cook, BindingResult bindingResult) throws BadCookFormatException, CookNotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadCookFormatException();
        }
        cookService.updateCook(id, cook);
        return "redirect:/cookSuccess";
    }

    @GetMapping("deleteCook")
    public String deleteCook(@RequestParam("id") int id) throws CookNotFoundException {
        cookService.removeCook(cookService.getCook(id));
        return "redirect:/cookSuccess";
    }

    @ExceptionHandler(CookNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String CookNotFoundHandler() {
        return "No cooks found with that id";
    }

    @ExceptionHandler(BadCookFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String badCookExceptionHandler() {
        return "bad format for a cook";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String invalidParameterExceptionHandler() {
        return "id cannot be less than one";
    }
}
