package com.example.apotek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apotek.models.Obat;

public interface ObatRepository extends JpaRepository<Obat, Integer> {
    
}
