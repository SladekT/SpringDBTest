package org.example.springdb.Resource;


import org.example.springdb.DAO.CustomerRepository;
import org.example.springdb.DTO.CustomerDTO;
import org.example.springdb.DTO.LoginDTO;
import org.example.springdb.Model.Customer;
import org.example.springdb.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(value = "/cust.",method = RequestMethod.GET)

public class CustomerResource extends Customer{
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;


    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping("/user")
    ResponseEntity<CustomerDTO> fetchCustomer(@RequestParam("id")Long id){
      CustomerDTO customerDTO = customerService.getCustomer(id);
        return ResponseEntity.ok(customerDTO);
    }

    @RequestMapping(
            path = "post",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<?> insertCustomer(@RequestBody Customer newCustomer){
        Customer savedCustomer = customerService.createCustomer(newCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    @RequestMapping(
            path = "custLog/userID/{id}",
            method = RequestMethod.GET)
    ResponseEntity<?> fetchCustomerLog(@PathVariable long id) {
     LoginDTO customerLoginOptional = customerService.fetchCustomerLogin(id);

        if (customerLoginOptional != null) {
                return ResponseEntity.ok(customerLoginOptional);
    }
        return ResponseEntity.status(NOT_FOUND).build();
    }

    @RequestMapping(
            path = "findAll/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    ResponseEntity<?>findAll(@PathVariable long id){
        Optional everything = customerService.findEverything(id);
        return ResponseEntity.ok(everything);
    }
    @RequestMapping("/")
    public ModelAndView HTML(){
        ModelAndView html = new ModelAndView();
//        ModelAndView css = new ModelAndView();
//        css.setViewName("Test.css");
        html.setViewName("Test.html" );
        return html;
    }


}
