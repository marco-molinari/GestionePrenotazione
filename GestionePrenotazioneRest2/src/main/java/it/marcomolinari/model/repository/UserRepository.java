package it.marcomolinari.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.marcomolinari.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Page<User> findAll(Pageable pageable);
	
	/* Sort */
    // Formula: findBy + OrderBy + NomeColonna + Ordinamento(Asc/Desc)
    public List<User> findByOrderByNomeAsc();

	public Optional<User> findByUsername(String username);

	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);

}
