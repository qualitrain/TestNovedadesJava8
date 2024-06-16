package qtx.test.interFunc.streams;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Test08PerrosMap {

	public static void main(String[] args) {
		testStream_Filter();
	}
	private static void testStream_Filter() {
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getRaza() + "), " ) );
		System.out.println();
	
		System.out.println("\nNombres de perros en html:");
		Function<Perro,String> funcionMapeo = perris -> "<li>" + perris.getNombre() + "</li>";
		List<String> perrosHtml = new ArrayList<>();		
		perros.stream()
		      .map(funcionMapeo)
		      .forEach(li -> perrosHtml.add(li));
		System.out.println(perrosHtml);

		// Uso de sum
		double pesoGlobalPerros = perros.stream()
				                        .mapToDouble(perris -> perris.getPeso())
				                        .sum();
		BigDecimal bdPesoTotal = (new BigDecimal(pesoGlobalPerros)).setScale(2, RoundingMode.HALF_UP);
		System.out.println("El peso total de todos los perros es " + bdPesoTotal + " Kg." );
		
		// Uso de distinct
		System.out.println("Razas distintas:");
		perros.stream()
		      .map(p -> p.getRaza())
		      .distinct()
		      .sorted()
		      .forEach(System.out::println);
		
	}	

	private static List<Perro> getListaPerros() {
		List<Perro> perros = new ArrayList<Perro>();
		
		perros.add(new Perro("Firulais","French Poodle", 4,12.5F ));
		perros.add(new Perro("Nubecita","French Poodle", 5,15.3F ));
		perros.add(new Perro("Bailaor","French Poodle", 2,13.0F ));
		
		perros.add(new Perro("Tyson","Boxer", 11, 28.3F ));
		perros.add(new Perro("Midas","Boxer", 10, 26.0F ));
		perros.add(new Perro("Campeon","Boxer", 10, 25.5F ));
		
		perros.add(new Perro("Zapato","Pastor Ingl�s", 12, 50.7F ));
		perros.add(new Perro("Killer","Pastor Ingl�s", 6, 45.5F ));
		perros.add(new Perro("Morris","Pastor Ingl�s", 3, 48.2F ));
		
		perros.add(new Perro("Motita","D�lmata", 2, 38.1F ));
		perros.add(new Perro("Hans","Pastor Alem�n", 6, 41.5F ));
		perros.add(new Perro("Quesito","Chihuahua", 4, 1.3F ));
		return perros;
	}

}
