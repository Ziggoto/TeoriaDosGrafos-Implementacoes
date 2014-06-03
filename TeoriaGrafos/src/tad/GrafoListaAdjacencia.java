package tad;

import static beans.Vertice.CONHECIDO;
import static beans.Vertice.DESCOBERTO;
import static beans.Vertice.DESCONHECIDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import beans.Adjacente;
import beans.Vertice;

/**
 * Algoritimo de grafo baseado em lista de adjacências
 * @author Ziggoto (Fábio M. Theophilo)
 * @version 1.0 (Beta)
 */

public class GrafoListaAdjacencia {
	private LinkedList<Vertice> vertices;
	
	public GrafoListaAdjacencia() {
		vertices = new LinkedList<Vertice>();
	}

	/**
	 * Adiciona um novo vértice ao grafo
	 * @param c Vértice
	 */
	public void addVertice(Vertice c) {
		vertices.add(c);
	}
	
	/**
	 * Cria um arco indo da origem para o destino
	 * @param origem Id do vértice de origem
	 * @param destino Id do vértice de destino
	 */
	public void addArcoAdjacente(int origem, int destino){
		Vertice v1 = getVertice(origem), v2 = getVertice(destino);
		
		if(v1 != null && v2 != null){
			v1.addAdjacente(v2);
		}
	}
	
	/**
	 * Cria uma aresta entre o vértice de origem e o de destino
	 * @param origem Id do vértice de origem
	 * @param destino Id do vértice de destino
	 */
	public void addArestaAdjacente(int origem, int destino){
		this.addArcoAdjacente(origem, destino);
		this.addArcoAdjacente(destino, origem);
	}
	
	/**
	 * Cria um arco indo da origem para o destino com peso
	 * @param origem Id do vértice de origem
	 * @param destino Id do vértice de destino
	 * @param peso Informa o peso do arco
	 */	
	public void addArcoAdjacente(int origem, int destino, double peso){
		Vertice v1 = null, v2 = null;
		
		for(int i=0, max = vertices.size();i<max;i++){
			if(vertices.get(i).getId() == origem) v1 = vertices.get(i);
			if(vertices.get(i).getId() == destino) v2 = vertices.get(i);
		}
		
		if(v1 != null && v2 != null){
			v1.addAdjacente(v2, peso);
		}
	}
	
	/**
	 * Cria uma aresta entre o vértice de origem e o de destino com peso
	 * @param origem Id do vértice de origem
	 * @param destino Id do vértice de destino
	 * @param peso Informa o peso da aresta
	 */
	public void addArestaAdjacente(int origem, int destino, double peso){
		this.addArcoAdjacente(origem, destino, peso);
		this.addArcoAdjacente(destino, origem, peso);
	}
	
	public Vertice getVertice(int id){
		for(int i=0, max = vertices.size(); i < max;i++){
			if(vertices.get(i).getId() == id)
				return vertices.get(i);
		}
		
		return null;
	}
	
	public List<Vertice> getVertices(){
		return this.vertices;
	}
	
	public void imprimeGrafo(){
		for(Vertice v:vertices){
			System.out.println(v+" => "+v.getAdjacentes());
		}
	}

	public void buscaEmProfundidade(){
		Random escolhe = new Random();
		this.buscaEmProfundidade(escolhe.nextInt(vertices.size() - 1));
	}
	
	public void buscaEmProfundidade(int inicial){
		/* Usa pilha */
		Stack<Vertice> pilha = new Stack<Vertice>();
		Vertice aux = vertices.get(inicial);
		pilha.push(aux);
		Vertice v;
		aux = pilha.peek();
		
		do{
			System.out.print(aux+" => ");
			
			for(Adjacente a: aux.getAdjacentes()){
				v = a.getVertice();
				
				if(v.getStatus() < CONHECIDO){
					if(v.getStatus() == DESCONHECIDO){
						v.setStatus(DESCOBERTO);
					}
					pilha.push(v);
				}
				System.out.print(v+" ");
			}
			aux.setStatus(CONHECIDO);
			aux = pilha.pop();
			System.out.println("\t| Pilha: "+pilha);
			
		}while(pilha.size() > 0);
	}
	
	public void buscaEmLargura(){
		Random escolhe = new Random();
		this.buscaEmLargura(escolhe.nextInt(vertices.size() - 1));
	}
		
	public void buscaEmLargura(int inicial){
		/* Usa fila */
		List<Vertice> fila = new LinkedList<Vertice>();
		Vertice aux = vertices.get(inicial);
		fila.add(aux);
		Vertice v;
		
		do{
			aux = fila.get(0);
			System.out.print(aux+" => ");
			for(Adjacente a: aux.getAdjacentes()){
				v = a.getVertice();
				if(v.getStatus() < CONHECIDO){
					if(v.getStatus() == DESCONHECIDO){
						fila.add(v);
						v.setStatus(DESCOBERTO);
					}
				}
				System.out.print(v+" ");
			}
			aux.setStatus(CONHECIDO);
			fila.remove(aux);
			System.out.println("\t| Fila: "+fila);
		}while(fila.size() > 0);
	}
	

	
	/**
	 * Executa o algoritimo de Dijkstra de uma posição especifica
	 * @param inicio Id da posição inicial do algoritimo
	 */
	public void doDijkstra(int inicio){
		/* O objetivo em teoria é criar uma árvore de caminho mínimo. NÃO É para apenas dizer
		 * qual melhor camíno do vertice A ao B e sim dizer qual melhor caminho do vertice A a
		 * qualquer outro vértice do grafo. Para isso tem que setar as distâncias de cada vértice
		 * dando à cada um a menor distância possível.
		 * */
		
		Vertice aux = getVertice(inicio);
		
		Vertice menor, vizinho;
		aux.setDistancia(0);
		double menorDistancia, dist;
		
		List<Vertice> verticesPecorridos = new ArrayList<Vertice>();
		
		while(verticesPecorridos.size() < this.vertices.size()){
			menorDistancia = Double.MAX_VALUE;
			menor = null;
			
			for(Adjacente a: aux.getAdjacentes()){
				vizinho = a.getVertice();
				
				dist = a.getPeso() + aux.getDistancia(); //Calcula a distância do vértice atual
				if(vizinho.getDistancia() > dist) vizinho.setDistancia(dist); //Seta a distancia no vértice
				
				if(dist < menorDistancia && !verticesPecorridos.contains(vizinho)){
					menorDistancia = dist;
					menor = vizinho;
				}
			}
			verticesPecorridos.add(menor); // Avança para o menor
			aux = menor;
		}
		
		List<String> caminhoMinimo = new ArrayList<String>();
		for(Vertice caminho: verticesPecorridos){
			caminhoMinimo.add(caminho+": "+caminho.getDistancia());
		}
		System.out.println(caminhoMinimo);
	}
	
	/**
	 * Executa o algoritimo de Dijkstra de uma posição aleartória
	 */
	public void doDijkstra(){	
		Random escolhe = new Random();
		doDijkstra(escolhe.nextInt(vertices.size() - 1));
	}
}