package com.example.tipos;

import java.time.LocalDate;

@Autor(nombre = "Yo mismo")
public class Profesor extends Persona {
	private double salario;

	public Profesor(int id, String nombre, String apellidos) {
		super(id, nombre, apellidos);
		this.salario = 0;
	}

	public Profesor(int id, String nombre, String apellidos, double salario, LocalDate fechaNacimiento) {
		super(id, nombre, apellidos, fechaNacimiento, 67);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void actualizaSalario(double delta) {
		salario = salario * delta;
	}

	@Override
	public void jubilate() {		
		super.jubilate();
		setEdad(MAYORIA_EDAD);
		// Dar fiesta
	}
	
	@Override
	public void darClase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Profesor [id=" + getId() + ", nombre=" + getNombre() + ", apellidos=" + getApellidos()
				+ ", salario=" + salario + ", edad="+ (getEdad().isEmpty() ? "" : getEdad().get()) +"]";
	}
	
	@Override
	public Profesor clone() {
		try {
			return (Profesor)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		return new Profesor(getId(), getNombre(), getApellidos(), salario, getFechaNacimiento());
	}

	@Override
	public void pintate() {
		System.out.println("Soy el profesor");
	}
	
}
