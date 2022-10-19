package com.example;

/**
 * Clase principal de las demos del curso
 * 
 * @author Javier
 * @since 17
 */
public class Principal {

	/**
	 * Método principal
	 * @param args Argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		Principal app = new Principal();
		System.out.println(app.suma(2, 2));
	}

	/**
	 * Suma dos enteros
	 * 
	 * @param a operando 1
	 * @param b operando 2
	 * @return la suma
	 */
	public int suma(int a, int b) {
		return a + b;
	}

}
