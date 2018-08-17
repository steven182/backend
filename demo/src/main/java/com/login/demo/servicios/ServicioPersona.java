package com.login.demo.servicios;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.login.demo.modelo.Persona;

public interface ServicioPersona {
	
	//Guarda la persona, y retorna la persona guardada
	Persona save(Persona persona);

	//Obtiene la lista de personas
	List<Persona> findAll();

	//Elimina a una persona dependiendo el ID
	void borrarPersona(Long idPersona);

	List<Persona> obtenerPorId(String correo, String clave);
	
	//Paginacion de datos
	List<Persona> findPagination(Pageable p);
	

}
