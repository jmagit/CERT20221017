package com.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;

import com.example.eunmeraciones.DiasDeLaSemana;
import com.example.eunmeraciones.DiasLaborales;
import com.example.excepciones.DemosException;
import com.example.excepciones.InvalidDataException;
import com.example.tipos.Alumno;
import com.example.tipos.Autor;
import com.example.tipos.Curso;
import com.example.tipos.EjemplosGenericos.ElementInt;
import com.example.tipos.EjemplosGenericos.Elemento;
import com.example.tipos.EjemplosGenericos.ElementoInt;
import com.example.tipos.EjemplosGenericos.Lista;
import com.example.tipos.Grafico;
import com.example.tipos.Persona;
import com.example.tipos.PersonasRepository;
import com.example.tipos.PersonasRepositoryMock;
import com.example.tipos.Profesor;

/**
 * Clase principal de las demos del curso
 * 
 * @author Javier
 * @since 17
 */
public class Principal {
	private int privado = 0;

	/**
	 * Método principal
	 * 
	 * @param args Argumentos de la linea de comandos
	 */
	public static void main(String[] args) {
		Principal app = new Principal();
		// System.out.println(app.suma(2, 2));
		try {
			// app.consultas(new PersonasRepositoryMock());
			app.anotaciones();
		} catch (Exception e) {
			System.err.println("En principal");
			e.printStackTrace();
		}
	}

	public void consultas(PersonasRepository dao) {
		var lst = dao.getAll();
		lst.forEach(System.out::println);
	}

	public void anotaciones() {
		try {
			var nombre = "cotilla";
			Class clase = Class.forName("com.example.Principal"); // Principal.class;
//		clase = app.getClass();

//		for (var metodo : clase.getMethods()) {
//			System.out.println(metodo.getName());
//		}
			Object app = clase.newInstance();
			var m = clase.getMethod(nombre, null);
			m.invoke(app, null);
			var fld = clase.getDeclaredField("privado");
			fld.setAccessible(true);
			fld.set(app, 99);
			m.invoke(app, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Profesor.class.getAnnotation(Autor.class).nombre());
		System.out.println(Grafico.class.getAnnotation(Autor.class).nombre());

	}

	public void cotilla() {
		System.out.println("Valor privado:" + privado);
	}

	private void errores() throws Exception {
		Persona persona = new Profesor(1, "Pepito", "Grillo");
		// persona = new Profesor(1, "Pepito", "Grillo", 2000, LocalDate.of(2000, 1,
		// 1));
		try (Curso curso = new Curso(new Profesor(1, "Pepito", "Grillo"))) {
			try {
				persona.getFechaNacimiento();
			} catch (InvalidDataException e) {
				System.err.println("Interior");
				e.printStackTrace();
			}
			if (persona.hasFechaNacimiento())
				System.out.println(persona.getFechaNacimiento());
			else
				System.out.println("sin edad");
			var edad = persona.getEdad();
			if (edad.isPresent()) {
				System.out.println(edad.get());
			}
			System.out.println(persona.getEdad().orElse(-9999));
			System.out.println(divide(1.0, 0));
		} catch (DemosException e) {
			System.err.println("En errores");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("En errores: Exception");
			e.printStackTrace();
			throw e;
		} finally {
			System.err.println("Bloque finally");
		}
	}

	public void genericos() {
		ElementoInt ele1 = new ElementoInt(28, "Madrid");
//		Elemento prov = new Elemento(28, "Madrid");
//		prov = new Elemento("8", "Barcelona");
		Elemento<Integer> prov = new Elemento<Integer>(28, "Madrid");
		prov = new Elemento<Integer>(8, "Barcelona");
		// var s = prov.get
		Lista<Alumno> alumnos = new Lista<>();
		alumnos.add(new Alumno(1, "Alum", "Grillo", LocalDate.of(2000, 1, 1), 80));
		// alumnos.add(new Profesor(1, "Pepito", "Grillo", 2000, LocalDate.of(2000, 1,
		// 1)));
		ElementInt reg = new ElementInt(28, "Madrid");
	}

	public void clases() {
		Object o = null;
		Persona persona = new Profesor(1, "Pepito", "Grillo", 2000, LocalDate.of(2000, 1, 1));
		var profe = new Profesor(1, "Pepito", "Grillo", 2000, LocalDate.of(2000, 1, 1));
		System.out.println(profe.equals(persona) ? "Iguales" : "distintos");
		// persona.edadJubilacion = 1;
		var s = persona.getNombre();
		persona.setFechaNacimiento("2000-01-01");
		persona.setFechaNacimiento(LocalDate.of(2000, 1, 1));
		System.out.println(persona);
		((Profesor) profe).actualizaSalario(1.10);
		System.out.println(profe);
		var alum = new Alumno(1, "Alum", "Grillo", LocalDate.of(2000, 1, 1), 80);
		System.out.println(profe.equals(alum) ? "Iguales" : "distintos");
		alum.ponNota(0, 0);
		System.out.println(alum);
		var curso = new Curso(profe);
		System.out.println(curso.getProfe());
		var p = curso.getProfe();
		p.setSalario(3000);
//		System.out.println(p);
//		System.out.println(curso.getProfe());
		Grafico g = new Alumno(1, "Alum", "Grillo", LocalDate.of(2000, 1, 1), 80);
		g.pintate();
		g = new Curso(profe);
		g.pintate();
		o = new Principal();
		if (o instanceof Grafico gg) {
			gg.pintate();
		}

		o = 4; // new Integer(4);
		int i = (int) o; // ((Integer)o).getValue();
		i = 0;
		Integer ii = null;
		ii = 0;
		i = ii + 1;
	}

	public void enumeraciones() {
		byte d = 0;
		d = -1;
		DiasDeLaSemana dia = DiasDeLaSemana.LUNES;
		// dia = DiasLaborales.LUNES;
		if (dia == DiasDeLaSemana.DOMINGO) {
		}
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
		i += switch (s) {
		case "uno", "tres":
			yield 1;
		case "dos":
			yield 2;
		default:
			yield 0;
		};
		s = switch (s) {
		case "uno", "tres" -> 1;
		case "dos" -> 2;
		default -> 0;
		} + " ms";
		int[] tab = new int[15];
		i = 0;
		while (tab[i++] != 0 && i < tab.length)
			;
		if (i == tab.length) {
		}
		while (i > 0) {

			//
			i--;
		}
		for (int j = 0, k = 0; j < tab.length; j++, k++) {

		}
		i = 0;
		for (int ele : tab) {
			i += ele;
		}

		principal: while (true) {
			// ...
			if (i == 0)
				break;
			// ..
			// if(s != null && s.equals("")) break;
			if ("".equals(s))
				break;
			// ..
			while (true) {
				// ...
				if (i == 0)
					break principal;
				// ..
				// if(s != null && s.equals("")) break;
				if ("".equals(s))
					break;
				// ..
			}
		}

		etiqueto: while (i > 0) {
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
			if ("".equals(s))
				continue;
			// ...
			if ("".equals(s)) {
				if ("algo".equals(s)) {

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

	public int divide(int a, int b) throws DemosException {
		try {
			return a / b;
		} catch (ArithmeticException ex) {
			throw new DemosException("Error de calculo", ex);
		}
	}

	public double divide(double a, double b) {
		if (b == 0)
			throw new ArithmeticException();
		return a / b;
	}

}
