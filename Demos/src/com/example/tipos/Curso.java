package com.example.tipos;

public class Curso {
	private Profesor profesor;
	
	public Curso(Profesor profesor) {
		super();
		this.profesor = profesor;
		this.profesor.setSalario(1500);
	}

	public Profesor getProfe() {
		return profesor.clone();
	}
}
