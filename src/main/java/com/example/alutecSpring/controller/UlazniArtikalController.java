package com.example.alutecSpring.controller;

import com.example.alutecSpring.model.UlazniArtikal;
import com.example.alutecSpring.repository.UlazniArtikalRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ulazniartikal")
public class UlazniArtikalController {

    @Autowired
    private UlazniArtikalRepository ulazniArtikalRepository;

    @GetMapping("/getAll")
    public List<UlazniArtikal> getAllUlazniArtikli() {
        return ulazniArtikalRepository.findAll();
    }

    @PostMapping("/dodaj")
    public ResponseEntity<?> dodajUlazniArtikal(@Valid @RequestBody UlazniArtikal ulazniArtikal) {
        ulazniArtikalRepository.save(ulazniArtikal);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/sifreArtikala")
    public ResponseEntity<List<String>> getSifreArtikala() {
        List<String> sifreArtikala = ulazniArtikalRepository.findSifreArtikala();
        return new ResponseEntity<>(sifreArtikala, HttpStatus.OK);
    }
    
    @GetMapping("/findBySifraArtikla/{sifraArtikla}")
    public ResponseEntity<UlazniArtikal> findBySifraArtikla(@PathVariable String sifraArtikla) {
        UlazniArtikal artikal = ulazniArtikalRepository.findBySifraArtikla(sifraArtikla);

        if (artikal != null) {
            return ResponseEntity.ok(artikal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
