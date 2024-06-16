package qtx.test.interFunc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test11PerrosCollect {

	public static void main(String[] args) {
//		testCollect05_toList();
//		testCollect06_toTreeSet();
//		testCollect07_join();
//		testCollect08_sum();
		testCollect09_groupBy();
	}
	private static void testCollect05_toList() {
		System.out.println("===================================================================");
		System.out.println("  Ejemplo recoleccion 5: uso de Collectors para generar una lista"                          );
		System.out.println("===================================================================");
		
		List<Perro> perros = getListaPerros();
		List<String> nombres = perros.stream()
				                     .map(Perro::getNombre)
				                     .collect(Collectors.toList());
		System.out.println("Lista de nombres de los perros:");
		System.out.println(nombres);
	}

	private static void testCollect06_toTreeSet() {
		System.out.println("=====================================================================");
		System.out.println("Ejemplo recoleccion 6: uso de Collectors para generar un Set ordenado"                          );
		System.out.println("=====================================================================");
		
		List<Perro> perros = getListaPerros();
		Set<String> nombres = perros.stream()
				                     .map(Perro::getNombre)
				                     .collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Set de nombres de los perros (ordenados alfabeticamente):");
		System.out.println(nombres);
		
		nombres = perros.stream()
                .map(Perro::getNombre)
                .collect(Collectors.toCollection( 
                		()->new TreeSet<String>( (n,n2)->n.length() < n2.length() ? -1 : 1) )
                		                        );
		System.out.println("Set de nombres de los perros (ordenados por tama�o del nombre):");
		System.out.println(nombres);
	}

	private static void testCollect07_join() {
		System.out.println("=======================================================================");
		System.out.println("Ejm. recoleccion 7:Collectors para generar una concatenacion de Strings"                          );
		System.out.println("=======================================================================");
		
		List<Perro> perros = getListaPerros();
		String cadNombres = perros.stream()
				                     .map(Perro::getNombre)
				                     .collect(Collectors.joining(", "));
		System.out.println("Cadena de nombres separados por comas:");
		System.out.println(cadNombres);		
	}

	private static void testCollect08_sum() {
		System.out.println("=====================================================================");
		System.out.println("        Ejm. recoleccion 8:Collectors para sumas agregadas"           );
		System.out.println("=====================================================================");
		
		List<Perro> perros = getListaPerros();
		double pesoTotal = perros.stream()
				                 .collect(Collectors.summingDouble(Perro::getPeso));
		System.out.println("Peso acumulado de todos los perros:" + pesoTotal);

		pesoTotal = perros.stream()
				          .map(Perro::getPeso)
                          .collect(Collectors.summingDouble(peso->peso));
		System.out.println("Peso acumulado de todos los perros:" + pesoTotal);
	}
	
	private static void testCollect09_groupBy() {
		System.out.println("=====================================================================");
		System.out.println("      Ejm. recoleccion 9:Collectors para agrupaci�n de datos"         );
		System.out.println("=====================================================================");
		
		List<Perro> perros = getListaPerros();
		Map<String, List<Perro>> perrosXraza = 
				           perros.stream()
				                 .collect(Collectors.groupingBy(Perro::getRaza));
		System.out.println("Perros por raza:" );
		perrosXraza.entrySet()
		           .stream()
		           .map(x -> x.getKey() + ": " + x.getValue()
		                                         .stream()
		                                         .map(Perro::getNombre)
		                                         .collect(Collectors.joining(", ")) )
		           .forEachOrdered(System.out::println);
		
		Map<String, Double> razasYpesosProm = perros.stream()
		       .collect(Collectors.groupingBy(Perro::getRaza, 
				                              Collectors.averagingDouble(Perro::getPeso)));
		System.out.println("Pesos promedio por cada raza:");
		System.out.println(razasYpesosProm);
	}
		
	private static List<Perro> getListaPerros() {
		List<Perro> perros = new ArrayList<Perro>();
		
		perros.add(new Perro("Firulais","French Poodle", 4,12.5F ));
		perros.add(new Perro("Nubecita","French Poodle", 5,15.3F ));
		perros.add(new Perro("Bailaor","French Poodle", 2,13.0F ));
		
		perros.add(new Perro("Tyson","Boxer", 11, 28.3F ));
		perros.add(new Perro("Midas","Boxer", 10, 26.0F ));
		perros.add(new Perro("Campe�n","Boxer", 10, 25.5F ));
		
		perros.add(new Perro("Zapato","Pastor Ingl�s", 12, 50.7F ));
		perros.add(new Perro("Killer","Pastor Ingl�s", 6, 45.5F ));
		perros.add(new Perro("Morris","Pastor Ingl�s", 3, 48.2F ));
		
		perros.add(new Perro("Motita","D�lmata", 2, 38.1F ));
		perros.add(new Perro("Hans","Pastor Alem�n", 6, 41.5F ));
		perros.add(new Perro("Quesito","Chihuahua", 4, 1.3F ));
		return perros;
	}

}
