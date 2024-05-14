package org.example.springdb.DAO;

import org.example.springdb.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{


    @SuppressWarnings("NullableProblems")
    Customer save(Customer customer);

    List <Customer> findAll();

    Customer getCustomerById(Long id);

    Integer removeAllById(long id);




}


