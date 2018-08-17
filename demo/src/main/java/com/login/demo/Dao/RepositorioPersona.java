package com.login.demo.Dao;

import com.login.demo.modelo.Persona;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface RepositorioPersona extends JpaRepository<Persona, Long>, PagingAndSortingRepository<Persona, Long> {

	@SuppressWarnings("unchecked")
	Persona save(Persona persona);

	List<Persona> login(@Param("mail") String correo, @Param("pass") String clave);
	
	public Page<Persona> findAll(Pageable p);

}
