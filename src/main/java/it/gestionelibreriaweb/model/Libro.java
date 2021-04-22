package it.gestionelibreriaweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "genere")
	private String genere;
	@Column(name = "pagine")
	private Integer pagine;
	@Column(name = "data_di_pubblicazione")
	private Date dataDiPubblicazione;

	public Libro() {
	}

	public Libro(String titolo, String genere, Integer pagine, Date dataDiPubblicazione) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.pagine = pagine;
		this.dataDiPubblicazione = dataDiPubblicazione;
	}
	
	public Libro(String titolo, String genere) {
		super();
		this.titolo = titolo;
		this.genere = genere;
	}
	
	public Libro(Long id, String titolo, String genere, Date dataDiPubblicazione) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
		this.dataDiPubblicazione = dataDiPubblicazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Integer getPagine() {
		return pagine;
	}

	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}

	public Date getDataDiPubblicazione() {
		return dataDiPubblicazione;
	}

	public void setDataDiPubblicazione(Date dataDiPubblicazione) {
		this.dataDiPubblicazione = dataDiPubblicazione;
	}

}
