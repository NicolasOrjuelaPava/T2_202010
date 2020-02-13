	package model.logic;

public class Pila<E> implements IPila{


	private Node<E> primero;
	
	private Node<E> ultimo;

	private int tamano;

	public Pila()
	{
		ultimo = null;
		primero = null;
		tamano = 0;
	}
	
	public E primeroNodo()
	{
		if(estaVacia())
			return null;
		return primero.darElemento();
	}
	
	public E ultimoNodo()
	{
		if(estaVacia())
			return null;
		return ultimo.darElemento();
	}

	public E pop()
	{	
		Node<E> toReturn = primero;
		primero = primero.darSiguiente();
		tamano--;
		if(estaVacia())
			ultimo = null;
		return toReturn.darElemento();
	}

	public void push(E entrada)
	{
		primero = new Node<>(entrada,primero);
		if(estaVacia())
			ultimo = primero;
		tamano++;
	}

	public int size()
	{
		return tamano;
	}

	public boolean estaVacia()
	{
		return tamano == 0;
	}

}
