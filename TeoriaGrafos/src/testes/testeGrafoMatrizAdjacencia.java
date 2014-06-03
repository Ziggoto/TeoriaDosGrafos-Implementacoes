package testes;

import tad.GrafoMatrizAdjacencia;

public class testeGrafoMatrizAdjacencia {
	public static void main(String[] args) {
		GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia(5);
		
		grafo.adicionarAresta(0, 1);
		grafo.adicionarAresta(1, 2);
		grafo.adicionarAresta(1, 4);
		grafo.adicionarAresta(0, 4);
		grafo.adicionarAresta(0, 3);
		grafo.adicionarAresta(3, 4);
		
		grafo.imprimeMatriz();
		
		System.out.println(grafo.isSimples() ? "É simples": "Não é simples");
	}
}
