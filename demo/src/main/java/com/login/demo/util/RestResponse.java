package com.login.demo.util;

public class RestResponse {
	
	private int codigoRespuesta;
	private String mensaje;
	
	public RestResponse(int codigoRespuesta) {
		super();
		this.codigoRespuesta = codigoRespuesta;
	}
	public RestResponse(int codigoRespuesta, String mensaje) {
		super();
		this.codigoRespuesta = codigoRespuesta;
		this.mensaje = mensaje;
	}
	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
