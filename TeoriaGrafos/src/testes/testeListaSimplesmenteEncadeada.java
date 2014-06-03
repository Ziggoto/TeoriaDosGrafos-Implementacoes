package testes;

import tad.ListaSimplesmenteEncadeada;

public class testeListaSimplesmenteEncadeada {
	public static void main(String[] args) {
		ListaSimplesmenteEncadeada lista = new ListaSimplesmenteEncadeada();
		lista.add("oi");
		lista.add("eee");
		lista.add("abc");
		lista.add(new Integer(5));
		
		lista.imprimeLista();
		System.out.println("Tamanho: "+lista.getTamanho());
		
		lista.rmv("eee");
		lista.imprimeLista();
		System.out.println("Tamanho: "+lista.getTamanho());
	}
}
