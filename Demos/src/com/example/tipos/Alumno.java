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
	public double media() {
		int cont = 0;
		int rslt = 0;
		for(int nota: notas)
			if(nota >= 0) {
				cont++;
				rslt += nota;
			}
		if(cont == 0)
			return -1;
		else {
			return (double)rslt / cont;
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
