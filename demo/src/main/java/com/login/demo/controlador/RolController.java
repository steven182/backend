package com.login.demo.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.demo.servicios.ServicioRol;
import com.login.demo.util.RestResponse;
import com.login.demo.modelo.Rol;

@RestController
public class RolController {

	@Autowired
	protected ServicioRol servicioRol;
	protected ObjectMapper maper;
	
	@RequestMapping(value = "/guardarEditarRol", method = RequestMethod.POST)
	public RestResponse guardarEditarRol(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.maper = new ObjectMapper();
		Rol rol = this.maper.readValue(userJson, Rol.class);
		this.servicioRol.save(rol);
		return new RestResponse(HttpStatus.OK.value(), "Exito!23");
	}
	
	@RequestMapping(value = "/obtenerRol", method = RequestMethod.GET)
	public List<Rol> obtenerRol() {
		return this.servicioRol.findAll();
	}
	
	@RequestMapping(value = "/eliminarRol", method = RequestMethod.POST)
	public void eliminarRol(@RequestBody String userJson) throws Exception {
		this.maper = new ObjectMapper();
		Rol rol = this.maper.readValue(userJson, Rol.class);
		if(rol.getIdRol() == null) {
			throw new Exception("El id esta nulo");
		}
		this.servicioRol.borrarRol(rol.getIdRol());
	}
}
