package com.example.alutecSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alutecSpring.model.IzlazniArtikal;
import com.example.alutecSpring.repository.IzlazniArtikalRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/izlazniartikal")
public class IzlazniArtikalController {

    @Autowired
    private IzlazniArtikalRepository izlazniArtikalRepository;

    @GetMapping("/getAll")
    public List<IzlazniArtikal> getAllIzlazniArtikli() {
        return izlazniArtikalRepository.findAll();
    }

    @PostMapping("/dodaj")
    public ResponseEntity<?> dodajIzlazniArtikal(@Valid @RequestBody IzlazniArtikal izlazniArtikal) {
        izlazniArtikalRepository.save(izlazniArtikal);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
//    @PostMapping("/dodaj")
//    public ResponseEntity<String> dodajIzlazniArtikal(@Valid @RequestBody IzlazniArtikal izlazniArtikal) {
//        try {
//            izlazniArtikalRepository.save(izlazniArtikal);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } catch (Exception e) {
//            e.printStackTrace(); // Dodajte ili logujte izuzetak
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Greška prilikom dodavanja izlaznog artikla.");
//        }
//    }
    
    @GetMapping("/sifreArtikala")
    public ResponseEntity<List<String>> getSifreArtikala() {
        List<String> sifreArtikala = izlazniArtikalRepository.findSifreArtikala();
        return new ResponseEntity<>(sifreArtikala, HttpStatus.OK);
    }
    
    @GetMapping("/findBySifraArtikla/{sifraArtikla}")
    public ResponseEntity<IzlazniArtikal> findBySifraArtikla(@PathVariable String sifraArtikla) {
        IzlazniArtikal artikal = izlazniArtikalRepository.findBySifraIzlaznogArtikla(sifraArtikla);

        if (artikal != null) {
            return ResponseEntity.ok(artikal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
