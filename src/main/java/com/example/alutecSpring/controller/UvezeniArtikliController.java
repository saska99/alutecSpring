package com.example.alutecSpring.controller;

import com.example.alutecSpring.model.UlazniArtikal;
import com.example.alutecSpring.model.UvezeniArtikli;
import com.example.alutecSpring.model.Uvoz;
import com.example.alutecSpring.repository.UlazniArtikalRepository;
import com.example.alutecSpring.repository.UvezeniArtikliRepository;
import com.example.alutecSpring.repository.UvozRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uvezeniartikli")
public class UvezeniArtikliController {

    @Autowired
    private UvezeniArtikliRepository uvezeniArtikliRepository;
    
    @Autowired
    private UlazniArtikalRepository ulazniArtikalRepository;
    
    @Autowired
    private UvozRepository uvozRepository;

    @GetMapping("/getAll")
    public List<UvezeniArtikli> getAllUvezeniArtikli() {
        return uvezeniArtikliRepository.findAll();
    }   

    @PostMapping("/dodaj")
    public UvezeniArtikli dodajUvezeniArtikal(@RequestBody UvezeniArtikli uvezeniArtikli) {
        return uvezeniArtikliRepository.save(uvezeniArtikli);
    }

    @GetMapping("/findByUvoz/{sifraUvoza}")
    public ResponseEntity<List<UvezeniArtikli>> findByUvoz(@PathVariable String sifraUvoza) {
    	Uvoz uvoz = uvozRepository.findBySifraUvoza(sifraUvoza);

        if (uvoz != null) {
            List<UvezeniArtikli> uvezeniArtikli = uvezeniArtikliRepository.findByIdUvoza(uvoz);

            return new ResponseEntity<>(uvezeniArtikli, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/findByUlazniArtikal/{sifraArtikla}")
    public ResponseEntity<List<UvezeniArtikli>> findByUlazniArtikal(@PathVariable String sifraArtikla) {

    	UlazniArtikal ulazniArtikal = ulazniArtikalRepository.findBySifraArtikla(sifraArtikla);
    	
        if (ulazniArtikal != null) {
            List<UvezeniArtikli> uvezeniArtikli = uvezeniArtikliRepository.findByUlazniArtikal(ulazniArtikal);

            return new ResponseEntity<>(uvezeniArtikli, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping("/sifreUvezenihArtikala")
    public ResponseEntity<List<String>> getSifreArtikala() {
        List<String> sifreArtikala = uvezeniArtikliRepository.findSifreArtikala();
        return new ResponseEntity<>(sifreArtikala, HttpStatus.OK);
    }

}

