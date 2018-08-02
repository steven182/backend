package com.login.demo.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.demo.modelo.Persona;
import com.login.demo.servicios.ServicioPersona;
import com.login.demo.util.RestResponse;

@RestController
public class PersonaController {

	@Autowired
	protected ServicioPersona servicioPersona;
	protected ObjectMapper maper;
	
	@RequestMapping(value = "/guardarEditarPersona", method = RequestMethod.POST)
	public RestResponse guardarEditarPersona(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.maper = new ObjectMapper();
		Persona persona = this.maper.readValue(userJson, Persona.class);
		this.servicioPersona.save(persona);
		return new RestResponse(HttpStatus.OK.value(), "Exito!");
	}
	@RequestMapping(value = "/obtenerPersona", method = RequestMethod.GET)
	public List<Persona> obtenerPersona() {
		return this.servicioPersona.findAll();
	}
}
