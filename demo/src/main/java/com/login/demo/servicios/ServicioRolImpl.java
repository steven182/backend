package com.login.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.login.demo.Dao.RepositorioRol;
import com.login.demo.modelo.Rol;

@Service
public class ServicioRolImpl implements ServicioRol {
	
	@Autowired
	protected RepositorioRol repositorioRol;

	@Override
	public Rol save(Rol rol) {
		this.repositorioRol.save(rol);
		return null;
	}
}
