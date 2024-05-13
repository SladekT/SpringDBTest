package org.example.springdb.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_orders")
public class CustomerOrders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private Long Order_number;
    private String dateOfOrder;

    public CustomerOrders(Customer customer, Long id, Long order_number, String dateOfOrder) {
        this.customer = customer;
        this.Id = id;
        this.Order_number = order_number;
        this.dateOfOrder = dateOfOrder;
    }

    public CustomerOrders() {

    }
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getOrder_number() {
        return Order_number;
    }

    public void setOrder_number(Long order_number) {
        Order_number = order_number;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
