package com.example.apotek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.apotek.models.Login;
import com.example.apotek.services.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;


    @GetMapping("registrasi")
    public String registrasi(Model model){
        Login login = new Login();
        model.addAttribute("regis", login);
        return "registrasi";
    }

    @PostMapping("save-regis")
    public String saveRegis(@ModelAttribute ("regis") Login login){
        loginService.saveLogin(login);
        return "redirect:login";
    }

    @GetMapping("login")
    public String login(){
        
        return "login";
    }

    @PostMapping("cek-login")
    public String login(@RequestParam ("username") String username, @RequestParam ("password") String password , Model model){
        Login login = loginService.findUsernameAndPassword(username, password);
        log.info("username : "+username);
        log.info("password : "+password);
        if(login != null){
            model.addAttribute("login", login);
            return "home";
        }else{
            return "redirect:/login";
        }
    }

    @DeleteMapping("delete-account/{id}")
    public String deleteAkun(@PathVariable (value = "id") Integer id){
        loginService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
