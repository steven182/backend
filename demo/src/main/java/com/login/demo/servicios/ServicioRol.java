package com.login.demo.servicios;

import java.util.List;

import com.login.demo.modelo.Rol;

public interface ServicioRol {

	//Guarda el, y retorna el rol guardado
	Rol save(Rol rol);

	//Obtiene la lista de roles
	List<Rol> findAll();
}
