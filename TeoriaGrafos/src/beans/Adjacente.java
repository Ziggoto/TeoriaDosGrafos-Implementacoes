package beans;

public class Adjacente{
	private Vertice vertice;
	private double peso;

	public Adjacente(Vertice v) {
		this(v, 0);
	}
	
	public Adjacente(Vertice v, double peso) {
		setVertice(v);
		setPeso(peso);
	}

	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "("+vertice.toString()+", "+(int) peso+")";
	}
}