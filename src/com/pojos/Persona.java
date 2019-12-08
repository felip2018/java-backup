package com.pojos;

public class Persona {
	
	private String nombre;
	private String apellido;
	private boolean procesado;
	private int[] procesar;
	
	public Persona() {
		
	}

	public Persona(String nombre, String apellido, boolean procesado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.procesado = procesado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}

	public void setProcesar(int[] procesar) {
		this.procesar = procesar;
	}
	
}
