package it.marcomolinari.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import it.marcomolinari.security.StringAttributeConverter;
import lombok.Data;
@Data
@Entity
@Table(name="edificio")
public class Edificio {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String indirizzo;
	@ManyToOne
	private Citta citta;
	@Convert(converter=StringAttributeConverter.class)
	@Size(min=8, max=8, message="Pin deve essere di 8")
	private String pin;
	
	
	
	
	public Edificio() {
	
	}
	public Edificio( String nome, String indirizzo, Citta citta, String pin) {
	
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		
		this.pin=pin;
	}

	
}
