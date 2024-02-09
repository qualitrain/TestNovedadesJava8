package qtx.test.interFunc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test05PerrosAnyMatch {

	public static void main(String[] args) {
		testStream_Match();
	}
	private static void testStream_Match() {
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getRaza() + "), " ) );
		System.out.println();
	
		if(hayPastoresEn(perros))
			System.out.println("En la lista de perros hay algunos pastores (de varios tipos)");
		else
			System.out.println("En la lista de perros NO hay pastores");
		
		if(hayPastoresOboxersEn(perros))
			System.out.println("En la lista de perros hay algunos pastores (de varios tipos) o boxers");
		else
			System.out.println("En la lista de perros NO hay pastores NI boxers");

		if(hayPerrosDeRaza("French Poodle", perros))
			System.out.println("En la lista de perros hay algunos "
					+ "French poodle");
		else
			System.out.println("En la lista de perros NO hay "
					+ "French poodle");
		
		if(hayPerrosDeRaza("San Bernardo", perros))
			System.out.println("En la lista de perros hay algunos "
					+ "San Bernardo");
		else
			System.out.println("En la lista de perros NO hay "
					+ "San Bernardo(s)");
		
	}
	
	private static boolean hayPastoresEn(List<Perro> perros) {
		Predicate<Perro> hayPastores = perris -> perris.getRaza()
				                                       .trim()
				                                       .toLowerCase()
				                                       .startsWith("pastor");
		return perros.stream()
				     .anyMatch(hayPastores);
	}
	private static boolean hayPastoresOboxersEn(List<Perro> perros) {
		Predicate<Perro> hayPastores = perris -> perris.getRaza()
				                                       .trim()
				                                       .toLowerCase()
				                                       .startsWith("pastor");
		Predicate<Perro> hayBoxers = perris -> perris.getRaza()
                									 .trim()
                									 .toLowerCase()
                									 .startsWith("boxer"); 
		return perros.stream()
				     .anyMatch(hayPastores.or(hayBoxers));
	}
	private static boolean hayPerrosDeRaza(String raza, List<Perro> perros) {
		Predicate<Perro> hayPerrosDeRazaBuscada = getCondicionBusquedaXRaza(raza);
		return perros.stream()
			          .anyMatch(hayPerrosDeRazaBuscada);
	}
	private static Predicate<Perro> getCondicionBusquedaXRaza(String raza) {
		Predicate<Perro> condicionBusquedaXraza = perris -> perris.getRaza()
                                                                  .trim()
                                                                  .toLowerCase()
                                                                  .startsWith(raza.trim()
                                                                		          .toLowerCase());
		return condicionBusquedaXraza;
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
