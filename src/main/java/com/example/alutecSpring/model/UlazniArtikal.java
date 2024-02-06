package com.example.alutecSpring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ulazniartikal")
public class UlazniArtikal {

	
    @Id
    @Column(name = "sifra_artikla", nullable = false)
    private String sifraArtikla;

    @Column(name = "netopokom")
    private Double netoPoKom;

    @Column(name = "cenapokom")
    private Double cenaPoKom;
    
    

    public UlazniArtikal() {
		super();
	}
 
	public UlazniArtikal(String sifraArtikla, Double netoPoKom, Double cenaPoKom) {
		this.sifraArtikla = sifraArtikla;
		this.netoPoKom = netoPoKom;
		this.cenaPoKom = cenaPoKom;
	}


	public String getSifraArtikla() {
        return sifraArtikla;
    }

    public void setSifraArtikla(String sifraArtikla) {
        this.sifraArtikla = sifraArtikla;
    }

    public Double getNetoPoKom() {
        return netoPoKom;
    }

    public void setNetoPoKom(Double netoPoKom) {
        this.netoPoKom = netoPoKom;
    }

    public Double getCenaPoKom() {
        return cenaPoKom;
    }

    public void setCenaPoKom(Double cenaPoKom) {
        this.cenaPoKom = cenaPoKom;
    }

	@Override
	public String toString() {
		return "UlazniArtikal [sifraArtikla=" + sifraArtikla + ", netoPoKom=" + netoPoKom + ", cenaPoKom=" + cenaPoKom
				+ "]";
	}
    
    
}
