package test.logic;

import static org.junit.Assert.*;

import model.Comparendo;
import model.logic.Modelo;
import model.logic.Pila;

import org.junit.Test;

public class TestModelo {
	
	//TODO: Implementar Test

	private Modelo modelo;
	
	private static int CAPACIDAD=100;

	
	public void setUp1() 
	{
	}
	
	@Test
	public void testNull() 
	{
		modelo.cargarDatos();
		Pila<Comparendo> pila = modelo.darDatosP();
		assertTrue("La pila debería ser null",pila == null);
	}



}
