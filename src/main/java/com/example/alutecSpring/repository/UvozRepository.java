package com.example.alutecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.alutecSpring.model.Uvoz;

@Repository
public interface UvozRepository extends JpaRepository<Uvoz, String>{

	@Query("SELECT u.sifraUvoza FROM Uvoz u")
    List<String> findSifreUvoza();

	Uvoz findBySifraUvoza(String sifraUvoza);
	
	//proverava da li vec postoji sifra uvoza
	boolean existsBySifraUvoza(String sifraUvoza);

}
