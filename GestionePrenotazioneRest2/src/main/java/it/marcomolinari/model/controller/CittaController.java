package it.marcomolinari.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.marcomolinari.model.Citta;
import it.marcomolinari.model.service.CittaService;

@RestController
@RequestMapping("/cittacontroller")
public class CittaController {

	@Autowired
	CittaService cittaService;

	@GetMapping("/findall")
	public List<Citta> findAllCity() {
		return cittaService.findAllCitta();
	}
	@GetMapping("/findbyid")
	public Optional<Citta> findCityById(@RequestParam Long id){
		return cittaService.findCittaById(id);
	}
	@PostMapping("/save")
	public void saveCity(@RequestParam String nome) {
		Citta city= new Citta(nome);
		cittaService.saveCitta(city);
	}
	@GetMapping("/getbynome")
	public List<Optional<Citta>> getByNome( @RequestParam String nome){
		return cittaService.getByNome(nome);
	}
	
    @GetMapping(value = "/mygetallcitypage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Citta>> myGetAllUsersPage(Pageable pageable) {
        Page<Citta> findAll = cittaService.myFindAllUsersPageable(pageable);
        if (findAll.hasContent()) {
            return new ResponseEntity<>(findAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getallcitta")
    public Page<Citta> gettAllCitta(@RequestParam Integer page,@RequestParam Integer size){
    	return cittaService.getAllCitta(page, size);
    }
    @GetMapping("/getcittapageable")
    public Page<Citta> getAllCittaPageabe(Pageable pageable){
    	return cittaService.getCittaPageable(pageable);
    }
}
