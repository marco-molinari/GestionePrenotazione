package it.marcomolinari.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.marcomolinari.model.Role;
import it.marcomolinari.model.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleType(RoleType roletype);

}
