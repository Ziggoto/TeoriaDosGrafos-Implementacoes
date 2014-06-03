package tad;

import java.util.LinkedList;
import java.util.List;

import beans.Aresta;
import beans.Vertice;

public class GrafoListaIncidencia {
	private List<Aresta> arestas;

	public GrafoListaIncidencia() {
		arestas = new LinkedList<Aresta>();
	}
	
	public void addAresta(Aresta a){
		arestas.add(a);
	}
	
	public Aresta getAresta(int indice){
		return arestas.get(indice);
	}

	public void imprimeGrafo(){
		for(Aresta a: arestas){
			System.out.println(a);
		}
	}
	
	public static GrafoListaIncidencia parseToListaIncidencia(GrafoMatrizIncidencia outroGrafo){
		int[][] matriz = outroGrafo.getMatriz();
		GrafoListaIncidencia novoGrafo = new GrafoListaIncidencia();

		List<Vertice> listaVertices = new LinkedList<Vertice>();

		for(int i=0, max = matriz.length; i<max ;i++){
			//Adiciona os vertices
			listaVertices.add(new Vertice(i));

			for (int j = 0, max2 = matriz[0].length; j<max2; j++) {
				//Primeiro adiciona as arestas
				novoGrafo.addAresta(new Aresta(j));

				if(matriz[i][j] == 2){
					novoGrafo.getAresta(j).addAnterior(listaVertices.get(i));
					novoGrafo.getAresta(j).addProximo(listaVertices.get(i));
				}else{
					if(matriz[i][j] == 1){
						if(novoGrafo.getAresta(j).existeProximo()){ 
							novoGrafo.getAresta(j).addAnterior(listaVertices.get(i));
						}
						else{
							novoGrafo.getAresta(j).addProximo(listaVertices.get(i));
						}
					}
				}
			}
		}

		return novoGrafo;
	}
}
