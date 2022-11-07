package com.example.tipos;

public class Curso implements Grafico, AutoCloseable {
	@Autor
	private Profesor profesor;
	
	public Curso(Profesor profesor) {
		super();
		this.profesor = profesor;
		this.profesor.setSalario(1500);
	}

	public Profesor getProfe() {
		return profesor.clone();
	}

	@Override
	public void pintate() {
		System.out.println("Soy el curso");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Se ha cerrado el curso");
	}
}
