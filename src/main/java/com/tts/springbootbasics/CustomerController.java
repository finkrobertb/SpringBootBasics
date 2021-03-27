package com.tts.springbootbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController
{

    @Autowired
    private CustomerRepository customerRepository;

    // Returns index template
    @GetMapping(value = "/")
    public String index(Customer customer)
    {
        // Where we want to go when our application is started
        return "customer/index";
    }

    // private Customer customer;

    // Takes data from the form and saves it to the database
    @PostMapping(value = "/")
    public String addNewCustomer(Customer customer, Model model)
    {
        customerRepository.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getCity(), customer.getState(), customer.getZip(),
                customer.getPhoneNumber(), customer.getEmail(), customer.getSignedUp()));

        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());
        model.addAttribute("address", customer.getAddress());
        model.addAttribute("city", customer.getCity());
        model.addAttribute("state", customer.getState());
        model.addAttribute("zip", customer.getZip());
        model.addAttribute("phoneNumber", customer.getPhoneNumber());
        model.addAttribute("email", customer.getEmail());

        return "customer/result";
    }

}
