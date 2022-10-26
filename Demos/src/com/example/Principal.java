package com.example;

import java.util.Arrays;

import com.example.eunmeraciones.DiasDeLaSemana;
import com.example.eunmeraciones.DiasLaborales;
import com.example.tipos.Persona;

/**
 * Clase principal de las demos del curso
 * 
 * @author Javier
 * @since 17
 */
public class Principal {

	/**
	 * Método principal
	 * 
	 * @param args Argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		Principal app = new Principal();
		// System.out.println(app.suma(2, 2));
		app.clases();
	}

	public void clases() {
		Persona persona = new Persona(1, "    ", "Grillo");
		//persona.edadJubilacion = 1;
		var s = persona.getNombre();
		
	}
	public void enumeraciones() {
		byte d = 0;
		d = -1;
		DiasDeLaSemana dia = DiasDeLaSemana.LUNES;
		// dia = DiasLaborales.LUNES;
		if(dia == DiasDeLaSemana.DOMINGO) {}
		switch (dia) {
		case LUNES:
			
			break;

		default:
			break;
		}
	}
	public void flujo() {
		String s = "uno";
		int i = 3;
		switch (s) {
		case "uno", "tres":
			i += 1;
			break;
		case "dos":
			i += 2;
			break;
		default:
			i = 0;
			break;
		case "cuatro":
			i += 1;
			break;
			
		}
		
		switch (s) {
		default:
		case "tres":
			i += 1;
		case "dos":
			i += 1;
		case "uno":
			i += 1;
		}
		i += switch (s) { case "uno", "tres": yield 1; case "dos": yield 2; default: yield 0; };
		s = switch (s) { case "uno", "tres" -> 1; case "dos"-> 2; default -> 0; } + " ms";
		int[] tab = new int[15];
		i = 0;
		while (tab[i++] != 0 && i < tab.length);
		if(i == tab.length) {}
		while (i > 0) {
			
			// 
			i--;
		}
		for(int j = 0, k = 0; j < tab.length; j++, k++) {
			
		}
		i = 0;
		for(int ele: tab) {
			i += ele;
		}
		
		principal:
		while (true) {
			// ...
			if(i == 0) break;
			// ..
			//if(s != null && s.equals("")) break;
			if("".equals(s)) break;
			// ..
			while (true) {
				// ...
				if(i == 0) break principal;
				// ..
				//if(s != null && s.equals("")) break;
				if("".equals(s)) break;
				// ..
			}
		}
		
		etiqueto:
		while (i > 0) {
			switch (s) {
			case "uno", "tres":
				i += 1;
				break etiqueto;
			case "dos":
				i += 2;
				break;
			default:
				i = 0;
				break;
			case "cuatro":
				i += 1;
				break;
				
			}
			// ...
			if("".equals(s)) continue;
			// ...
			if("".equals(s)) {
				if("algo".equals(s)) {
					
				}
				
			} else {
				
			}
		}

	}

	public void operadores() {
		int i = 0, j, k = 0;
		i = j = k = 1;
		i = j + k;
		String s = "Hola", ss;
		ss = s + " mundo";
		ss = s + i;
		ss = i + j + s;
		i = 3;
		j = 0;
		double d = 3;
		System.out.println((d / j) * 0);
		System.out.println("Exacto: " + ((1 - 0.9 == 0.1) ? "Si" : "No"));
		i += 2;
		i = i + 2;
		boolean b = true, bb;
		s = null;
		if (s != null && s.equals(ss)) {
		}
		// if(s != null & s.equals(ss)) {}
		i = 1;
		j = ++i;
		Object c = new Principal();
		// ...
		if (c instanceof Principal) {
			Principal p = (Principal) c;
			// principal.
		}
		if (c instanceof Principal p) {
			p.suma(j, k);
		}

	}

	public void tablas() {
		int[] tab;
		int tab2[];
		tab = new int[15];
		System.out.println(tab[0]);
		System.out.println(tab[tab.length - 1]);
		var aux = new int[15];
		tab = aux;
		String t[] = new String[5];
		// t[0] = "hola";
		System.out.println(t[0] == null);
		int matriz[][] = new int[8][8];
		matriz[0][0] = 1;
		aux = matriz[0];
		matriz[0] = matriz[1];
		matriz[1] = aux;
		matriz[2] = new int[15];
		matriz[2] = null;

	}

	public void variables() {
		int i = 0, j, k = 0;
		i = j = k = 1;
		final int id;
		String s = "\t\tHola mundo\n" + "que tal";
		s = """
				Hola mundo
				que tal
				""";
		s.length();
		System.out.println(s);
		id = i * k;
		j = 1;
		k = i + j;
		var x = 0b1001_1100_0011;
		System.out.println(x);
		x = 4;
		i += x;
		long l;
		l = i;
		i = (int) l;
		i = 0;
		Object o = new Principal();
		o = "cadena";
		if (o instanceof Principal) {
			((Principal) o).suma(k, id);
		}
		i = Integer.parseInt("44");
		s = Integer.toString(i);

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
