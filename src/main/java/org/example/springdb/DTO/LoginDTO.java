package org.example.springdb.DTO;

import org.example.springdb.Model.CustomerLogin;

import java.util.Optional;

public class LoginDTO {
    public LoginDTO() {
    }



     public long loginId;
     public String username;
     public String email;
     public String password;

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static LoginDTO mapEntityToDTO(CustomerLogin customerLogin) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setLoginId(customerLogin.getLoginId());
        loginDTO.setUsername(customerLogin.getUsername());
        loginDTO.setEmail(customerLogin.getEmail());
        loginDTO.setPassword(customerLogin.getPassword());

        return loginDTO;
    }
}
