package com.example.apotek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.apotek.models.Obat;
import com.example.apotek.services.ObatService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ObatController {
    @Autowired
    private ObatService obatService;

    @GetMapping("/add-obat")
    public String addObat(Model model){
        Obat obat = new Obat();
        model.addAttribute("obat", obat);
        return "add-obat";
    }

    @PostMapping("/save-obat")
    public String saveObat(@ModelAttribute ("obat") Obat obat){
        obatService.saveObat(obat);
        return "redirect:list-obat";
    }

    @GetMapping("/delete-obat/{id}")
    public String deleteObat(@PathVariable (value = "id") Integer id){
        log.info(id.toString());
        obatService.deleteObatById(id);
        return "redirect:/";
    }

    @GetMapping("/list-obat")
    public String listObat(Model model){
        List<Obat> obats = obatService.getAllObat();
        model.addAttribute("obats", obats);
        return "list-obat";
    }
}
