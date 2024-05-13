package org.example.springdb.DAO;


import org.example.springdb.DTO.CustomerDTO;
import org.example.springdb.Model.Customer;
import org.example.springdb.Model.CustomerLogin;
import org.example.springdb.Model.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{


    @SuppressWarnings("NullableProblems")
    Customer save(Customer customer);
//    Customer updateCustomerById(Long id);

    List <Customer> findAll();

    Customer getCustomerById(Long id);

    Collection findCustomerLoginAndCustomerOrdersOrderById(Long id);



}


