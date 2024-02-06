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

import com.example.alutecSpring.model.Uvoz;
import com.example.alutecSpring.repository.UvozRepository;

@RestController
@RequestMapping("/uvoz")
public class UvozController {

	@Autowired
	private UvozRepository uvozRepository;
	
	@GetMapping("/getAll")
	public List<Uvoz> getAllUvoz(){
		return uvozRepository.findAll();
	}

	@PostMapping("/dodaj")
	public ResponseEntity<?> dodajUvoz(@Valid @RequestBody Uvoz uvoz) {
	    uvozRepository.save(uvoz);
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/sifre-uvoza")
    public ResponseEntity<List<String>> getSifreUvoza() {
        List<String> sifreUvoza = uvozRepository.findSifreUvoza();
        return new ResponseEntity<>(sifreUvoza, HttpStatus.OK);
    }
	
	@GetMapping("/findBySifraUvoza/{sifraUvoza}")
    public ResponseEntity<Uvoz> findBySifraUvoza(@PathVariable String sifraUvoza) {
        Uvoz uvoz = uvozRepository.findBySifraUvoza(sifraUvoza);

        if (uvoz != null) {
            return ResponseEntity.ok(uvoz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/proveriSifruUvoza/{sifraUvoza}")
    public ResponseEntity<Boolean> proveriSifruUvoza(@PathVariable String sifraUvoza) {
        boolean postojiSifraUvoza = uvozRepository.existsBySifraUvoza(sifraUvoza);

        return ResponseEntity.ok(postojiSifraUvoza);
    }
	
}
