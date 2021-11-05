	package it.marcomolinari.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="postazione")
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codice;
	private String descrizione;
	private Integer numeroMassimoOccupati;
	private TipoPostazione tipoPostazione;
	@ManyToOne
	private Edificio edificio;
	
	
	
	
	public Postazione() {
	}
	public Postazione(String codice, String descrizione, Integer numeroMassimoOccupati,
			TipoPostazione tipoPostazione, Edificio edificio) {
		
		this.codice = codice;
		this.descrizione = descrizione;
		this.numeroMassimoOccupati = numeroMassimoOccupati;
		this.tipoPostazione = tipoPostazione;
		this.edificio = edificio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getNumeroMassimoOccupati() {
		return numeroMassimoOccupati;
	}
	public void setNumeroMassimoOccupati(Integer numeroMassimoOccupati) {
		this.numeroMassimoOccupati = numeroMassimoOccupati;
	}
	public TipoPostazione getTipoPostazione() {
		return tipoPostazione;
	}
	public void setTipoPostazione(TipoPostazione tipoPostazione) {
		this.tipoPostazione = tipoPostazione;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	
	
	
}
