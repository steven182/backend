package com.login.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.login.demo.Dao.RepositorioPersona;
import com.login.demo.modelo.Persona;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersonaImpl implements ServicioPersona{
	
	@Autowired
	protected RepositorioPersona repositorioPersona;

	@Override
	public Persona save(Persona persona) {
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
