package qtx.test.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import qtx.test.interFunc.streams.Perro;

public class TestOptional {

	private static String[] nombresPerros = {"Midas","Beethoven","Frijol","Pelucita","Campeón","Killer"};
	public static void main(String[] args) {
		Map<String,Perro> mapaPerros = getMapaPerros();
		Perro perroDefault = new Perro("inexistente","",0,0.0f);
//		System.out.println(mapaPerros);
//		System.out.println(mapaPerros.getClass().getName());
		Optional<Perro> opPerro = Optional.ofNullable(mapaPerros.get("Bolillo"));
		System.out.println(opPerro.orElse(perroDefault));
		
		List<String> listaNombresP = Arrays.asList(nombresPerros);
		listaNombresP.stream()
		             .map( nom -> Optional.ofNullable( mapaPerros.get(nom) ))
		             .forEach(oPerris -> System.out.println(oPerris.orElse(perroDefault)));
	}
	private static Map<String,Perro> getMapaPerros(){
		List<Perro> perros = getListaPerros();
		return perros.stream()
				     .collect(Collectors.toMap(Perro::getNombre, perris -> perris));
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
