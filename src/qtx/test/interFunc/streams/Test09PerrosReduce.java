package qtx.test.interFunc.streams;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class Test09PerrosReduce {

	public static void main(String[] args) {
		testStream_ReduccionBasica();
		sumVsReduce();
		testReduce03();
	}
	private static void testStream_ReduccionBasica() {
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.print(p.getNombre() + "(" + p.getEdad() + "), " ) );
		System.out.println();
	
		double edadPromedio = perros.stream()
				                    .mapToInt(perris -> perris.getEdad())
				                    .average()
				                    .getAsDouble();
		BigDecimal bdEdadPromedio = ( new BigDecimal(edadPromedio) ).setScale(2, RoundingMode.HALF_UP);
		System.out.println("La edad promedio de los perros es: " + bdEdadPromedio);
		
		int edadMinima = perros.stream()
				               .mapToInt(perris -> perris.getEdad())
				               .min()
				               .getAsInt();
		System.out.println("La edad m�nima encontrada fue: " + edadMinima);
		
		int edadMaxima = perros.stream()
	               .mapToInt(perris -> perris.getEdad())
	               .max()
	               .getAsInt();
		System.out.println("La edad m�xima encontrada fue: " + edadMaxima);
		
		long nPerrosMenores = perros.stream()
				                   .filter(perris->perris.getEdad() < bdEdadPromedio.floatValue() )
				                   .count();
		System.out.println("Hay " + nPerrosMenores + " perros con edad debajo del promedio");
	}	

	private static void sumVsReduce() {
		System.out.println("===================================================================");
		System.out.println("                         sum() VS reduce()");
		System.out.println("===================================================================");
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.println(p.getNombre() + " (" + p.getPeso() + ")" ) );
		System.out.println();
		
		double pesoTotal = perros.stream()
				                 .mapToDouble(perris -> perris.getPeso())
				                 .sum();
		System.out.println("Peso total de todos los perros -con sum()  - : " + pesoTotal);
		
		double valInicial = 0.0;
		DoubleBinaryOperator funcionAcumulacion = (double acumulado, double sigValor) -> acumulado + sigValor;
		pesoTotal = perros.stream()
				          .mapToDouble(perris -> perris.getPeso())
				          .reduce(valInicial, funcionAcumulacion);
		System.out.println("Peso total de todos los perros -con reduce()-: " + pesoTotal);
		
		//Otra manera m�s breve pero equivalente a la anterior:
		pesoTotal = perros.stream()
		          .mapToDouble(perris -> perris.getPeso())
		          .reduce(0, (a, sig) -> a + sig );
		System.out.println("Peso total de todos los perros -con reduce()-: " + pesoTotal);
		
	}
	private static void testReduce03() {
		System.out.println("===================================================================");
		System.out.println("                         Ejemplo reduccion");
		System.out.println("===================================================================");
		List<Perro> perros = getListaPerros();
		
		System.out.println("Perros:");
		perros.forEach(p -> System.out.println(p.getNombre() + " (" + p.getRaza() + ")" ) );
		System.out.println();
		
		String razas = perros.stream()
				             .map(perris -> perris.getRaza())
				             .distinct()
				             .reduce("", (acum, nextRaza) -> acum + nextRaza + ", " );
		System.out.println("Razas distintas: " + razas);
				
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

}
