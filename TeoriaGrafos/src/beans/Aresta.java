package beans;
public class Aresta{
		private Vertice proximo, anterior;
		private int id;
		private double peso;
		
		public Aresta(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}
		
		public void addProximo(Vertice proximo){
			this.proximo = proximo;
		}
		
		public void addAnterior(Vertice anterior){
			this.anterior = anterior;
		}
		
		public boolean existeProximo(){
			return (proximo == null)? false:true;
		}
		
		@Override
		public String toString() {
			return id+" => "+ anterior+", "+proximo;
		}
	}