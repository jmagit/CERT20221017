package com.example.tipos;

import java.time.LocalDate;
import java.util.Arrays;

public class Alumno extends Persona {
	private int[] notas = new int[10];
	
	public Alumno(int id, String nombre, String apellidos, LocalDate fechaNacimiento, int edadJubilacion) {
		super(id, nombre, apellidos, fechaNacimiento, edadJubilacion);
		Arrays.fill(notas, -1);
	}

	public void ponNota(int asignatura, int nota) {
		if(0<=asignatura && asignatura <= notas.length)
			notas[asignatura] = nota;
		else {
			throw new IllegalArgumentException("Asignatura fuera de rango");
		}
	}

	@Override
	public void darClase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pintate() {
		System.out.println("Soy el alumno");
	}
 }
