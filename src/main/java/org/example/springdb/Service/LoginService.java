package org.example.springdb.Service;


import jakarta.transaction.Transactional;
import org.example.springdb.DAO.LoginRepository;
import org.example.springdb.DTO.LoginDTO;
import org.example.springdb.Model.CustomerLogin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public LoginDTO getCustomerLoginById(Long login_id){
        CustomerLogin optionalCustomerLogin = loginRepository.searchAllByLoginId(login_id);
        LoginDTO loginDTO = LoginDTO.mapEntityToDTO(optionalCustomerLogin);
            return loginDTO;

    }
    public List<CustomerLogin> getAllLoginInfo(){
        return loginRepository.findAll();
    }

    public Integer updateLoginInfo(CustomerLogin customerLogin){
        loginRepository.save(customerLogin);
        return 1;
    }
    public CustomerLogin createLoginInfo(CustomerLogin customerLogin){
        return loginRepository.save(customerLogin);
    }

}
