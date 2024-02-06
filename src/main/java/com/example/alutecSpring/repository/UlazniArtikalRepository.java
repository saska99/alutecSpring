package com.example.alutecSpring.repository;

import com.example.alutecSpring.model.UlazniArtikal;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UlazniArtikalRepository extends JpaRepository<UlazniArtikal, String> {

	@Query("SELECT u.sifraArtikla FROM UlazniArtikal u")
    List<String> findSifreArtikala();
	
	UlazniArtikal findBySifraArtikla(String sifraArtikla);
	
//	@Query("SELECT u.sifraArtikla FROM UlazniArtikal u")
//    List<String> findSifreUlaznihArtikala();
//	
//	Optional<UlazniArtikal> findBySifraArtikla(String sifraArtikla); //optional jer ne namo da li ce artikal sa datom sifrom uvek postojati
}
