package com.example.alutecSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "izlazniartikal")
public class IzlazniArtikal {

    @Id
    @Column(name = "sifra_izlaznog_artikla", nullable = false)
    private String sifraIzlaznogArtikla;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sifra_ulaznog_artikla", referencedColumnName = "sifra_artikla", insertable = true, updatable = true)
    private UlazniArtikal sifraUlaznogArtikla;
    

    public IzlazniArtikal() {
    	
	}


	public IzlazniArtikal(String sifraIzlaznogArtikla, UlazniArtikal sifraUlaznogArtikla) {
		this.sifraIzlaznogArtikla = sifraIzlaznogArtikla;
		this.sifraUlaznogArtikla = sifraUlaznogArtikla;
	}


	public String getSifraIzlaznogArtikla() {
		return sifraIzlaznogArtikla;
	}


	public void setSifraIzlaznogArtikla(String sifraIzlaznogArtikla) {
		this.sifraIzlaznogArtikla = sifraIzlaznogArtikla;
	}


	public UlazniArtikal getSifraUlaznogArtikla() {
		return sifraUlaznogArtikla;
	}


	public void setSifraUlaznogArtikla(UlazniArtikal sifraUlaznogArtikla) {
		this.sifraUlaznogArtikla = sifraUlaznogArtikla;
	}


	@Override
	public String toString() {
		return "IzlazniArtikal [sifraIzlaznogArtikla=" + sifraIzlaznogArtikla + ", sifraUlaznogArtikla="
				+ sifraUlaznogArtikla + "]";
	}
	
}
