package com.example.alutecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.example.alutecSpring.model.UlazniArtikal;
import com.example.alutecSpring.model.UvezeniArtikli;
import com.example.alutecSpring.model.Uvoz;

@Repository
public interface UvezeniArtikliRepository extends JpaRepository<UvezeniArtikli, Long>{
	@Query("SELECT DISTINCT u.idUvoza FROM UvezeniArtikli u")
    List<String> findSifreUvoza();
	
	@Query("SELECT DISTINCT u.ulazniArtikal.sifraArtikla FROM UvezeniArtikli u")
    List<String> findSifreArtikala();

	List<UvezeniArtikli> findByIdUvoza(Uvoz idUvoza);

	List<UvezeniArtikli> findByIdUvoza(String sifraUvoza);

	List<UvezeniArtikli> findByUlazniArtikal(UlazniArtikal ulazniArtikal);
	
	//ovo mi mozda ne treba
	List<UvezeniArtikli> findByUlazniArtikal(String ulazniArtikal);
	
}
