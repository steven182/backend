package com.login.demo.modelo;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name = "rol")
@Access(AccessType.FIELD)
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol", unique = true, nullable = false)
	private int idRol;
	@Column(name = "nombre", nullable = true, length = 45)
	private String nombre;
	@Column(name = "descripcion", nullable = true, length = 45)
	private String descripcion;
	@Column(name = "estado", nullable = true)
	private boolean estado = true;
	
	public int getIdRol() {
		return idRol;
	}

	public void setIdrol(int idRol) {
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
	
	

}
