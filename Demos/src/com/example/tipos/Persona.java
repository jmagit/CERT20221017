package com.example.tipos;

import java.time.LocalDate;

public class Persona {
	public static final int MAYORIA_EDAD = 18;
	public final int edadJubilacion;
	
	private int id = 0;
	private String nombre = "(anonimo)";
	private String apellidos;
	private LocalDate fechaNacimiento;
	private int edad = -1;
	
	public Persona() {
		edadJubilacion = 67;
	}
	
	public Persona(int id, String nombre, String apellidos) {
		this(id, nombre, apellidos, null, 67);
	}
	public Persona(int id, String nombre, String apellidos, LocalDate fechaNacimiento, int edadJubilacion) {
		this.id = id;
		setNombre(nombre);
		this.apellidos = apellidos;
		setFechaNacimiento(fechaNacimiento);
		this.edadJubilacion = edadJubilacion;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String valor) {
		if(nombre.equals(valor)) return;
		if(nombre == null || nombre.trim().length() < 2)
			throw new IllegalArgumentException("El nombre es obligatorio");
		nombre = valor;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private int calculaEdad() {
		return -1;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null) {
			edad = -1;
		}
		this.fechaNacimiento = fechaNacimiento;
		// calculo la edad
		edad = calculaEdad();
	}

	public int getEdad() {
		return edad;
	}

	public boolean isJuvilado() {
		return edad >= edadJubilacion;
	}

	public void jubilate() {
		int i = nombre.length();
	}
	
}
