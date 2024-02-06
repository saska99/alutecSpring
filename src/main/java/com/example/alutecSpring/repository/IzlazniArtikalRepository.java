package com.example.alutecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.alutecSpring.model.IzlazniArtikal;

@Repository
public interface IzlazniArtikalRepository extends JpaRepository<IzlazniArtikal, String> {

	@Query("SELECT i.sifraIzlaznogArtikla FROM IzlazniArtikal i")
	List<String> findSifreArtikala();
	
	IzlazniArtikal findBySifraIzlaznogArtikla(String sifraIzlaznogArtikla);
	

}

