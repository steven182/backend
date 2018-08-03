package com.login.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.login.demo.Dao.RepositorioPersona;
import com.login.demo.modelo.Persona;
import org.springframework.stereotype.Service;
import com.login.demo.modelo.Rol;;

@Service
public class ServicioPersonaImpl implements ServicioPersona{
	Rol rol = new Rol();
	@Autowired
	protected RepositorioPersona repositorioPersona;

	@Override
	public Persona save(Persona persona) {
		rol.setIdrol((long) 2);
		persona.setRolIdRol(rol);
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
}
