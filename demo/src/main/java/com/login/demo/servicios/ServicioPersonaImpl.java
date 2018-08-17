package com.login.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.login.demo.Dao.RepositorioPersona;
import com.login.demo.modelo.Persona;
import com.login.demo.modelo.Rol;;

@Service
public class ServicioPersonaImpl implements ServicioPersona {
	Rol rol = new Rol();
	@Autowired
	protected RepositorioPersona repositorioPersona;

	@Override
	public Persona save(Persona persona) {
		if (persona.getIdPersona() == null) {
			rol.setIdrol((long) 2);
			persona.setRolIdRol(rol);
			repositorioPersona.save(persona);
		}
		persona.getRolIdRol();
		return repositorioPersona.save(persona);

	}

	@Override
	public List<Persona> findAll() {
		return repositorioPersona.findAll();
	}

	@Override
	public void borrarPersona(Long idPersona) {
		this.repositorioPersona.deleteById(idPersona);

	}

	@Override
	public List<Persona> obtenerPorId(String correo, String clave) {
		return repositorioPersona.login(correo, clave);

	}

	@Override
	public List<Persona> findPagination(Pageable p) {
		return repositorioPersona.findAll(p).getContent();
	}
}
