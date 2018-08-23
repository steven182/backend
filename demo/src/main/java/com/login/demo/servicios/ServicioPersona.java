package com.login.demo.servicios;

import java.util.List;

import com.login.demo.modelo.Persona;

public interface ServicioPersona {
	
	//Guarda la persona, y retorna la persona guardada
	Persona save(Persona persona);

	//Obtiene la lista de personas
	List<Persona> findAll();

	//Elimina a una persona dependiendo el ID
	void borrarPersona(Long idPersona);

	//Login
	List<Persona> obtenerPorId(String correo, String clave);
	
	//Obtiene una persona por ID
	Persona findById(Long idPersona);
	
	//Obtine una ersona por nombre
	List<Persona> findByName(String nombre);

}
