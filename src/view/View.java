package view;

import model.logic.Modelo;

public class View 
{
	    
		public void printMenu()
		{
			System.out.println("1. Cargar Datos");
			System.out.println("2. Consultar el grupo de comparendos consecutivos m�s grande por c�digo de infracci�n");
			System.out.println("3. Reporte de los �ltimos comparendos con una infracci�n dada");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		

}
