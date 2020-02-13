package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.Comparendo;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	private Pila<Comparendo> datosP;

	private Cola<Comparendo> datosC;

	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	//TODO: implementar los datos grandes
	//	public static String PATH = "../../../../Datos-Material/2020-10/Proyecto1/comparendos_dei_2018.geojson";


	public void cargarDatos() {

		datosP = new Pila<Comparendo>();
		datosC = new Cola<Comparendo>();

		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);
				datosP.push(c);
				datosC.enqueue(c);
			}

		}
		catch (FileNotFoundException | ParseException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Pila<Comparendo> darDatosP()
	{
		return datosP;
	}
	
	public Cola<Comparendo> darDatosC()
	{
		return datosC;
	}
	
	//OPCION 2, TODO
	public Cola<Comparendo> infraccionesConsecutivasMasGrande()
	{
		Cola<Comparendo> clusterMasGrande = new Cola<Comparendo>();
		
//		while(!datosC.estaVacia()){
//				
//			
//		}
		
		return clusterMasGrande;
	}
	
	//OPCION 3
	public Pila<Comparendo> ultimosNComparendosPorInfraccion(int N, String infraccion)
	{
		Pila<Comparendo> nComparendos = new Pila<Comparendo>();
		int contador = 0;
		
		while(!datosP.estaVacia() && contador < N)
		{
			Comparendo actual = datosP.pop();
			if(actual.getInfraccion().equalsIgnoreCase(infraccion)){
				contador++;
				nComparendos.push(actual);
			}
		}
		
		return nComparendos;
	}
}
