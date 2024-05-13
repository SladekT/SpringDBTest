package org.example.springdb.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.springdb.Model.CustomerOrders;

import java.util.Optional;

@JsonSerialize

public class OrderDTO {

    @NotNull
    private Long customer_id;
    @NotNull
    private Long Id;
    @NotNull
    private Long Order_number;
    @NotBlank
    private  String dateOfOrder;

    public OrderDTO() {
    }

    public OrderDTO(Long customer_id, Long id, Long orderNumber, String dateOfOrder) {
        // TODO: implement me
    }


    @JsonProperty
    public Long getCustomer_id() {
        return customer_id;
    }
    @JsonProperty

    public  void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
    @JsonProperty

    public  Long getId() {
        return Id;
    }
    @JsonProperty

    public  void setId(Long id) {
        this.Id = id;
    }

    @JsonProperty
    public Long getOrder_number() {
        return Order_number;
    }

    @JsonProperty
    public  void setOrder_number(Long order_number) {
        this.Order_number = order_number;
    }

    @JsonProperty
    public  String getDateOfOrder() {
        return dateOfOrder;
    }

    @JsonProperty
    public  void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public static OrderDTO mapEntityToDTO(CustomerOrders customerOrders) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomer_id(customerOrders.getCustomer().getId());
        orderDTO.setId(customerOrders.getId());
        orderDTO.setOrder_number(customerOrders.getOrder_number());
        orderDTO.setDateOfOrder(customerOrders.getDateOfOrder());

        return orderDTO;
    }
}
