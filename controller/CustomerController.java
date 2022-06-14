package com.example.FE019W_beadando.controller;

import com.example.FE019W_beadando.exception.BadCookFormatException;
import com.example.FE019W_beadando.exception.BadCustomerFormatException;
import com.example.FE019W_beadando.exception.CookNotFoundException;
import com.example.FE019W_beadando.exception.CustomerNotFoundException;
import com.example.FE019W_beadando.model.Cook;
import com.example.FE019W_beadando.model.Customer;
import com.example.FE019W_beadando.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "customerSuccess", method = RequestMethod.GET)
    @ResponseBody
    public String customerSuccess() {
        return "customerSuccess";
    }

    @GetMapping("getCustomer")
    @ResponseBody
    public Customer getCustomer(@RequestParam("id") int id) throws CustomerNotFoundException {
        return customerService.getCustomer(id);
    }

    @GetMapping("getAllCustomer")
    @ResponseBody
    public List getCustomer() {
        return customerService.getAllCustomer();
    }

    @RequestMapping(value = "/addCustomer")
    public String addCustomer(@RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("phoneNumber") int phoneNumber,
                          @RequestParam("address") String address,
                          @RequestParam("courierID") int courierID) {
        customerService.addCustomer(new Customer(id, name, phoneNumber, address, courierID));
        return "redirect:/customerSuccess";
    }

    @PostMapping(value = "/AddCustomer", consumes = "application/json")
    public String addCustomerObj(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws BadCustomerFormatException {
        if (bindingResult.hasErrors()) {
            throw new BadCustomerFormatException();
        }

        customerService.addCustomer(customer);
        return "redirect:/customerSuccess";
    }

    @RequestMapping(value = "/updateCustomer")
    public String updateCustomer(@RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("phoneNumber") int phoneNumber,
                          @RequestParam("address") String address,
                          @RequestParam("courierID") int courierID) throws CustomerNotFoundException {
        customerService.addCustomer(new Customer(id, name, phoneNumber, address, courierID));
        return "redirect:/customerSuccess";
    }

    @PostMapping(value = "/UpdateCustomer", consumes = "application/json")
    public String updateCustomerObj(@RequestParam int id, @Valid @RequestBody Customer customer, BindingResult bindingResult) throws BadCustomerFormatException, CustomerNotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadCustomerFormatException();
        }
        customerService.updateCustomer(id, customer);
        return "redirect:/customerSuccess";
    }

    @GetMapping("deleteCustomer")
    public String deleteCustomer(@RequestParam("id") int id) throws CustomerNotFoundException {
        customerService.removeCustomer(customerService.getCustomer(id));
        return "redirect:/customerSuccess";
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String CustomerNotFoundHandler() {
        return "No customers found with that id";
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String badCustomerExceptionHandler() {
        return "bad format for a customer";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String invalidParameterExceptionHandler() {
        return "id cannot be less than one";
    }
}
