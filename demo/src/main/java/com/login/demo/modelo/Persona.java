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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "persona")
@Access(AccessType.FIELD)
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idpersona", unique = true, nullable = false)
	private int idPersona;
	@Column(name = "nombres", nullable = true, length = 45)
	private String nombres;
	@Column(name = "apellidos", nullable = true, length = 45)
	private String apellidos;
	@Column(name = "telefono", nullable = true, length = 45)
	private String telefono;
	@Column(name = "direccion", nullable = true, length = 45)
	private String direccion;
	@Column(name = "correo", nullable = true, length = 45)
	private String correo;
	@Column(name = "clave", nullable = true, length = 45)
	private String Clave;
	@JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
	@ManyToOne(optional = false)
	private Rol rolIdRol;
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public Rol getRolIdRol() {
		return rolIdRol;
	}
	public void setRolIdRol(Rol rolIdRol) {
		this.rolIdRol = rolIdRol;
	}
	
	
	

}