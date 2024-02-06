package com.example.alutecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.alutecSpring.model.IzvozFaktura;

@Repository
public interface IzvozFakturaRepository extends JpaRepository<IzvozFaktura, Integer> {

    @Query("SELECT i.brojFakture FROM IzvozFaktura i")
    List<Integer> findFakture();
    
    IzvozFaktura findByBrojFakture(Integer brojFakture);

}