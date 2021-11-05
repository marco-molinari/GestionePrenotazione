package it.marcomolinari.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.marcomolinari.model.Postazione;
import it.marcomolinari.model.Prenotazione;
import it.marcomolinari.model.User;
import it.marcomolinari.model.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	public boolean checkMaxNumber(Postazione postazione, LocalDate dataPrenotata) {
		List<Optional<Prenotazione>> prenotazioni = prenotazioneRepository.findPrenotazione(dataPrenotata, postazione);
		if (prenotazioni.size() < postazione.getNumeroMassimoOccupati()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkMinDate(LocalDate dataPrenotata) {
		LocalDate today = LocalDate.now();
		if (dataPrenotata.minusDays(1).isAfter(today)) {
			return true;
		}
		return false;
	}

	public boolean checkUser(User user, LocalDate dataPrenotata) {
		List<Optional<Prenotazione>> lista = prenotazioneRepository.findPrenotazionePerUtente(user, dataPrenotata);
		if (lista.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void savePrenotazione(User user, Postazione postazione, LocalDate dataPrenotata) {

		if (checkMaxNumber(postazione, dataPrenotata)) {
			if (checkMinDate(dataPrenotata)) {
				if (checkUser(user, dataPrenotata)) {
					prenotazioneRepository.save(new Prenotazione(user, postazione, dataPrenotata));
					System.out.println("Postazione Prenotata");

				} else {
					System.out.println("L'utente ha già una prenotazione attiva per la data selezionata");
				}
			} else {
				System.out.println("Prenotazioni disponibili solo oltre i due giorni");
			}
		} else {
			System.out.println("Postazione non disponibile");
		}
	}

	public List<Prenotazione> findAllPrenotazione() {
		return prenotazioneRepository.findAll();
	}

	public Optional<Prenotazione> findPrenotazioneById(Long id) {
		return prenotazioneRepository.findById(id);
	}
	public Page<Prenotazione> findAllPrenotazionePgae(Integer page, Integer size){
		Pageable pageable= PageRequest.of(page, size);
		return prenotazioneRepository.findAll(pageable);
	}
	public List<Prenotazione> getPrenotazioneSorted(){
		return prenotazioneRepository.findByOrderByDataPrenotataAsc();
	}
	public Page<Prenotazione> getAllPrenotazionePageable(Pageable pageable){
		return prenotazioneRepository.findAll(pageable);
	}
}
