package com.login.demo.servicios;

import java.util.List;

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
		return this.repositorioRol.save(rol); 
	}

	@Override
	public List<Rol> findAll() {
		return this.repositorioRol.findAll();
	}
}
