package controller;

import java.util.Scanner;

import model.Comparendo;
import model.logic.Cola;
import model.logic.Modelo;
import model.logic.Pila;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	@SuppressWarnings("resource")
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			
			switch(option){
				case 1:
				    modelo = new Modelo();
					modelo.cargarDatos();
					
				    long start = System.currentTimeMillis();
				    Pila<Comparendo> listaP = modelo.darDatosP();
				    Cola<Comparendo> listaC = modelo.darDatosC();
				    
				    long end = System.currentTimeMillis();
				    
				    view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0);
				    view.printMessage("Datos cargados por pila: " + listaP.size());
				    view.printMessage("Datos cargados por Cola: " + listaC.size() + "\n");
					view.printMessage("Primer dato Pila: " + listaP.primeroNodo());
					view.printMessage("Primer dato Cola: " + listaC.primeroNodo() + "\n");
				    
				    
					break;
				case 2:
					
					break;
				case 3:
					
					view.printMessage("Ingrese el número de infracciones que desea buscar de la infracción");
					int n = lector.nextInt();
					
					view.printMessage("Ingrese la infraccion");
					String infraccion = lector.next();
					
					Pila<Comparendo> todos = modelo.ultimosNComparendosPorInfraccion(n, infraccion);
					
					view.printMessage("Numero de comparendos encontrados: "+todos.size() + "\n");
					
					while(!todos.estaVacia())
					{
						Comparendo actual = todos.pop();
						
						String mensaje = actual.getInfraccion() + ", " + actual.getObjectId() + ", " +
								actual.getFecha_hora() + ", " + actual.getClase_vehi() + ", " +
								actual.getTipo_servi() + ", " + actual.getLocalidad();
						
						view.printMessage( mensaje + "\n");
					}
					break;

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
