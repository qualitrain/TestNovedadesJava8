package qtx.test.interFunc.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test06PerrosSorted {

	public static void main(String[] args) {
		testStream_Sort();
	}
	private static void testStream_Sort() {
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getRaza() + "), " ) );
		System.out.println();
	
		System.out.println("\nPerros ordenados por edad:");
		Comparator<Perro> comparadorEdad = (p, p2) -> p.getEdad() < p2.getEdad() ? -1 : 1;
		perros.stream()
		      .sorted(comparadorEdad)
		      .forEachOrdered(perris -> System.out.println(perris.getNombre() 
		    		                                      + " (" 
		    		                                      + perris.getEdad() 
		    		                                      + ")"));
		
		System.out.println("\nPerros ordenados por nombre:");
		perros.stream()
		      .sorted(Perro::compararXnombre)
		      .forEachOrdered(perris -> System.out.println(perris.getNombre() 
		    		                                      + " (" 
		    		                                      + perris.getEdad() 
		    		                                      + ")"));
		
		System.out.println("\nPerros ordenados por raza y nombre:");
		perros.stream()
		      .sorted(Perro::compararXrazaYnombre)
		      .forEachOrdered(perris -> System.out.println(perris.getRaza() 
		    		                                      + " (" 
		    		                                      + perris.getNombre() 
		    		                                      + ")"));

		System.out.println("\nLos 5 perros más jóvenes:");
		perros.stream()
		      .sorted(comparadorEdad)
		      .limit(5L)
		      .forEachOrdered(perris -> System.out.println(perris.getNombre() 
		    		                                      + " (" 
		    		                                      + perris.getEdad() 
		    		                                      + ")"));		
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
