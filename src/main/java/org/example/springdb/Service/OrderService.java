package org.example.springdb.Service;

import jakarta.transaction.Transactional;
import org.example.springdb.DAO.CustomerRepository;
import org.example.springdb.DAO.OrderRepository;
import org.example.springdb.DTO.OrderDTO;
import org.example.springdb.Model.Customer;
import org.example.springdb.Model.CustomerOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public OrderService(){
    }


    public List<OrderDTO> getOrderByCustomerId(Long customer_id){
        Optional<Customer> cust = customerRepository.findById(customer_id);
        List<CustomerOrders> customerOrdersById =  orderRepository.findByCustomer(cust.get());
        List<OrderDTO> orderDTOList = new ArrayList<>(List.of());

        if (!customerOrdersById.isEmpty()) {
            for (CustomerOrders customerOrdersOptional : customerOrdersById) {
                OrderDTO customerOrderDTO = OrderDTO.mapEntityToDTO(customerOrdersOptional);
                orderDTOList.add(customerOrderDTO);
            }
            return  orderDTOList;
        } else {
            return null;
        }
    }

    public CustomerOrders updateOrder(CustomerOrders order){
        return orderRepository.save(order);
    }
    public CustomerOrders createOrder(CustomerOrders order){
        return orderRepository.save(order);
    }

}
