package com.login.demo.Dao;

import com.login.demo.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPersona extends JpaRepository<Persona, Long> {

	@SuppressWarnings("unchecked")
	Persona save(Persona persona);
	
}
