package com.login.demo.servicios;

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
}
