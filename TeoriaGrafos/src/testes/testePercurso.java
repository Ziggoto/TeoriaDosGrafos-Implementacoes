package testes;

import tad.GrafoMatrizAdjacencia;

public class testePercurso {
	public static void main(String[] args) {
		GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia(6);
		
		grafo.adicionarAresta(0, 1);
		grafo.adicionarAresta(0, 4);
//		grafo.adicionarAresta(1, 2);
		grafo.adicionarAresta(1, 5);
		grafo.adicionarAresta(2, 3);
		grafo.adicionarAresta(3, 4);
		grafo.adicionarAresta(4, 5);
		
//		grafo.imprimeMatriz();
		
		System.out.println(grafo.imprimeRota(0, 5));
	}
}
