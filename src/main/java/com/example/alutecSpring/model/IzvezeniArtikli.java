package com.example.alutecSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "izvezeniartikli")
public class IzvezeniArtikli {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_izvoza", referencedColumnName = "broj_fakture", nullable = false)
	private IzvozFaktura izvozFaktura;

	@ManyToOne
	@JoinColumn(name = "sifra_izlaznog_artikla", referencedColumnName = "sifra_izlaznog_artikla", nullable = false)
	private IzlazniArtikal izlazniArtikal;

	@Column(name = "neto")
	private Double neto;

	@Column(name = "kom")
	private Integer kom;

	@Column(name = "ukupna_cena")
	private Double ukupnaCena;

	public IzvezeniArtikli() {
		
	}

	public IzvezeniArtikli(IzvozFaktura izvozFaktura, IzlazniArtikal izlazniArtikal, Double neto, Integer kom, Double ukupnaCena) {
		this.izvozFaktura = izvozFaktura;
		this.izlazniArtikal = izlazniArtikal;
		this.neto = neto;
		this.kom = kom;
		this.ukupnaCena = ukupnaCena;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public IzvozFaktura getIzvozFaktura() {
		return izvozFaktura;
	}

	public void setIzvozFaktura(IzvozFaktura izvozFaktura) {
		this.izvozFaktura = izvozFaktura;
	}

	public IzlazniArtikal getIzlazniArtikal() {
		return izlazniArtikal;
	}

	public void setIzlazniArtikal(IzlazniArtikal izlazniArtikal) {
		this.izlazniArtikal = izlazniArtikal;
	}

	public Double getNeto() {
		return neto;
	}

	public void setNeto(Double neto) {
		this.neto = neto;
	}

	public Integer getKom() {
		return kom;
	}

	public void setKom(Integer kom) {
		this.kom = kom;
	}

	public Double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(Double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	@Override
	public String toString() {
		return "IzvezeniArtikli [izvozFaktura=" + izvozFaktura + ", izlazniArtikal=" + izlazniArtikal + ", neto=" + neto
				+ ", kom=" + kom + ", ukupnaCena=" + ukupnaCena + "]";
	}

}
