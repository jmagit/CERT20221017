package com.example;

import java.util.Random;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		var app = new Principal();
		app.ejer1();
//		app.ejer2();
	}
	
	public void ejer1() {
		Scanner teclado = new Scanner(System.in); 
		var rnd = new Random(); int num = rnd.nextInt(10);  
		System.out.println("Hola mundo");
		System.out.print("Dame valor: ");
		String cad = teclado.nextLine();  
		System.out.println("Leido: " + Integer.parseInt(cad));
		System.out.println("Generado: " + rnd.nextInt(10));
		System.out.println("Generado: " + rnd.nextInt(10));
		System.out.println("Generado: " + rnd.nextInt(10));
		System.out.println("Generado: " + rnd.nextInt(10));
		
	}
	
	public void ejer2() {
		
	}
}
