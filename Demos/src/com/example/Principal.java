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
	 * 
	 * @param args Argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		Principal app = new Principal();
		// System.out.println(app.suma(2, 2));
		app.variables();
	}

	public void variables() {
		int i = 0, j, k = 0;
		final int id;
		String s = "\t\tHola mundo\n" + "que tal";
		s = """
				Hola mundo
				que tal
				""";
		s.length();
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
