package it.marcomolinari.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.marcomolinari.model.Postazione;
import it.marcomolinari.model.TipoPostazione;
import it.marcomolinari.model.repository.PostazioneRepository;
import it.marcomolinari.model.service.PostazioneService;

@RestController
@RequestMapping("/postazionecontroller")
public class PostazioneController {
	@Autowired
	PostazioneService postazioneService;

	@GetMapping("/findall")
	public List<Postazione> findAll() {
		return postazioneService.allPostazione();
	}

	@GetMapping("/findbyid")
	public Optional<Postazione> findById(@RequestParam Long id) {
		return postazioneService.findPostazioneById(id);
	}

	@PostMapping("/save")
	public void savePostazione(@RequestBody Postazione p) {

		postazioneService.savePostazione(p);
	}

	@GetMapping("/save")
	public Postazione savePostazione(@RequestParam String codice, String descrizione, Integer numeroMassimo,
			TipoPostazione tipo, Long idEdificio) {
		return postazioneService.savePostazione(codice, descrizione, numeroMassimo, tipo, idEdificio);
	}

	@GetMapping("/findbytipo")
	public List<Optional<Postazione>> findByTipo(@RequestParam TipoPostazione tipo, String city) {
		return postazioneService.findByTipo(tipo, city);
	}

	@GetMapping("/getallpostazionepage")
	public Page<Postazione> getAllPostazionePage(@RequestParam Integer page, @RequestParam Integer size) {
		Page<Postazione> findAll = postazioneService.findPostazionePage(page, size);
		return findAll;
	}

	@GetMapping("/getallpostazionesort")
	public List<Postazione> getAllPostazioneSort() {
		return postazioneService.getAllPostazioneSorted();
	}

	@GetMapping("/getpostazionepageable")
	public Page<Postazione> getAllPostazionePageable(Pageable pageable) {
		return postazioneService.getPostazionePageable(pageable);
	}

}
