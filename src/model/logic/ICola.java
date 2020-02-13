package model.logic;

public interface ICola<E> {

	//TODO arreglar los paremetros
//	public void enqueue(E nuevo);


	public E dequeue();
	

	public E primeroNodo();


	public E ultimoNodo();


	public int size();


	public boolean estaVacia();
}
