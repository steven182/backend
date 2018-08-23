package com.login.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.login.demo.modelo.Persona;

public interface RepositorioPersona extends JpaRepository<Persona, Long> {

	@SuppressWarnings("unchecked")
	Persona save(Persona persona);
  
	List<Persona> login(@Param("mail") String correo, @Param("pass") String clave);
	
	Persona PersonaById(@Param("id") Long id);
	
	List<Persona> PersonaByName(@Param("name") String nombres);


}
