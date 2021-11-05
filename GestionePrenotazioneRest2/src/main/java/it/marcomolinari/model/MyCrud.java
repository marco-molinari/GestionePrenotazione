package it.marcomolinari.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.marcomolinari.model.service.CittaService;
import it.marcomolinari.model.service.EdificioService;
import it.marcomolinari.model.service.PostazioneService;
import it.marcomolinari.model.service.PrenotazioneService;
import it.marcomolinari.model.service.RoleService;
import it.marcomolinari.model.service.UserService;

@Component
public class MyCrud implements CommandLineRunner {
	@Autowired
	PostazioneService postazioneService;
	@Autowired
	PrenotazioneService prenotazioneService;
	@Autowired
	RoleService roleService;
	@Autowired
	CittaService serviceCitta;
	@Autowired
	EdificioService serviceEdificio;
	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {
//		User user=new User("Tart91", "Marco", "molinari.mrc@gmail.com", "10234","Molinari");
//		userService.saveUser(user);
//		
		Citta citta=new Citta("Roma");
        serviceCitta.saveCitta(citta);
        Edificio edificio=new Edificio("Duomo", "via dei mille 1", citta,"12346578");
        serviceEdificio.saveEdificio(edificio);
//       roleService.saveRole(new Role(RoleType.ROLE_ADMIN));
//        Postazione postazione=new Postazione("P245I", "Poltronissima", 3, TipoPostazione.OPENSPACE, edificio);
//        postazioneService.savePostazione(postazione);
//        prenotazioneService.savePrenotazione(userService.getById(6l), postazione, LocalDate.of(2021, 10, 29));  
//        
    }
}

