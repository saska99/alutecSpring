package com.example.alutecSpring.controller;

import com.example.alutecSpring.model.IzvezeniArtikli;
import com.example.alutecSpring.model.IzvozFaktura;
import com.example.alutecSpring.repository.IzvezeniArtikliRepository;
import com.example.alutecSpring.repository.IzvozFakturaRepository;
import com.example.alutecSpring.repository.UvezeniArtikliRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/izvezeniartikli")
public class IzvezeniArtikliController {

    @Autowired
    private IzvezeniArtikliRepository izvezeniArtikliRepository;
    
    @Autowired
    private IzvozFakturaRepository izvozFakturaRepository;
    
    @Autowired
    private UvezeniArtikliRepository uvezeniArtikliRepository;

    @GetMapping("/getAll")
    public List<IzvezeniArtikli> getAllIzvezeniArtikli() {
        return izvezeniArtikliRepository.findAll();
    }

    @PostMapping("/dodaj")
    public IzvezeniArtikli dodajIzvezeniArtikal(@RequestBody IzvezeniArtikli izvezeniArtikli) {
        return izvezeniArtikliRepository.save(izvezeniArtikli);
    }
//    @PostMapping("/dodaj")
//    public IzvezeniArtikli dodajIzvezeniArtikal(@RequestBody IzvezeniArtikli izvezeniArtikli) {
//        IzvezeniArtikli sacuvaniIzvArtikal =  izvezeniArtikliRepository.save(izvezeniArtikli);
//        
//     // Ovo je novo, dodato kako bi radilo sa RestTemplate.postForEntity
//        sacuvaniIzvArtikal.setIzvozFaktura(null);
//        
//        //ako je izvezeni artikal pravilno sacuvam, smanjimo broj komada uvezenog artikla
//        if(sacuvaniIzvArtikal != null) {
//        	Integer izvKom = sacuvaniIzvArtikal.getKom();
//        	UvezeniArtikli uvezeniArtikal = uvezeniArtikliRepository.findByUlazniArtikal(sacuvaniIzvArtikal.getIzlazniArtikal().getSifraUlaznogArtikla().getSifraArtikla());
//        	
//        	if(uvezeniArtikal != null) {
//        		Integer uvKom = uvezeniArtikal.getKom();
//        		Integer noviKom = uvKom - izvKom;
//        		uvezeniArtikal.setKom(noviKom);
//        		uvezeniArtikliRepository.save(uvezeniArtikal);
//        	}
//        }
//        return sacuvaniIzvArtikal;
//    }


    @GetMapping("/findByIzvozFaktura/{brojFakture}")
    public ResponseEntity<List<IzvezeniArtikli>> findByIzvoz(@PathVariable Integer brojFakture) {
    	IzvozFaktura izvoz = izvozFakturaRepository.findByBrojFakture(brojFakture);
    	
        if (izvoz != null) {
            List<IzvezeniArtikli> izvezeniArtikli = izvezeniArtikliRepository.findByIzvozFaktura(izvoz);

            return new ResponseEntity<>(izvezeniArtikli, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

