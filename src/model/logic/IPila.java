package model.logic;

public interface IPila<E> {
	
	
	public E primeroNodo();
	
	public E ultimoNodo();
	
	public E pop();
	
	//TODO arreglar los paremetros
//	public void push(E entrada);
	
	public int size();
	
	public boolean estaVacia();

}
