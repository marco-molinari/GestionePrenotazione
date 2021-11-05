package it.marcomolinari.model.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.marcomolinari.model.Citta;
import it.marcomolinari.model.Edificio;
import it.marcomolinari.model.service.EdificioService;

@RestController
@RequestMapping("/edificiocontroller")
public class EdificioController {
	@Autowired
	EdificioService edificioService;
	
	@GetMapping("/findall")
	public List<Edificio> findAllEdificio(){
		return edificioService.findAllEdificio();
	}
	@GetMapping("/findbyid")
	public Optional<Edificio> findById(@RequestParam Long id){
		return edificioService.findEdificioById(id);
	}
	@PostMapping("/save")
	public String saveEdificio(@Valid @RequestBody Edificio edificio) {
		edificioService.saveEdificio(edificio);
		return"Edificio salvato";
		
	}
	@GetMapping("/saveget")
	public void saveEdificioGet(@RequestParam String nome,String indirizzo, Long idCitta, String pin ){
		edificioService.saveEdificioGet(nome, indirizzo, idCitta, pin);
	}
	@GetMapping("/getbycitta")
	public List<Optional<Edificio>> getEdificioByCitta(@RequestParam String citta){
		return edificioService.getEdificioByCitta(citta);
	}
	@GetMapping("/getalledificio")
	public Page<Edificio> getAllEdificio(@RequestParam Integer page, @RequestParam Integer size){
		return edificioService.getAllEdificio(page, size);
	}
	@GetMapping("/getedificiopageable")
	public Page<Edificio> getEdificioPageable(Pageable pageable){
		return edificioService.getAlledificioPageable(pageable);
	}
}
