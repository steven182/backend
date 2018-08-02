package com.login.demo.servicios;

import java.util.List;

import com.login.demo.modelo.Persona;

public interface ServicioPersona {
	
	//Guarda la persona, y retorna la persona guardada
	Persona save(Persona persona);

	//Obtiene la lista de personas
	List<Persona> findAll();

}
