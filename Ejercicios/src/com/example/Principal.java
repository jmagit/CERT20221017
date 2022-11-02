package com.example;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

import com.example.juegos.Juego;
import com.example.juegos.JuegoException;

public class Principal {
	private static final Scanner teclado = new Scanner(System.in);
	private static final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

	public static void main(String[] args) {
		var app = new Principal();
//		app.ejer1();
//		app.juegoNumero();
		app.juegoConClase();
//		app.juegoPiedraPapelTijera();
//		app.decode("3+4+3,4-7*1=");
//		app.decode("0,1+0,2+0,7-0,9=");
//		try {
//			app.calcula("3+4+3,4-7*1=");
//			app.calcula("0,1+0,2+0,7-0,9=");
//		} catch (CalculadoraException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public void ejer1() {
		Scanner teclado = new Scanner(System.in);
		var rnd = new Random();
		int num = rnd.nextInt(10);
		System.out.println("Hola mundo");
		System.out.print("Dame valor: ");
		String cad = teclado.nextLine();
		System.out.println("Leido: " + Integer.parseInt(cad));
		System.out.println("Generado: " + rnd.nextInt(10));
		System.out.println("Generado: " + rnd.nextInt(10));
		System.out.println("Generado: " + rnd.nextInt(10));
		System.out.println("Generado: " + rnd.nextInt(10));

	}

	/**
	 * Juego de “Adivina el número que estoy pensando”, un número del 0 al 100, ya
	 * te diré si es mayor o menor que el mío, pero tienes 10 intentos como mucho.
	 */
	public void juegoNumero() {
		final int MAXIMO_INTENTOS = 10;
		final int numeroBuscado = (new Random()).nextInt(100) + 1;
		int numeroIntroducido;
		int intentos = 0;
		boolean encontrado = false;
		do {
			try {
				intentos += 1;
				out.print("Dame tu número del 1 al 100 (" + intentos + " de 10): ");
				out.print("[" + numeroBuscado + "]: ");
				numeroIntroducido = Integer.parseInt(teclado.nextLine());
				if (numeroBuscado == numeroIntroducido) {
					encontrado = true;
				} else if (numeroBuscado > numeroIntroducido) {
					out.println("Mi número es mayor.");
				} else {
					out.println("Mi número es menor.");
				}

			} catch (NumberFormatException e) {
				out.println("No es un número.");
			}
		} while (intentos < MAXIMO_INTENTOS && !encontrado);
		if (encontrado) {
			out.println("Bieeen!!! Acertaste.");
		} else {
			out.println("Upsss! Se acabaron los intentos, el número era el " + numeroBuscado + ".");
		}
	}

	public void juegoConClase() {
		try {
			Juego<String> juego = new com.example.juegos.numero.JuegoDelNumero();
			juego.inicializar();
//			((com.example.juegos.numero.JuegoDelNumero) juego).addNotificaListener(arg -> {
//				out.println("NOTIFICA: " + arg.getMsg());
//				out.println("¿Qieres cancelar?:");
//				arg.setCancel("s".equals(teclado.nextLine()));
//			});
			for (int intentos = 1; intentos <= 10; intentos++) {
				out.print("Dame tu número del 1 al 100 (" + (juego.getJugada() + 1) + " de 10): ");
				try {
					juego.jugada(teclado.nextLine());
                    out.println(juego.getResultado());
					if (juego.getFinalizado()) {
						break;
					}
				} catch (JuegoException e) {
					if (e.getCause() instanceof NumberFormatException) {
						out.println(e.getMessage());
					} else {
						throw e;
					}
				}
			}
		} catch (JuegoException e) {
			e.printStackTrace();
		}
	}

	public void juegoPiedraPapelTijera() {
		enum Opciones {
			PIEDRA, PAPEL, TIJERA
		}
		String[] jugador = new String[2];
		int i = 0;
		do {
			out.println("Jugador " + (i + 1) + ": ");
			out.println("\tA. Piedra");
			out.println("\tB. Papel");
			out.println("\tC. Tijera");
			out.print("Dame opción: ");
			String jugada = teclado.nextLine().toUpperCase();
			switch (jugada) {
			case "A":
				jugador[i++] = "Piedra";
				break;
			case "B":
				jugador[i++] = "Papel";
				break;
			case "C":
				jugador[i++] = "Tijera";
				break;
			default:
				out.println("Opción incorrecta");
				break;
			}
		} while (i < 2);
		if (jugador[0].equals(jugador[1])) {
			out.println("Empate");
		} else if ("Piedra".equals(jugador[0]) && "Tijera".equals(jugador[1])
				|| "Papel".equals(jugador[0]) && "Piedra".equals(jugador[1])
				|| "Tijera".equals(jugador[0]) && "Papel".equals(jugador[1])) {
			out.println("Gana jugador 1, " + jugador[0] + " gana a " + jugador[1]);
		} else {
			out.println("Gana jugador 2, " + jugador[1] + " gana a " + jugador[0]);
		}
	}

	public void juegoPiedraPapelTijeraConEnum() {
		enum Opciones {
			PIEDRA, PAPEL, TIJERA
		}
		Opciones[] jugador = new Opciones[2];
		int i = 0;
		do {
			out.println("Jugador " + (i + 1) + ": ");
			out.println("\tA. Piedra");
			out.println("\tB. Papel");
			out.println("\tC. Tijera");
			out.print("Dame opción: ");
			String jugada = teclado.nextLine().toUpperCase();
			switch (jugada) {
			case "A":
				jugador[i++] = Opciones.PIEDRA;
				break;
			case "B":
				jugador[i++] = Opciones.PAPEL;
				break;
			case "C":
				jugador[i++] = Opciones.TIJERA;
				break;
			default:
				out.println("Opción incorrecta");
				break;
			}
		} while (i < 2);
		if (jugador[0].equals(jugador[1])) {
			out.println("Empate");
		} else if ((jugador[0] == Opciones.PIEDRA && jugador[1] == Opciones.TIJERA)
				|| "Papel".equals(jugador[0]) && "Piedra".equals(jugador[1])
				|| "Tijera".equals(jugador[0]) && "Papel".equals(jugador[1])) {
			out.println("Gana jugador 1, " + jugador[0] + " gana a " + jugador[1]);
		} else {
			out.println("Gana jugador 2, " + jugador[1] + " gana a " + jugador[0]);
		}
	}

	public void decode(String expresion) {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0))) {
			throw new java.lang.IllegalArgumentException("No es una expresión valida");
		}
		String operando = "";
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
//                    operando += '.';
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				System.out.println(operando + " " + ch);
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Carácter no valido.");
			}
		}
	}

	public double calcula(String expresion) throws CalculadoraException, Exception {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0))) {
			throw new java.lang.IllegalArgumentException("No es una expresión valida");
		}
		String operando = "";
		Calculadora calculadora = new Calculadora();
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) {
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += ch;
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				calculadora.calcula(operando, ch);
				System.out.println(operando + "\t" + ch + "\t" + calculadora.getAcumulado());
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Carácter no valido.");
			}
		}
		System.out.println(calculadora.getAcumulado());
		return calculadora.getAcumulado();
	}

}
