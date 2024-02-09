package qtx.test.interFunc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test02PerrosRefMetodos {

	public static void main(String[] args) {
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros ordenados por nombre:\n");
		Collections.sort(perros, Perro::compararXnombre);
		System.out.println(perros);
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("Perros ordenados por raza:\n");
		Collections.sort(perros, Perro::compararXraza);
		System.out.println(perros);
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("Perros ordenados por raza y nombre:\n");
		Collections.sort(perros, Perro::compararXrazaYnombre);
		System.out.println(perros);
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("Perros ordenados por edad y peso:\n");
		Collections.sort(perros, Perro::compararXedadYpeso);
		System.out.println(perros);
		
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
