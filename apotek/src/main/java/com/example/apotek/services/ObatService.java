package com.example.apotek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apotek.models.Obat;
import com.example.apotek.repositories.ObatRepository;

@Service
public class ObatService {
    
    @Autowired
    private ObatRepository obatRepository;

    public void saveObat(Obat obat){
        obatRepository.save(obat);
    }

    public void deleteObatById(Integer id){
        obatRepository.deleteById(id);
    }

    public List<Obat> getAllObat(){
        List<Obat> obats = obatRepository.findAll();
        return obats;
    }
}
