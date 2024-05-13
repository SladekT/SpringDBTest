package org.example.springdb.Model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "customer_login")
public class CustomerLogin{
    @Id
    public Long loginId;

    public  String username;
    public  String email;
    public  String password;
    public CustomerLogin(Long loginId, String username, String email, String password) {
        this.loginId = loginId;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public CustomerLogin() {

    }
    @ManyToOne
    @JoinColumn(name = "loginId",insertable = false, updatable = false)

    private Customer customer;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public  String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    }
