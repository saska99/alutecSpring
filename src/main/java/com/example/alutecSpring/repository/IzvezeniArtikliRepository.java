package com.example.alutecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.alutecSpring.model.IzvezeniArtikli;
import com.example.alutecSpring.model.IzvozFaktura;

@Repository
public interface IzvezeniArtikliRepository extends JpaRepository<IzvezeniArtikli, Long>{

	@Query("SELECT DISTINCT i.izvozFaktura FROM IzvezeniArtikli i")
	List<Integer> findBrojFaktura();
	
	List<IzvezeniArtikli> findByIzvozFaktura(IzvozFaktura brojFakture);
	
	List<IzvezeniArtikli> findByIzvozFaktura(Integer brojFakture);
	
}
