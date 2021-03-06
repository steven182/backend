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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "persona")
@NamedQueries({
	@NamedQuery(name = "Persona.login", query = "select p from Persona p where p.correo=:mail and p.clave=:pass"),
	@NamedQuery(name = "Persona.PersonaById", query = "select p from Persona p where p.idPersona=:id"),
	@NamedQuery(name = "Persona.PersonaByName", query = "select p from Persona p where p.nombres=:name")})
@Access(AccessType.FIELD)
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpersona", unique = true, nullable = false)
	private Long idPersona;
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
	private String clave;
	@Column(name = "foto", nullable = true, length = 255)
	private String foto;
	@JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
	@ManyToOne(optional = false)
	private Rol rolIdRol;

	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
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
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Rol getRolIdRol() {
		return rolIdRol;
	}
	public void setRolIdRol(Rol rolIdRol) {
		this.rolIdRol = rolIdRol;
	}
	
	
	

}
