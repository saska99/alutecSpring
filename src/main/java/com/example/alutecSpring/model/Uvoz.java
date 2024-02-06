package com.example.alutecSpring.model;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "uvoz")
@EntityListeners(AuditingEntityListener.class)
public class Uvoz {

    @Id
    @Column(name = "sifra_uvoza", nullable = false)
    private String sifraUvoza;

    @Column(name = "post", nullable = false)
    private String post;

    @Column(name = "zp", nullable = false)
    private String zp;

    @Temporal(TemporalType.DATE)
    @Column(name = "datum_uvoza", nullable = false)
    private Date datumUvoza;
    
    
    public Uvoz() {
        
    }

    public Uvoz(String sifraUvoza, String post, String zp, Date datumUvoza) {
        this.sifraUvoza = sifraUvoza;
        this.post = post;
        this.zp = zp;
        this.datumUvoza = datumUvoza;
    }


	public String getSifraUvoza() {
		return sifraUvoza;
	}
	public void setSifraUvoza(String sifraUvoza) {
		this.sifraUvoza = sifraUvoza;
	}
	

	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	

	public String getZp() {
		return zp;
	}
	public void setZp(String zp) {
		this.zp = zp;
	}
	

	public Date getDatumUvoza() {
	    return datumUvoza;
	}
	public void setDatumUvoza(Date datumUvoza) {
		this.datumUvoza = datumUvoza;
	}

	@Override
	public String toString() {
		return "Uvoz [sifraUvoza=" + sifraUvoza + ", post=" + post + ", zp=" + zp + ", datumUvoza=" + datumUvoza + "]";
	}
	
	
}
