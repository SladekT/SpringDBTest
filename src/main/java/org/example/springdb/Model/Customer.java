package org.example.springdb.Model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers2")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long id;
    public String first_name;
    public String surname;
    public String adress;

    public Customer(Long id, String first_name, String surname, String adress) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.adress = adress;
    }

    public Customer () {

    }
    @OneToMany(mappedBy = "customer")
    private List< CustomerOrders >customerOrders;
    @OneToMany(mappedBy = "customer")
    private List<CustomerLogin> customerLogin;


    // Constructors, Getters, and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return first_name;
    }

    public void setName(String name) {
        this.first_name = name;
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


}







