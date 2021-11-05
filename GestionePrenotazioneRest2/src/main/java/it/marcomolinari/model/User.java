package it.marcomolinari.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import it.marcomolinari.security.StringAttributeConverter;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String nome;
	private String cognome;
	@Convert(converter=StringAttributeConverter.class)
	private String email;
	private String password;
	private Boolean active=true;
	@ManyToMany
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="roles_id"))
	private Set<Role> roles= new HashSet<>();
	
	
	
	
	public User() {
	}
	
	public User( String username, String email, String password,String nome, String cognome) {
		
		
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.active = true;
		this.cognome=cognome;
	
	}
	
	
	
}
