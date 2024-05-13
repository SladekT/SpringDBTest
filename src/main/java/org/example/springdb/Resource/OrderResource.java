package org.example.springdb.Resource;


import org.example.springdb.DAO.OrderRepository;
import org.example.springdb.DTO.OrderDTO;
import org.example.springdb.Model.CustomerOrders;
import org.example.springdb.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(path = "/ordr.",method = RequestMethod.GET)
public class OrderResource extends CustomerOrders {
    @Autowired
    private final OrderService orderService;

    public OrderResource(OrderService orderService){this.orderService = orderService;}

    @RequestMapping(value = "/ordrByCust/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<OrderDTO>> fetchOrders(@PathVariable long customer_id) {
        return ResponseEntity.ok(orderService.getOrderByCustomerId(customer_id));
    }
    @RequestMapping(path ="/ubdate", method = RequestMethod.POST)
    ResponseEntity<?> addOrder(@RequestBody CustomerOrders order) {
        return ResponseEntity.ok(orderService.updateOrder(order));
    }


}
