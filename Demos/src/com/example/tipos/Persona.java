package com.example.tipos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;

import com.example.excepciones.DemosException;

public abstract class Persona implements Cloneable, Grafico {
	public static final int MAYORIA_EDAD = 18;
	public final int edadJubilacion;
	
	private int id = 0;
	private String nombre = "(anonimo)";
	private String apellidos;
	private LocalDate fechaNacimiento;
	private Integer edad = null;
	
//	public Persona() {
//		edadJubilacion = 67;
//	}
	
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

	/**
	 * 
	 * @return
	 * @throws DemosException
	 */
	public LocalDate getFechaNacimiento() throws DemosException {
		if(fechaNacimiento == null)
			throw new DemosException("No tengo fecha de nacimiento");
		return fechaNacimiento;
	}
	public boolean hasFechaNacimiento() {
		return fechaNacimiento != null;
	}

	private int calculaEdad() {
		assert fechaNacimiento != null : "Se suponia que tenias la fecha de nacimiento";
		var hoy = LocalDate.now();
		return (int)fechaNacimiento.until(hoy, ChronoUnit.YEARS);
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null) {
			this.fechaNacimiento = null;
			edad = null;
			return;
		}
		var hoy = LocalDate.now();
		if(fechaNacimiento.isAfter(hoy))
			throw new IllegalArgumentException("Debe haber nacido ya");
		this.fechaNacimiento = fechaNacimiento;
		edad = calculaEdad();
		assert edad >= 0 : "Edad negativa";
	}
	public void setFechaNacimiento(String fecha) {
		setFechaNacimiento(LocalDate.parse(fecha));
	}
	
	public Optional<Integer> getEdad() {
		return hasFechaNacimiento() ? Optional.of(edad):Optional.empty();
	}

	protected void setEdad(int valor) {
		edad = valor;
	}

	public boolean isJubilado() {
		return edad >= edadJubilacion;
	}

	public void jubilate() {
		int i = nombre.length();
	}
	
	public abstract void darClase();
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", edadJubilacion=" + edadJubilacion + ", edad=" + edad + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return id == other.id;
	}
	
	
}
