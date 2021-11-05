package it.marcomolinari.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.marcomolinari.model.Edificio;
import it.marcomolinari.model.repository.CittaRepository;
import it.marcomolinari.model.repository.EdificioRepository;

@Service
public class EdificioService {
	@Autowired
	private EdificioRepository edificioRepository;
	@Autowired
	CittaRepository cittaRepository;
	
	public void saveEdificio(Edificio ed) {
		edificioRepository.save(ed);
	}
	public void saveEdificioGet(String nome,String indirizzo, Long idCitta, String pin) {
		edificioRepository.save(new Edificio(nome, indirizzo, cittaRepository.getById(idCitta),pin));
	}
	
	public List<Edificio> findAllEdificio(){
		return edificioRepository.findAll();
	}
	public Optional<Edificio> findEdificioById(Long id){
		return edificioRepository.findById(id);
		
	}
	public List<Optional<Edificio>> getEdificioByCitta(String citta){
		return edificioRepository.getEdificioByCitta(citta);
	}
	public Page<Edificio> getAllEdificio(Integer page, Integer size){
	Pageable pageable= PageRequest.of(page, size);
	return edificioRepository.findAll(pageable); 
	}
	public Page<Edificio> getAlledificioPageable(Pageable pageable){
		return edificioRepository.findAll(pageable);
	}
}
