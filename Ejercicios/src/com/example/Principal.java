package com.example;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.example.juegos.Color;
import com.example.juegos.Juego;
import com.example.juegos.JuegoException;
import com.example.juegos.Pieza;
import com.example.juegos.Tablero;
import com.example.juegos.ajedrez.Ajedrez;
import com.example.juegos.ajedrez.Alfil;
import com.example.juegos.ajedrez.Caballo;
import com.example.juegos.ajedrez.Dama;
import com.example.juegos.ajedrez.PromocionEventArgs;
import com.example.juegos.ajedrez.Torre;
import com.example.juegos.naipes.BarajaFrancesa;
import com.example.juegos.naipes.ValorNaipe;
import com.example.vending.Maquina;

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
////			app.calcula("3+4+3,4-7*10/3+33=");
////			app.calcula("0,1+0,2+0,7-0,9=");
//			app.calculaList("3+4+3,4-7*10/3+33=");
//			app.calculaList("0,1+0,2+0,7-0,9=");
//		} catch (CalculadoraException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		app.naipes();
//		app.ajedrez();
//		app.vending();
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
	 * Juego de ???Adivina el n??mero que estoy pensando???, un n??mero del 0 al 100, ya
	 * te dir?? si es mayor o menor que el m??o, pero tienes 10 intentos como mucho.
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
				out.print("Dame tu n??mero del 1 al 100 (" + intentos + " de 10): ");
				out.print("[" + numeroBuscado + "]: ");
				numeroIntroducido = Integer.parseInt(teclado.nextLine());
				if (numeroBuscado == numeroIntroducido) {
					encontrado = true;
				} else if (numeroBuscado > numeroIntroducido) {
					out.println("Mi n??mero es mayor.");
				} else {
					out.println("Mi n??mero es menor.");
				}

			} catch (NumberFormatException e) {
				out.println("No es un n??mero.");
			}
		} while (intentos < MAXIMO_INTENTOS && !encontrado);
		if (encontrado) {
			out.println("Bieeen!!! Acertaste.");
		} else {
			out.println("Upsss! Se acabaron los intentos, el n??mero era el " + numeroBuscado + ".");
		}
	}

	public void juegoConClase() {
		try {
			Juego<String> juego = new com.example.juegos.numero.JuegoDelNumero();
			juego.inicializar();
			((com.example.juegos.numero.JuegoDelNumero) juego).addNotificaListener(arg -> {
				out.println("NOTIFICA: " + arg.getMsg());
				out.println("??Qieres cancelar?:");
				arg.setCancel("s".equals(teclado.nextLine()));
			});
			for (int intentos = 1; intentos <= 10; intentos++) {
				out.print("Dame tu n??mero del 1 al 100 (" + (juego.getJugada() + 1) + " de 10): ");
				try {
					juego.jugada(teclado.nextLine());
//                    out.println(juego.getResultado());
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
			out.print("Dame opci??n: ");
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
				out.println("Opci??n incorrecta");
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
			out.print("Dame opci??n: ");
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
				out.println("Opci??n incorrecta");
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
			throw new java.lang.IllegalArgumentException("No es una expresi??n valida");
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
//				throw new Exception("Car??cter no valido.");
			}
		}
	}

	public double calcula(String expresion) throws CalculadoraException, Exception {
		if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0))) {
			throw new java.lang.IllegalArgumentException("No es una expresi??n valida");
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
//				throw new Exception("Car??cter no valido.");
			}
		}
		System.out.println(calculadora.getAcumulado());
		return calculadora.getAcumulado();
	}

    public List<Calculadora.Operacion> decodeToList(String expresion) {
        if (expresion == null || "".equals(expresion) || !Character.isDigit(expresion.charAt(0))) {
            throw new java.lang.IllegalArgumentException("No es una expresi??n valida");
        }
        List<Calculadora.Operacion> resulatado = new ArrayList<>();
        String operando = "";
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
                resulatado.add(new Calculadora.Operacion(operando, ch));
                if (ch == '=') {
                    break;
                }
                operando = "";
            } else if (ch != ' ') {
//				throw new Exception("Car??cter no valido.");
            }
        }
        return resulatado;

    }

    public void calculaList(String expresion) throws CalculadoraException, Exception {
        try {
            var operaciones = decodeToList(expresion);
            for (Calculadora.Operacion operacion : operaciones) {
                System.out.println(operacion.getOperando() + " " + operacion.getOperador());
            }
            System.out.println((new Calculadora()).calcula(operaciones));
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }

    private void naipes() {
        var b = new BarajaFrancesa();

        try {
            System.out.println("Baraja\n-------------------------------");
            for (var c : b.getCartas()) {
                System.out.println(c);
            }
            System.out.println("\nMazo\n-------------------------------");
            b.barajar();
            b.getMazo().forEach(System.out::println);
            b.reparte(4, 5).forEach(item -> {
                System.out.println("\nJugador\n-------------------------------");
                item.forEach(System.out::println);
            });
            System.out.println("\nQuedan " + b.getMazo().size());
            var mano = b.reparte(1, 2);
            System.out.println("\nQuedan " + b.getMazo().size());
            b.reparte(4, 5).forEach(item -> {
                System.out.println("\nJugador\n-------------------------------");
                item.forEach(System.out::println);
            });
            System.out.println("\nQuedan " + b.getMazo().size());
            mano.forEach(item -> {
                System.out.println("\nJugador\n-------------------------------");
                item.forEach(System.out::println);
            });
            System.out.println("\nQuedan " + b.getMazo().size());
            b.apilar(mano.get(0));
            b.getMazo().forEach(System.out::println);
            // b.apilar(mano.get(0));
            // b.apilar(List.of(new NaipeFrances(NaipeFrances.Palos.CORAZONES, (byte)1)));
            System.out.println("\nQuedan " + b.getMazo().size());
            System.out.println(ValorNaipe.REINA.valorNumerico);
            System.out.println(ValorNaipe.toEnum(12));
        } catch (JuegoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	public void ajedrez() {
		Juego<Tablero> juego = new Ajedrez(e -> pidePieza(e));
		juego.inicializar();
		do {
			try {
				pintaTablero(juego.getResultado());
				System.out.print("Juegan las " + (((Ajedrez) juego).getTurno() == Color.BLANCO ? "blancas" : "negras")
						+ ". Dame jugada [CFCF]: ");
				juego.jugada(teclado.nextLine().toUpperCase());
			} catch (JuegoException e) {
				System.out.println(e.getMessage());
			}
		} while (!juego.getFinalizado());
		System.out.println("Juego Finalizado");
	}

	private void pintaTablero(Tablero t) {
		for (int f = 8; f > 0; f--) {
			System.out.print(String.format("%2s ", f));
			for (int c = 1; c <= 8; c++) {
				if (t.hayPieza(f, c))
					System.out.print(String.format("%10s ", t.getPieza(f, c)));
				else
					System.out.print(Tablero.colorEscaque(f, c) == Color.BLANCO ? "            " : "-----------");
			}
			System.out.println();
		}
		for (char c = 'A'; c <= 'H'; c++) {
			System.out.print(String.format("%8c    ", c));
		}
		System.out.println();
	}
	
	private Pieza pidePieza(PromocionEventArgs e) {
		System.out.print("\t1: Dama\n\t2: Alfil\n\t3: Torre\n\t4: Caballo\n\t5: Cancelar\n"
				+ "Dame la opci??n para promocionar el pe??n " + (e.getColor() == Color.BLANCO ? "blanco: " : "negro:"));
		switch (Integer.parseInt(teclado.nextLine())) {
		case 1:
			return new Dama(e.getColor());
		case 2:
			return new Alfil(e.getColor());
		case 3:
			return new Torre(e.getColor());
		case 4:
			return new Caballo(e.getColor());
		case 5:
			e.setCancel(true);
		default:
			return null;
		}
	}

	private void vending() {
		var maquina = new Maquina();
		cotilla(maquina);
		maquina.vender("1", "1111", 1);
		maquina.vender("2", "2222", 2);
		maquina.vender("1", "1111", 3);
		maquina.vender("2", "2222", 3);
		cotilla(maquina);
		maquina.reiniciaCreditos();
		maquina.reponerTodo();
		cotilla(maquina);
	}

	private void cotilla(Maquina maquina) {
		System.out.println("Saldo");
		maquina.saldos().forEach(System.out::println);
		System.out.println("Stock");
		maquina.stock().forEach(System.out::println);
		System.out.println("Consumos");
		maquina.consumos().forEach(System.out::println);
	}

}
