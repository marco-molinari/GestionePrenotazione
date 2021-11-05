package it.marcomolinari.model.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.marcomolinari.model.Postazione;
import it.marcomolinari.model.Prenotazione;
import it.marcomolinari.model.User;
import it.marcomolinari.model.service.PostazioneService;
import it.marcomolinari.model.service.PrenotazioneService;
import it.marcomolinari.model.service.UserService;


@RestController
@RequestMapping("/prenotazionecontroller")
public class PrenotazioneController {
	@Autowired
	PrenotazioneService prenotazioneService;
	@Autowired
	UserService userService;
	@Autowired
	PostazioneService postService;
	
	@GetMapping("/findall")
	public List<Prenotazione> findAll(){
		return prenotazioneService.findAllPrenotazione();
		}
	@GetMapping("/findbyid")
	public Optional<Prenotazione> findById(@RequestParam Long id){
		return prenotazioneService.findPrenotazioneById(id);
	}
	@PostMapping("/save")
	public void savePrenotazione(@RequestBody User user, Postazione postazione, LocalDate dataPrenotata) {
		prenotazioneService.savePrenotazione(user, postazione, dataPrenotata);
		
	}
    @GetMapping("/savebookingget")
    public void save(@RequestParam Long userId, Long postId, int y, int m, int d) {
       prenotazioneService.savePrenotazione(userService.getById(userId), postService.getById(postId), LocalDate.of(y, m, d));
    }
    @GetMapping("/getallprenotazione")
    public Page<Prenotazione> getAllPrenotazione(@RequestParam Integer page, @RequestParam Integer size){
    	return prenotazioneService.findAllPrenotazionePgae(page, size);
    }
    @GetMapping("/getprenotazionesorted")
    public List<Prenotazione> getPrenotazioneSorted(){
    	return prenotazioneService.getPrenotazioneSorted();
    }
    @GetMapping("/getprenotazionepageable")
    public Page<Prenotazione> getAllPrenotazionePageable(Pageable pageable){
    	return prenotazioneService.getAllPrenotazionePageable(pageable);
    }
}

