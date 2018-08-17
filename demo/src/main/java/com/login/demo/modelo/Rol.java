package com.login.demo.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rol")
@Access(AccessType.FIELD)
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol", unique = true, nullable = false)
	private Long idRol;
	@Column(name = "nombre", nullable = true, length = 45)
	private String nombre;
	@Column(name = "descripcion", nullable = true, length = 45)
	private String descripcion;
	@Column(name = "estado", nullable = true)
	private boolean estado = true;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rolIdRol")
	private List<Persona> listaPersona;
	
	public Rol() {}
	public Long getIdRol() {
		return idRol;
	}

	public void setIdrol(Long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@XmlTransient
    @JsonIgnore
	public List<Persona> getListaPersona() {
		return listaPersona;
	}
	public void setListaPersona(List<Persona> listaPersona) {
		this.listaPersona = listaPersona;
	}
}
