package com.example;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		var app = new Principal();
		app.ejer1();
//		app.ejer2();
	}
	
	public void ejer1() {
		Scanner teclado = new Scanner(System.in); 
		System.out.println("Hola mundo");
		System.out.print("Dame valor: ");
		String cad = teclado.nextLine();  
		System.out.println("Leido: " + cad);
		
	}
	
	public void ejer2() {
		
	}
}
