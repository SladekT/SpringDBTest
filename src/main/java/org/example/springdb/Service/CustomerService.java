package org.example.springdb.Service;


import jakarta.transaction.Transactional;
import org.example.springdb.DAO.CustomerRepository;
import org.example.springdb.DAO.LoginRepository;
import org.example.springdb.DAO.OrderRepository;
import org.example.springdb.DTO.CustomerDTO;
import org.example.springdb.DTO.LoginDTO;
import org.example.springdb.DTO.OrderDTO;
import org.example.springdb.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    public CustomerService(CustomerRepository customerRepository, LoginService loginService) {
        this.customerRepository = customerRepository;
        this.loginService = loginService;
    }


    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public CustomerDTO getCustomer(Long id){
        Customer customerInfo =  customerRepository.getCustomerById(id);
        CustomerDTO customerDTO = CustomerDTO.mapEntityToDTO(customerInfo);
        return customerDTO;

    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public LoginDTO fetchCustomerLogin(Long id){
        return loginService.getCustomerLoginById(id);
//        return customerRepository.findCustomerById(id);
    }
    public Optional<List> findEverything(long id) {
        ArrayList everything = new ArrayList();
        CustomerDTO customer =(getCustomer(id));
        LoginDTO customerLogin = loginService.getCustomerLoginById(customer.getId());
        List<OrderDTO> customerOrders = orderService.getOrderByCustomerId(id);
            everything.add(customer);
            everything.add(customerLogin);
            everything.add(customerOrders);

            return Optional.of(everything);
    }

    public Integer deleteCustomer(Long id){
//        orderRepository.deleteAllById(getCustomer(id).getId());
//        loginRepository.deleteAllByLoginId(id);

        customerRepository.removeAllById(id);

        return 1;
    }

}

