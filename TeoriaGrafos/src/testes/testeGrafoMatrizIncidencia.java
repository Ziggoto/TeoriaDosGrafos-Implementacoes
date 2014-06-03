package testes;

import tad.GrafoMatrizAdjacencia;
import tad.GrafoMatrizIncidencia;

public class testeGrafoMatrizIncidencia {
	public static void main(String[] args) {
		System.out.println("Grafo Incidente:");
		GrafoMatrizIncidencia grafo = new GrafoMatrizIncidencia(5, 8);
		
		grafo.adicionarAresta(0, 1);
		grafo.adicionarAresta(0, 2);
		grafo.adicionarAresta(0, 4);
		grafo.adicionarAresta(1, 2);
		grafo.adicionarAresta(1, 3);
		grafo.adicionarAresta(2, 3);
		grafo.adicionarAresta(2, 4);
		grafo.adicionarAresta(3, 4);
		
		grafo.imprimeMatriz();
		
		System.out.println();
		System.out.println("Grafo Adjacente");
		GrafoMatrizAdjacencia grafo2 = GrafoMatrizAdjacencia.parseToAdjacencia(grafo);
		grafo2.imprimeMatriz();
		
	}
}
