package org.example.springdb.Resource;


import jakarta.ws.rs.Path;
import org.apache.coyote.Response;
import org.example.springdb.DAO.LoginRepository;
import org.example.springdb.DTO.LoginDTO;
import org.example.springdb.Model.CustomerLogin;
import org.example.springdb.Service.CustomerService;
import org.example.springdb.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.example.springdb.Model.CustomerLogin;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class LoginResource extends CustomerLogin{
    @Autowired
    private final LoginService loginService;
    @Autowired
    private final CustomerService customerService;

    public LoginResource(LoginService loginService, CustomerService customerService){this.loginService = loginService;
        this.customerService = customerService;
    }

    @RequestMapping(path = "/log/cust.log/{loginId}",
    method = RequestMethod.GET)
    ResponseEntity<LoginDTO> fetchLogin(@PathVariable long loginId){
        return ResponseEntity.ok(loginService.getCustomerLoginById(loginId));
    }



}
