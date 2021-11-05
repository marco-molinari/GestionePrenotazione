package it.marcomolinari.model.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.marcomolinari.model.Postazione;
import it.marcomolinari.model.Prenotazione;
import it.marcomolinari.model.User;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	@Query("SELECT p FROM Prenotazione p WHERE p.dataPrenotata=:data AND p.postazione=:postazione")
    public List<Optional<Prenotazione>> findPrenotazione(LocalDate data,Postazione postazione);

	
	@Query("SELECT p FROM Prenotazione p WHERE p.user=:user AND p.dataPrenotata=:data")
	public List<Optional<Prenotazione>> findPrenotazionePerUtente(User user, LocalDate data);
	
	Page<Prenotazione> findAll(Pageable pageable);
	
	List<Prenotazione> findByOrderByDataPrenotataAsc();
}
