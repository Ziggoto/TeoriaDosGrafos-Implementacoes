package tad;

public class GrafoMatrizIncidencia {
	private int[][] matriz;
	private int tamanho;
	private int auxAresta;
	private int maxArestas;
	private int ordem;
	
	public GrafoMatrizIncidencia(int vertices, int arestas) {
		matriz = new int[vertices][arestas];
		this.maxArestas = arestas;
		this.ordem = vertices;
	}
	
	
	public void adicionarAresta(int v1, int v2){
		if(auxAresta < maxArestas){
			matriz[v1][auxAresta] += 1;
			matriz[v2][auxAresta] += 1;
			auxAresta++;
			tamanho++;
		}
	}
	
	/**
	 * @return O número de arestas
	 */
	
	public int getTamanho(){
		return tamanho;
	}
	
	
	/**
	 * @return O número de vértices
	 */
	public int getOrdem(){
		return ordem;
	}
	
	public double getDensidade(){
		return ((double) tamanho)/((double) ordem);
	}
	
	public void imprimeMatriz(){
		for(int i=0;i<ordem;i++){
			for(int j=0;j<maxArestas;j++){
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public int[][] getMatriz(){
		return matriz;
	}
}
