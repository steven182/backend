package com.login.demo.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.login.demo.util.ResultadoConsulta;

@RestController
public class PersonaController {

	@Autowired
	protected ServicioPersona servicioPersona;
	protected ObjectMapper maper;
	protected ResultadoConsulta rc;
	
	@RequestMapping(value = "/guardarEditarPersona", method = RequestMethod.POST)
	public RestResponse guardarEditarPersona(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.maper = new ObjectMapper();
		Persona persona = this.maper.readValue(userJson, Persona.class);
		this.servicioPersona.save(persona);
		return new RestResponse(HttpStatus.OK.value(), "Exito!");
	}
	@RequestMapping(value = "/obtenerPersona", method = RequestMethod.GET)
	public List<Persona> obtenerPersona() {
		rc = new ResultadoConsulta();
		rc.setLista(servicioPersona.findAll());
		rc.setTotalRegistros(rc.getLista().size());
		float nRegistros = rc.getTotalRegistros();
		System.out.println(Math.round(nRegistros / 5));
		return this.servicioPersona.findAll();
	}
	@RequestMapping(value = "/obtenerPersonaPaginacion", method = RequestMethod.GET)
	public List<Persona> obtenerPersonaPaginacion(Pageable p){
		return this.servicioPersona.findPagination(p);
	
	}
	@RequestMapping(value = "/eliminarPersona", method = RequestMethod.POST)
	public void eliminarPersona(@RequestBody String userJson) throws Exception {
		this.maper = new ObjectMapper();
		Persona persona = this.maper.readValue(userJson, Persona.class);
		if(persona.getIdPersona() == null) {
			throw new Exception("El id esta nulo");
		}
		this.servicioPersona.borrarPersona(persona.getIdPersona());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Boolean login(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.maper = new ObjectMapper();
		Persona persona = this.maper.readValue(userJson, Persona.class);
		List<Persona> per = this.servicioPersona.obtenerPorId(persona.getCorreo(), persona.getClave());
		if((!per.isEmpty())) {
			System.out.println("hay algo");
			per.get(0);
			return true;
		}
			System.out.println("no hay nada");
			return false;
		
	
	}
}
