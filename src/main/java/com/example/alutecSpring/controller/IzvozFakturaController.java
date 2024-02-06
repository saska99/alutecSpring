package com.example.alutecSpring.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alutecSpring.model.IzvozFaktura;
import com.example.alutecSpring.repository.IzvozFakturaRepository;

@RestController
@RequestMapping("/izvoz")
public class IzvozFakturaController {

    @Autowired
    private IzvozFakturaRepository izvozFakturaRepository;

    @GetMapping("/getAll")
    public List<IzvozFaktura> getAllIzvozFakture() {
        return izvozFakturaRepository.findAll();
    }

    @PostMapping("/dodaj")
    public ResponseEntity<?> createIzvozFaktura(@Valid @RequestBody IzvozFaktura izvozFaktura) {
        izvozFakturaRepository.save(izvozFaktura);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/sifreIzvoza")
    public ResponseEntity<List<Integer>> getSifreIzvoza() {
        List<Integer> sifreIzvoza = izvozFakturaRepository.findFakture();
        return new ResponseEntity<>(sifreIzvoza, HttpStatus.OK);
    }
    
    @GetMapping("/findByBrojFakture/{brojFakture}")
    public ResponseEntity<IzvozFaktura> findBySifraIzvoza(@PathVariable Integer brojFakture) {
    	IzvozFaktura izvoz = izvozFakturaRepository.findByBrojFakture(brojFakture);
    	
        if (izvoz != null) {
            return ResponseEntity.ok(izvoz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}

