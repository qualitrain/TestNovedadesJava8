package qtx.test.interFunc.streams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test12Parallel {

	public static void main(String[] args) {
		List<Perro> perros = getListaPerros();
		Date inicioStream = new Date();
		System.out.println("perros.stream().forEach");
		perros.stream().map(Perro::getNombre).forEach(System.out::println );
		Date finStream = new Date();

		Date inicioParalleStream = new Date();
		System.out.println("\nperros.parallelStream().forEach");
		perros.parallelStream().map(Perro::getNombre).forEach(System.out::println);
		Date finParalleStream = new Date();
		
		Date inicioForEach = new Date();
		System.out.println("\nperros for-Each");
		for(Perro perroI : perros) {
			System.out.println(perroI.getNombre());
		}
		perros.parallelStream().map(Perro::getNombre).forEach(System.out::println);
		Date finForEach = new Date();
		
		
		long milisStream = finStream.getTime() - inicioStream.getTime();
		long milisParallel = finParalleStream.getTime() - inicioParalleStream.getTime();
		long milisForEach = finForEach.getTime() - inicioForEach.getTime();
		
		System.out.println("Milisegundos Stream:" + milisStream);
		System.out.println("Milisegundos ParalleStream:" + milisParallel);
		System.out.println("Milisegundos ciclo for-each sin stream:" + milisForEach);
		
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
