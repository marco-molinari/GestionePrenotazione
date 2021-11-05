package it.marcomolinari.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.marcomolinari.model.Citta;
import it.marcomolinari.model.repository.CittaRepository;

@Service
public class CittaService {
	@Autowired
	private CittaRepository cittaRepository;

	public List<Citta> findAllCitta(){
		return cittaRepository.findAll();
	}
	public Optional<Citta> findCittaById(Long id){
		return cittaRepository.findById(id);
	}
	public void saveCitta(Citta citta) {
		cittaRepository.save(citta);
	}
	
	public List<Optional<Citta>> getByNome(String nome){
		return cittaRepository.getByNome(nome);
	}
	// Paginazione
    public Page<Citta> myFindAllUsersPageable(Pageable pageable) {
        return cittaRepository.findAll(pageable);
    }
    public Page<Citta> getAllCitta(Integer page, Integer size){
    	Pageable pageable=PageRequest.of(page, size);
    	return cittaRepository.findAll(pageable);
    }
    public Page<Citta> getCittaPageable(Pageable pageable){
    	return cittaRepository.findAll(pageable);
    }
}
