package org.example.springdb.DAO;

import org.example.springdb.Model.CustomerOrders;
import org.example.springdb.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//import static net.sf.jsqlparser.parser.feature.Feature.select;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrders, Long> {




    @SuppressWarnings("NullableProblems")
    CustomerOrders save(CustomerOrders order);


    List<CustomerOrders> findByCustomer(Customer customer);

}
