package com.example.alutecSpring.model;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "izvozfaktura")
@EntityListeners(AuditingEntityListener.class)
public class IzvozFaktura {
	

    @Id
    @Column(name = "broj_fakture", nullable = false)
    private int brojFakture;

    @Temporal(TemporalType.DATE)
    @Column(name = "datum_izvoza", nullable = false)
    private Date datumIzvoza;
    
   
	public IzvozFaktura() {

	}

	public IzvozFaktura(int brojFakture, Date datumIzvoza) {
		this.brojFakture = brojFakture;
		this.datumIzvoza = datumIzvoza;
	}

	public int getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(int brojFakture) {
		this.brojFakture = brojFakture;
	}

	public Date getDatumIzvoza() {
		return datumIzvoza;
	}

	public void setDatumIzvoza(Date datumIzvoza) {
		this.datumIzvoza = datumIzvoza;
	}

	@Override
	public String toString() {
		return "IzvozFaktura [brojFakture=" + brojFakture + ", datumIzvoza=" + datumIzvoza + "]";
	}

}

