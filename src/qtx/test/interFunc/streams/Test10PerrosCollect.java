package qtx.test.interFunc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test10PerrosCollect {

	public static void main(String[] args) {
//		testCollect();
//		testCollect02();
//		testCollect03();
		testCollect04();
	}
	private static void testCollect() {
		System.out.println("===================================================================");
		System.out.println("                         Ejemplo recolección");
		System.out.println("===================================================================");
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.println(p.getNombre() + " (" + p.getRaza() + ")" ) );
		System.out.println();
		
		List<String> listaRazas= perros.stream()
				             .map(perris -> perris.getRaza())
				             .distinct()
				             .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println("Razas distintas: " + listaRazas);
		
	}
	private static void testCollect02() {
		System.out.println("===================================================================");
		System.out.println("         Ejemplo recolección 2: ¿Qué pasa en el interior?");
		System.out.println("===================================================================");
		
		List<Perro> perros = getListaPerros();
		List<String> listaRazas= perros.stream()
	             .map(perris -> perris.getRaza())
	             .distinct()
	             .collect(
	            		  () -> {
	            			  List<String> lista = new ArrayList<String>();
	            			  System.out.println("Constructor de ArrayList invocado " + lista);
	            			  return lista;
	            			  },
//	            		 ArrayList::new,
	            		 (lista,raza) -> {
	            			 lista.add(raza);
	            			 System.out.println("lista:"+lista);
	            		 },
//	            		 ArrayList::add, 
	            		 (lista1,lista2) -> { // Combinador:No es invocado
	            			                 lista1.addAll(lista2);
	            		                     System.out.println("lista1:"+lista1);
	            		                     System.out.println("lista2:"+lista2);
	            		                     });
		System.out.println("Razas distintas: " + listaRazas);
	}
	private static void testCollect03() {
		System.out.println("===================================================================");
		System.out.println("         Ejemplo recolección 3: ¿<se requiere el combinador?");
		System.out.println("===================================================================");
		
		List<Perro> perros = getListaPerros();
		List<String> listaRazas= perros.stream()
	             .map(perris -> perris.getRaza())
	             .distinct()
	             .collect(
	            		  () -> {
	            			  List<String> lista = new ArrayList<String>();
	            			  System.out.println("Constructor de ArrayList invocado " + lista);
	            			  return lista;
	            			  },
	            		 (lista,raza) -> {
	            			 lista.add(raza);
	            			 System.out.println("lista:"+lista);
	            		 },
	            		 (lista1,lista2) -> { //Se invoca en alto volúmen de datos ??
//	            			                 lista1.addAll(lista2);
	            		                     System.out.println("lista1:"+lista1);
	            		                     System.out.println("lista2:"+lista2);
	            		                     });
		System.out.println("Razas distintas: " + listaRazas);
	}

	private static void testCollect04() {
		System.out.println("===================================================================");
		System.out.println("         Ejemplo recolección 4: con Mapas"                          );
		System.out.println("===================================================================");
		
		List<Perro> perros = getListaPerros();
		Map<String,Set<String>> mapaPerrosXRaza;
		mapaPerrosXRaza = perros.stream()
				                .collect(TreeMap::new,
				                		(mapa,perris) -> {
				                			Set<String> perrosRaza = mapa.get(perris.getRaza());
				                			if(perrosRaza == null) {
				                				perrosRaza = new TreeSet<String>();
				                				mapa.put(perris.getRaza(), perrosRaza);
				                			}
				                			perrosRaza.add(perris.getNombre());
				                			System.out.println(mapa);
				                			System.out.println("-------------------------------");
				                		},
				                		(map1,map2)->map1.putAll(map2));
		
		System.out.println("==================== Mapa final =====================");
		mapaPerrosXRaza.entrySet()
		               .stream()
		               .forEachOrdered(
		            		  detMapa->System.out.println(detMapa.getKey() + ":" 
		                                                  + detMapa.getValue()) );
	}

	private static List<Perro> getListaPerros() {
		List<Perro> perros = new ArrayList<Perro>();
		
		perros.add(new Perro("Firulais","French Poodle", 4,12.5F ));
		perros.add(new Perro("Nubecita","French Poodle", 5,15.3F ));
		perros.add(new Perro("Bailaor","French Poodle", 2,13.0F ));
		
		perros.add(new Perro("Tyson","Boxer", 11, 28.3F ));
		perros.add(new Perro("Midas","Boxer", 10, 26.0F ));
		perros.add(new Perro("Campeón","Boxer", 10, 25.5F ));
		
		perros.add(new Perro("Zapato","Pastor Inglés", 12, 50.7F ));
		perros.add(new Perro("Killer","Pastor Inglés", 6, 45.5F ));
		perros.add(new Perro("Morris","Pastor Inglés", 3, 48.2F ));
		
		perros.add(new Perro("Motita","Dálmata", 2, 38.1F ));
		perros.add(new Perro("Hans","Pastor Alemán", 6, 41.5F ));
		perros.add(new Perro("Quesito","Chihuahua", 4, 1.3F ));
		return perros;
	}

}
