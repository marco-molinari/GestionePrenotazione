package it.marcomolinari.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.marcomolinari.model.Citta;

public interface CittaRepository extends JpaRepository<Citta,Long> {
@Query("SELECT c FROM Citta c WHERE c.nome=:nome")
List<Optional<Citta>> getByNome(String nome);

public Page<Citta> findAll(Pageable pageable);
}

