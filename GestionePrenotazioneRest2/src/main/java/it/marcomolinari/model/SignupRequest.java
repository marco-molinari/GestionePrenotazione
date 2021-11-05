package it.marcomolinari.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequest {
    private String username;
    private String email;
    private Set<String> role;
    private String password;
    private String nome;
    private String cognome;
    
}
