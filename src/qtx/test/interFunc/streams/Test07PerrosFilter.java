package qtx.test.interFunc.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test07PerrosFilter {

	public static void main(String[] args) {
		testStream_Filter();
	}
	private static void testStream_Filter() {
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getRaza() + "), " ) );
		System.out.println();
	
		System.out.println("\nPerros pastores:");
		Predicate<Perro> esPastor = perris -> perris.getRaza()
                   			                         .trim()
                   			                         .toLowerCase()
                  			                         .startsWith("pastor");
		perros.stream()
		      .filter(esPastor)
		      .forEach(perris -> System.out.print(perris.getNombre() 
		    		                           + "(" + perris.getRaza() 
		    		                           + "), ") );
		System.out.println();
		long nPastores = perros.stream()
			       		       .filter(esPastor)
			       		       .count();
		System.out.println("Hay " + nPastores + " perros pastores");

		System.out.println("\nPerros pastores jóvenes:");
		Predicate<Perro> esJoven = perris -> (perris.getEdad() < 7);
		perros.stream()
		      .filter(esPastor.and(esJoven))
		      .forEach(System.out::println);
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
