package qtx.test.interFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test04PerrosRemoveIf {

	public static void main(String[] args) {
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getEdad() + "), " ) );
		System.out.println();
	
		Predicate<Perro> predicado = perris -> perris.getEdad() > 5;
		// método de la interfaz funcional Predicate<T>: boolean test(T t)
		perros.removeIf(predicado);
		System.out.println("Perros de 5 o menos años:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getEdad() + "), " ) );
		System.out.println();
		
		perros = getListaPerros();
		perros.removeIf(p -> p.getEdad() > 8);
		System.out.println("Perros de 8 o menos años:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getEdad() + "), " ) );
		System.out.println();

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
