package com.example.FE019W_beadando.controller;

import com.example.FE019W_beadando.exception.BadCookFormatException;
import com.example.FE019W_beadando.exception.BadPizzaFormatException;
import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.exception.PizzaNotFoundException;
import com.example.FE019W_beadando.model.Cook;
import com.example.FE019W_beadando.model.Pizza;
import com.example.FE019W_beadando.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class PizzaController {

    private PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @RequestMapping(value = "pizzaSuccess", method = RequestMethod.GET)
    @ResponseBody
    public String pizzaSuccess() {
        return "pizzaSuccess";
    }

    @GetMapping("getPizza")
    @ResponseBody
    public Pizza getPizza(@RequestParam("id") int id) throws PizzaNotFoundException {
        return pizzaService.getPizza(id);
    }

    @GetMapping("getAllPizza")
    @ResponseBody
    public List getPizza() {
        return pizzaService.getAllPizza();
    }

    @RequestMapping(value = "/addPizza")
    public String addPizza(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("size") int size,
                           @RequestParam("price") int price,
                           @RequestParam("courierID") int courierID) {
        pizzaService.addPizza(new Pizza(id, name, size, price, courierID));
        return "redirect:/pizzaSuccess";
    }

    @PostMapping(value = "/AddPizza", consumes = "application/json")
    public String addPizzaObj(@Valid @RequestBody Pizza pizza, BindingResult bindingResult) throws BadPizzaFormatException {
        if (bindingResult.hasErrors()) {
            throw new BadPizzaFormatException();
        }

        pizzaService.addPizza(pizza);
        return "redirect:/pizzaSuccess";
    }

    @RequestMapping(value = "/updatePizza")
    public String updatePizza(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("size") int size,
                           @RequestParam("price") int price,
                           @RequestParam("courierID") int courierID) throws PizzaNotFoundException {
        pizzaService.addPizza(new Pizza(id, name, size, price, courierID));
        return "redirect:/pizzaSuccess";
    }

    @PostMapping(value = "/UpdatePizza", consumes = "application/json")
    public String updatePizzaObj(@RequestParam int id, @Valid @RequestBody Pizza pizza, BindingResult bindingResult) throws BadPizzaFormatException, PizzaNotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadPizzaFormatException();
        }
        pizzaService.updatePizza(id, pizza);
        return "redirect:/pizzaSuccess";
    }

    @GetMapping("deletePizza")
    public String deletePizza(@RequestParam("id") int id) throws PizzaNotFoundException {
        pizzaService.removePizza(pizzaService.getPizza(id));
        return "redirect:/pizzaSuccess";
    }

    @ExceptionHandler(PizzaNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String PizzaNotFoundHandler() {
        return "No pizzas found with that id";
    }

    @ExceptionHandler(BadPizzaFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String badPizzaExceptionHandler() {
        return "bad format for a pizza";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String invalidParameterExceptionHandler() {
        return "id cannot be less than one";
    }
}
