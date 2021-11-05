package it.marcomolinari.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.marcomolinari.model.Citta;
import it.marcomolinari.model.Role;
import it.marcomolinari.model.RoleType;
import it.marcomolinari.model.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAllRole(){
		return roleRepository.findAll();
	}
	public Optional<Role> getRoleById(Long id){
		return roleRepository.findById(id);
	}
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
}
