package it.marcomolinari.model.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/controller")
public class GestioneController {
	
	@GetMapping("/altro")
    String myGetError() {
        try {
            throw new RuntimeException("Error Occured");
            }catch(RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
    }
	
	@GetMapping("/italiano")
    String myGetItaliano() {
        return "La prenotazione vale per un solo giorno e può essere effettuata solo se per quel giorno la postazione risulta libera. \r\n"
        		+ "Un utente può ricercare le postazioni indicando il tipo di postazione desiderato e la città di interesse.\r\n"
        		+ "Un utente può avere più prenotazioni in corso, ma non può prenotare più di una postazione per una particolare data.";
    }
    @GetMapping("/inglese")
    String myGetEnglish() {
        return "The reservation is valid for one day only and can only be made if the station is free for that day. \r\n"
                + "A user can search for stations indicating the type of location desired and the city of interest. \r\n"
                + "A user can have multiple bookings in progress, but cannot book more than one seat for a particular date.";
    }

}
