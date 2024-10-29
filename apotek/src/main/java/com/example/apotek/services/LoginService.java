package com.example.apotek.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apotek.models.Login;
import com.example.apotek.repositories.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public void saveLogin(Login login){
        loginRepository.save(login);
    }

    public Login findUsernameAndPassword(String username, String password){
        List<Login> login = loginRepository.findByUsernameAndPassword(username, password);
        return login.stream().findFirst().orElse(null);
    }

    public void deleteById(Integer id){
        loginRepository.deleteById(id);
    }
}
