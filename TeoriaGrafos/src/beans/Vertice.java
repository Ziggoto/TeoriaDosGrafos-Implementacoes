package beans;

import java.util.LinkedList;

public class Vertice{
	private LinkedList<Adjacente> adjacentes;
	
	private int id, status;
	private double distancia;
	
	public static final byte DESCONHECIDO = 0;
	public static final byte DESCOBERTO = 1;
	public static final byte CONHECIDO = 2;
	
	public Vertice(int id) {
		this.setId(id);
		this.setAdjacentes(new LinkedList<Adjacente>());
		this.setDistancia(Double.MAX_VALUE); //Equivalente ao "infinito"
	}
		
	@Override
	public String toString() {
		return String.valueOf(getId());
	}
	
	public void addAdjacente(Vertice v){
		addAdjacente(v, 0);
	}
	
	public void addAdjacente(Vertice v, double peso){
		this.getAdjacentes().add(new Adjacente(v, peso));
	}
	
	public void addAdjacente(Adjacente a){
		this.getAdjacentes().add(a);
	}
	
	public LinkedList<Adjacente> getAdjacentes() {
		return adjacentes;
	}

	public void setAdjacentes(LinkedList<Adjacente> adjacentes) {
		this.adjacentes = adjacentes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public Vertice getMenorAdjacente(){
		Vertice menor = adjacentes.get(0).getVertice();
		Vertice atual = null;
		
		for(int i=0,max=adjacentes.size();i<max;i++){
			atual = adjacentes.get(i).getVertice();
			if(atual.getDistancia() < menor.getDistancia()) menor = atual;
		}
		return menor;
	}
	
	public Vertice getVertice(int id){
		Vertice v = null;
		
		for(Adjacente a:this.adjacentes){
			if(a.getVertice().getId() == id){
				v = a.getVertice();
				break;
			}
		}
		
		return v;
	}

}