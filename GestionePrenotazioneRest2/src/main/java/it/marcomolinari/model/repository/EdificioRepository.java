package it.marcomolinari.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.marcomolinari.model.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long>{
	@Query("SELECT e FROM Edificio e WHERE e.citta.nome=:citta")
	List<Optional<Edificio>> getEdificioByCitta(String citta);
	
	Page<Edificio> findAll(Pageable pageable);
}
