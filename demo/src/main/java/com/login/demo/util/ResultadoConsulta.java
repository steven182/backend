package com.login.demo.util;

import java.util.List;

public class ResultadoConsulta {
	private int totalRegistros;
	private List<?> lista;
	
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	public List<?> getLista() {
		return lista;
	}
	public void setLista(List<?> lista) {
		this.lista = lista;
	}
	
	
}
