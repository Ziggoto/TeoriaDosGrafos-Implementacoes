package tad;

import java.util.Iterator;

/**
 * @author Fábio Theophilo
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class ListaSimplesmenteEncadeada<T> implements Iterable<T> {
	private Node<T> inicio;
	private int tamanho;
	
	public ListaSimplesmenteEncadeada() {
		tamanho = 0;
	}
	
	public void add(Node<T> escolhido){
		if(inicio == null) inicio = escolhido;
		else{
			Node aux = this.inicio;
			while(aux.hasProximo()){
				aux = aux.getProximo();
			}
			aux.setProximo(escolhido);
		}
		tamanho++;
	}
	public void add(T conteudo){
		Node<T> escolhido = new Node<T>(conteudo);
		this.add(escolhido);
	}
	
	public void rmv(Node escolhido){
		Node aux = this.inicio;
		while(aux.hasProximo()){
			if(aux.getProximo().equals(escolhido)){
				Node novoProximo = aux.getProximo().getProximo();
				aux.setProximo(novoProximo);
				tamanho--;
				return;
			}
			aux = aux.getProximo();
		}
	}
	public void rmv(Object conteudo){
		Node aux = this.inicio;
		while(aux.hasProximo()){
			if(aux.getProximo().getConteudo().equals(conteudo)){
				Node novoProximo = aux.getProximo().getProximo();
				aux.setProximo(novoProximo);
				tamanho--;
				return;
			}
			aux = aux.getProximo();
		}
	}
	
	public Node<T> get(int indice){ 
		Node<T> aux = this.inicio;
		for(int i=0;i<=indice;i++) aux = aux.getProximo();
		return aux;
		}
	
	public void imprimeLista(){
		Node aux = this.inicio;
		while(aux.hasProximo()){
			System.out.print(aux.getConteudo()+(!isUltima(aux)? " => ":""));
			aux = aux.getProximo();
		}
		System.out.println(aux.getConteudo());
	}
	
	public int getTamanho(){
		return this.tamanho;
	}
	
	//Métodos privados
	private boolean isUltima(Node escolhido){
		return escolhido.getProximo() == null? true:false;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}
}

class Node<T>{
	private Node<T> proximo;
	private T conteudo;
	
	public Node(T conteudo) {
		this.conteudo = conteudo;
	}
	
	public Node<T> getProximo() {
		return proximo;
	}
	public void setProximo(Node<T> proximo) {
		this.proximo = proximo;
	}
	public T getConteudo() {
		return conteudo;
	}
	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}
	
	public boolean hasProximo(){
		return (this.proximo == null)? false:true;
	}
}