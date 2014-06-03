package tad;

import java.util.LinkedList;
import java.util.List;

/**
 * Algoritimo de Grafos baseado em Matriz de Adjacencia
 * @author Fábio Theophilo
 */

public class GrafoMatrizAdjacencia {
	private int[][] matriz;
	private int tamanho, ordem;
	
	public GrafoMatrizAdjacencia(int numVertices) {
		matriz = new int[numVertices][numVertices];
		ordem = numVertices;
	}
	
	public void adicionarAresta(int v1, int v2){
		if(matriz[v1][v2] == 0) tamanho++;
		matriz[v1][v2] += 1;
		matriz[v2][v1] += 1;
	}
	
	public int getTamanho(){
		return tamanho;
	}
	
	public int getOrdem(){
		return ordem;
	}
	
	public double getDensidade(){
		return ((double) tamanho)/((double) ordem);
	}
	
	//Método para testes
	public void imprimeMatriz(){
		for(int i=0;i<ordem;i++){
			for(int j=0;j<ordem;j++){
				System.out.print(matriz[i][j]+((j == (ordem-1)? "":" ")));
			}
			System.out.println();
		}
	}
	
	public boolean isSimples(){
		for(int i=0;i<ordem;i++){
			for(int j=0;j<ordem;j++){
				if(matriz[i][j] > 1) return false;
			}
		}
		return true;
	}
	
	/**
	* Pecorre o grafo usando força bruta
	* @param v1 É o ponto de origem do caminho
	* @param v2 É o ponto de chegada do caminho
	* @return Lista com os pontos
	*/	
	public List<Integer> imprimeRota(int v1, int v2){
		List<Integer> percurso = new LinkedList<Integer>();
		int origem = v1, destino = v2;
		
		while(origem != destino){
			for(int i=origem, max = matriz.length; i < max;i++){
				if(matriz[origem][i] > 0 && !percurso.contains(i)){
					percurso.add(i);
					origem = i;
					break;
				}
			}
		}
		
		return percurso;
	}
	
	public int[][] getMatriz(){
		return matriz;
	}
	
	//TODO desafio...
	public static GrafoMatrizAdjacencia parseToAdjacencia(GrafoMatrizIncidencia incidencia){
		int[][] matrizIncidencia = incidencia.getMatriz();		
		GrafoMatrizAdjacencia grafoAdjacente = new GrafoMatrizAdjacencia(incidencia.getOrdem());
		
		for(int i=0, linhas = matrizIncidencia.length; i<linhas;i++){ //Linhas
			
		}
		
		
		return grafoAdjacente;
	}
}
