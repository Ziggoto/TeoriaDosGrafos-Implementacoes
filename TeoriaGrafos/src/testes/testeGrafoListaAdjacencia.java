package testes;

import java.util.ArrayList;
import java.util.List;

import tad.GrafoListaAdjacencia;
import beans.Adjacente;
import beans.Vertice;

public class testeGrafoListaAdjacencia {
	public static void main(String[] args) {
		GrafoListaAdjacencia grafo = new GrafoListaAdjacencia();

		for(int i=1;i<=6;i++)
			grafo.addVertice(new Vertice(i));
	
		grafo.addArestaAdjacente(1, 2, 7);
		grafo.addArestaAdjacente(1, 3, 9);
		grafo.addArestaAdjacente(1, 6, 14);
		grafo.addArestaAdjacente(2, 3, 10);
		grafo.addArestaAdjacente(2, 4, 15);
		grafo.addArestaAdjacente(3, 4, 11);
		grafo.addArestaAdjacente(3, 6, 2);
		grafo.addArestaAdjacente(4, 5, 6);
		grafo.addArestaAdjacente(6, 5, 9);
		
		System.out.println("Grafo:");
		grafo.imprimeGrafo();
		
//		System.out.println();
//		grafo.buscaEmLargura(1);

		System.out.println();
		grafo.doDijkstra(1);

	}
}
