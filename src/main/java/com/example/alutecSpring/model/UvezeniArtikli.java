package com.example.alutecSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "uvezeniartikli")
public class UvezeniArtikli {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_uvoza", referencedColumnName = "sifra_uvoza", nullable = false)
	private Uvoz idUvoza;

	@ManyToOne
	@JoinColumn(name = "sifra_artikla", referencedColumnName = "sifra_artikla", nullable = false)
	private UlazniArtikal ulazniArtikal;

	@Column(name = "naim")
	private Integer naim;

	@Column(name = "neto")
	private Double neto;

	@Column(name = "kom")
	private Integer kom;

	@Column(name = "ukupna_cena")
	private Double ukupnaCena;

	public UvezeniArtikli() {
		
	}

	public UvezeniArtikli(Uvoz idUvoza, UlazniArtikal ulazniArtikal, Integer naim, Double neto, Integer kom, Double ukupnaCena) {
		this.idUvoza = idUvoza;
		this.ulazniArtikal = ulazniArtikal;
		this.naim = naim;
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

	public Uvoz getIdUvoza() {
		return idUvoza;
	}

	public void setIdUvoza(Uvoz idUvoza) {
		this.idUvoza = idUvoza;
	}

	public UlazniArtikal getUlazniArtikal() {
		return ulazniArtikal;
	}

	public void setUlazniArtikal(UlazniArtikal ulazniArtikal) {
		this.ulazniArtikal = ulazniArtikal;
	}

	public Integer getNaim() {
		return naim;
	}

	public void setNaim(Integer naim) {
		this.naim = naim;
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
		return "UvezeniArtikli [idUvoza=" + idUvoza + ", ulazniArtikal=" + ulazniArtikal + ", naim=" + naim + ", neto="
				+ neto + ", kom=" + kom + ", ukupnaCena=" + ukupnaCena + "]";
	}
}
