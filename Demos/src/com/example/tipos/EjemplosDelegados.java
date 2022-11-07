package com.example.tipos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EjemplosDelegados {
	
	void prueba() {
		List<String> lista = new ArrayList<>();
		class MiOrden implements Comparator<String> {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		}
		
		ordena(lista, new MiOrden());
		ordena(lista, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		ordena(lista, (o1, o2) -> o1.compareToIgnoreCase(o2));
		lista.forEach(p -> System.out.println(p));
		lista.forEach(System.out::println);
	}

	void ordena(List<String> lista, Comparator<String> comp) {
		String a = null, b = null;
		// ...
		if(comp.compare(a, b) == 0) {
			
		} else if(comp.compare(a, b) < 0) { // a < b
			
		} else { // a > b
			
		}
		// ...
	}
/*
	void ordena(List<String> lista, int tipo) {
		String a = null, b = null;
		// ...
		switch(tipo) {
		case 1:
			if(a == b) {
				
			} else if(a < b) {
				
			} else { // a > b
				
			}
			break;
		case 2:
			if(a == b) {
				
			} else if(a > b) {
				
			} else { // a < b
				
			}
			break;
		}
		// ...
	}

	void ordenaBin(List<String> lista) {
		String a = null, b = null;
		// ...
		if(a == b) {
			
		} else if(a < b) {
			
		} else { // a > b
			
		}
		// ...
	}
	void ordenaText(List<String> lista) {
		String a = null, b = null;
		// ...
		if(a == b) {
			
		} else if(a < b) {
			
		} else { // a > b
			
		}
		// ...
	}
*/
}
