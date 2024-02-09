package qtx.test.interFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test03PerrosForEach {

	public static void mostrarPerro(Perro perro) {
		System.out.println("\n----------------------------------");
		System.out.println("Nombre:" + perro.getNombre() + ", raza:" + perro.getRaza());
	}
	public static void mostrarPerroGrande(Perro perro) {
		if(perro.getPeso() < 30) 
			return;
		System.out.println("Nombre perrote:" + perro.getNombre() + ", raza:" + perro.getRaza());		
	}
	public static void main(String[] args) {
		List<Perro> perros = getListaPerros();
		
		Consumer<Perro> consumidor = x -> System.out.print(x.getNombre() + ", ");
		// método de la interfaz funcional Consumer<T>: void accept(T t)
		perros.forEach(consumidor);
		
		System.out.println();
		perros.forEach(perris -> System.out.print(perris.getNombre() + " "));
		
		System.out.println();
		perros.forEach(Test03PerrosForEach::mostrarPerro);

		System.out.println();
		perros.forEach(Test03PerrosForEach::mostrarPerroGrande);

		System.out.println();
		perros.forEach(p -> mostrarPerroGrande(p));

		System.out.println();
		perros.forEach(System.out::println);
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
