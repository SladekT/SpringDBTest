package org.example.springdb.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.springdb.Model.Customer;

import java.util.Optional;

public class CustomerDTO {

    @NotNull
    static public Long id;
     @NotBlank
    static public String first_name;
     @NotBlank
    static public String surname;
     @NotBlank
    static public String adress;

    public CustomerDTO(Long id, String first_name, String surname, String adress) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public static CustomerDTO mapEntityToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO(id,first_name, surname,adress);
        customerDTO.setId(customer.getId());
        customerDTO.setFirst_name( customer.getName());
        customerDTO.setSurname( customer.getSurname());
        customerDTO.setAdress(customer.getAdress());
        return customerDTO;
    }

}
