package com.login.demo.controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.login.demo.modelo.Persona;
import com.login.demo.servicios.ServicioPersona;
import com.login.demo.util.RestResponse;

@CrossOrigin
@RestController
public class PersonaController {

	@Autowired
	protected ServicioPersona servicioPersona;
	protected ObjectMapper maper;

	// Guardar o editar personas
	@RequestMapping(value = "/guardarEditarPersona", method = RequestMethod.PUT)
	public RestResponse guardarEditarPersona(@RequestBody Persona userJson)
			throws JsonParseException, JsonMappingException, IOException {
		// this.maper = new ObjectMapper();
		// Persona persona = this.maper.readValue(userJson, Persona.class);
		servicioPersona.save(userJson);
		return new RestResponse(HttpStatus.OK.value(), "Exito!");
	}

	/*Obtener personas, se puede pasar el nombre como parametro para traer la
	 persona que se requiera*/
	@RequestMapping(value = "/obtenerPersona", method = RequestMethod.GET)
	public List<Persona> obtenerPersona(@RequestParam(value = "nombre", required = false) String nombre) {
		if (nombre == null) {
			return this.servicioPersona.findAll();
		} else {
			return this.servicioPersona.findByName(nombre);
		}
	}

	// Obtener persona por id, se envia el id por la URI
	@RequestMapping(value = "/obtenerPersonaId/{idP}", method = RequestMethod.GET)
	public Persona obtenerPersonaId(@PathVariable("idP") Long idPersona) {
		return this.servicioPersona.findById(idPersona);
	}

	// Elimina una persona segun el ID
	@RequestMapping(value = "/eliminarPersona/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public void eliminarPersona(@PathVariable("id") Long userJson) throws Exception {
		// this.maper = new ObjectMapper();
		// Persona persona = this.maper.readValue(userJson, Persona.class);
		if (userJson == null) {
			throw new Exception("El id esta nulo");
		}
		this.servicioPersona.borrarPersona(userJson);
	}

	// Comprueba si la persona esta registrada en la BD
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public Boolean login(@RequestBody Persona userJson) throws JsonParseException, JsonMappingException, IOException {
		// this.maper = new ObjectMapper();
		// Persona persona = this.maper.readValue(userJson, Persona.class);
		List<Persona> per = this.servicioPersona.obtenerPorId(userJson.getCorreo(), userJson.getClave());
		if ((!per.isEmpty())) {
			System.out.println("hay algo");
			per.get(0);
			return true;
		}
		System.out.println("no hay nada");
		return false;
	}
	
	public static final String UrlImagenes = "img/persona/";
	//Subir una imagen
	@RequestMapping(value = "/imagen", method = RequestMethod.POST, headers = ("content-type=multipart/form-data"))
	public ResponseEntity<byte[]> cargarImagen(@RequestParam(value="id") Long idPersona, 
			@RequestParam(value="img") MultipartFile file,
			UriComponentsBuilder ucb){
		if(idPersona == null || file.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		Persona p = servicioPersona.findById(idPersona);
		if(p == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		if(!p.getFoto().isEmpty() || p.getFoto() != null) {
			String fileName = p.getFoto();
			Path path = Paths.get(fileName);
			File f = path.toFile();
			if (f.exists()) {
				f.delete();
			}	
		}
		try {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateN = sdf.format(d);
			
			String nombreArchivo = String.valueOf(idPersona) + "img" + dateN + "." 
			+ file.getContentType().split("/")[1];  
			p.setFoto(UrlImagenes + nombreArchivo);
			byte[] bt = file.getBytes();
			Path pt = Paths.get(UrlImagenes + nombreArchivo);
			Files.write(pt, bt);
			servicioPersona.save(p);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bt);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(file.getOriginalFilename(), HttpStatus.CONFLICT);
		}
	}

	//Obtener imagen por ID
	@RequestMapping(value = "persona/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> obtenerFotoPersona(@PathVariable("id") Long idPersona){
		Persona persona = servicioPersona.findById(idPersona);
		if(persona == null) {
			return new ResponseEntity("no hay fotos", HttpStatus.CONFLICT);
		}
		try {
			String fileName = persona.getFoto();
			Path p = Paths.get(fileName);
			File f = p.toFile();
			if(!f.exists()) {
				return new ResponseEntity(HttpStatus.CONFLICT);
			}
			byte[] img = Files.readAllBytes(p);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}
	//Eliminar una imagen
	@RequestMapping(value = "persona/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> eliminarImagen(@PathVariable("id") Long idPersona){
		Persona pe = servicioPersona.findById(idPersona);
		if(pe.getFoto().isEmpty() || pe.getFoto() == null) {
			return new ResponseEntity("Esta persona no tiene foto", HttpStatus.NO_CONTENT);
		}
		String file = pe.getFoto();
		Path path = Paths.get(file);
		File fl = path.toFile();
		if(fl.exists()) {
			fl.delete();
		}
		pe.setFoto("nada");
		servicioPersona.save(pe);
		return new ResponseEntity("Se elimino correctamente", HttpStatus.NO_CONTENT);
	}
}





