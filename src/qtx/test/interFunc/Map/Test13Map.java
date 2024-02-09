package qtx.test.interFunc.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test13Map {

	public static void main(String[] args) {
	//	test01_forEach();
	//	test02_valoresDefecto();
		test03_collect();
	}
	
	private static void test03_collect() {
		Map<String, Perro> mapaPerros = getMapaPerros();
		Map<Integer, List<Perro>> mapaPerrosXedad = 
									mapaPerros.values()
				                              .stream()
//				                              .collect(Collectors.groupingBy(Perro::getEdad));
        									  .collect(Collectors.groupingBy(perroI->perroI.getEdad()));
		
		System.out.println("Perros agrupados por edad:");
		mapaPerrosXedad.entrySet()
		               .stream()
		               .forEach(
		            	  item->
		            	     System.out.printf("%4d : %s\n", item.getKey(), item.getValue()
		            	    		                                           .stream()
		            	    		                                           .map(Perro::getNombre)
		            	    		                                           .collect(Collectors.joining(", "))
		            	    		           )
		            	     );
	}
	
	private static void test02_valoresDefecto() {
		Map<String, Perro> mapaPerros = getMapaPerros();
		String nombres[] = {"Midas","Rififi", "Motita", "Frijolito", "Harry"};
		Perro perroDefault = new Perro("Solovino","Criollo",5,30);
		
		for(String nombreI: nombres) {
			Perro perro = mapaPerros.getOrDefault(nombreI, perroDefault);
			System.out.println(perro);
		}
		
	}
	
	public static void test01_forEach() {
		Map<String, Perro> mapaPerros = getMapaPerros();
		mapaPerros.forEach((key,valor) -> System.out.printf("llave= %-12s, valor= %s\n", key, valor));
		
		String razas = mapaPerros.values()
				                 .stream()
				                 .map(Perro::getRaza)
				                 .distinct()
				                 .sorted()
				                 .collect(Collectors.joining(", "));
		System.out.println("razas: " + razas);
	}
	
	private static List<Perro> getListaPerros() {
		List<Perro> perros = new ArrayList<Perro>();
		
		perros.add(new Perro("Firulais","French Poodle", 4,12.5F ));
		perros.add(new Perro("Nubecita","French Poodle", 5,15.3F ));
		perros.add(new Perro("Bailaor","French Poodle", 2,13.0F ));
		
		perros.add(new Perro("Tyson","Boxer", 11, 28.3F ));
		perros.add(new Perro("Midas","Boxer", 10, 26.0F ));
		perros.add(new Perro("Campeon","Boxer", 10, 25.5F ));
		
		perros.add(new Perro("Zapato","Pastor Ingles", 12, 50.7F ));
		perros.add(new Perro("Killer","Pastor Ingles", 6, 45.5F ));
		perros.add(new Perro("Morris","Pastor Ingles", 3, 48.2F ));
		
		perros.add(new Perro("Motita","Dalmata", 2, 38.1F ));
		perros.add(new Perro("Hans","Pastor Aleman", 6, 41.5F ));
		perros.add(new Perro("Quesito","Chihuahua", 4, 1.3F ));
		return perros;
	}
	
	private static Map<String,Perro> getMapaPerros() {
		List<Perro> listaPerros = getListaPerros();
		return listaPerros.stream()
				          .collect( Collectors.toMap(Perro::getNombre, perris->perris) );
	}

}
