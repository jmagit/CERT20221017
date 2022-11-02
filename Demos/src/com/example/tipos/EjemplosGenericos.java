package com.example.tipos;

public class EjemplosGenericos {
	public static class Lista<T extends Persona> {
		public T add(T item) {
			return item;
		}
	}
 	public static class Elemento<T> {
		private T key;
		private String value;
		public Elemento(T key, String value) {
			this.key = key;
			this.value = value;
		}
		public T getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
	}

// 	public static class Elemento {
//		private Object key;
//		private String value;
//		public Elemento(Object key, String value) {
//			this.key = key;
//			this.value = value;
//		}
//		public Object getKey() {
//			return key;
//		}
//		public String getValue() {
//			return value;
//		}
//	}

 	public static record Coordenadas(int x, int y) {};

 	public static record ElementInt(int key, String value) {};
 	
	public static class ElementoInt {
		private int key;
		private String value;
		public ElementoInt(int key, String value) {
			this.key = key;
			this.value = value;
		}
		public int getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
	}
	public static class ElementoChar {
		private char key;
		private String value;
		public ElementoChar(char key, String value) {
			this.key = key;
			this.value = value;
		}
		public char getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
	}
}
