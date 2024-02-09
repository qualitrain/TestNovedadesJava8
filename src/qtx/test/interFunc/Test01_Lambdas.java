package qtx.test.interFunc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test01_Lambdas {
	private static final  String[] MESES = {"enero", "febrero", "marzo", "abril", "mayo", "junio",
			"julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

	public static void testLambda01() {
		//Ejemplo de presentacion de interfaces funcionales especificadas con lambdas
		List<String> listaMeses;
		
		listaMeses = Arrays.asList(MESES); // Crea una lista de tamaño fijo con base en un arreglo
		System.out.println("Meses antes de ordenar:");
		System.out.println(listaMeses);
		
		//Aprovechando interfaz funcional Comparator para crear instancias usando lambdas
		
		//Comparacion lexicografica
//		Comparator<String> cmprMesesAlfab = (String a, String b) -> a.compareTo(b);
		Comparator<String> cmprMesesAlfab = (a,b) -> a.compareTo(b);
		
		//Comparacion por longitud
//		Comparator<String> cmprMesesLongit = (String a, String b) -> a.length() < b.length() ? -1 : 1;
		Comparator<String> cmprMesesLongit = (a, b) -> a.length() < b.length() ? -1 : 1;

		Collections.sort(listaMeses, cmprMesesAlfab);
		System.out.println("\nMeses despues de ordenar alfab�ticamente:");
		System.out.println(listaMeses);

		Collections.sort(listaMeses, cmprMesesLongit);
		System.out.println("\nMeses despues de ordenar por longitud del nombre del mes:");
		System.out.println(listaMeses);
	}
	
	public static void testLambda02() {
		//Version de testLambda01 que crea interfaces funcionales implicitas con lambdas
		List<String> listaMeses;
		
		listaMeses = Arrays.asList(MESES); // Crea una lista de tamaño fijo con base en un arreglo
		System.out.println("Meses antes de ordenar:");
		System.out.println(listaMeses);
		
		// Las interfaces funcionales se instancian implicitamente
		Collections.sort(listaMeses, (String a, String b) -> a.compareTo(b) );
		System.out.println("\nMeses despues de ordenar alfabeticamente:");
		System.out.println(listaMeses);

		// Las interfaces funcionales se instancian implicitamente
		Collections.sort(listaMeses, (a, b) -> a.length() < b.length() ? -1 : 1);
		System.out.println("\nMeses despu�s de ordenar por longitud del nombre del mes:");
		System.out.println(listaMeses);
	}
	
	public static void testLamba03_Promedio(){
		//Implementacion de interfaz funcional tradicional
		IPromediador<Integer> promediador = new PromediadorInt();
		double promedio = promediador.promediar(34,67,12,12,45,33);
		System.out.println("Promedio = " + promedio);
		
		//Implementaciones de interfaz funcional con lambdas
		IPromediador<Integer> promediador2 = (Integer... nums) ->  (nums[0] + nums[1]) / (double)2 ;
		System.out.println("\nPromedio2 = " + promediador2.promediar(10, 5) );
		
		IPromediador<Integer> promediador3 = (nums) ->  (nums[0] + nums[1] + nums[2]) / (double)3 ;
		System.out.println("\nPromedio3 = " + promediador3.promediar(10, 5, 17) );

		IPromediador<Double> promediador4 = (nums) ->  (nums[0] + nums[1] + nums[2]) / (double)3 ;
		System.out.println("\nPromedio4 = " + promediador4.promediar(10.56, 5.89, 17.33) );

		IPromediador<Float> promediador5 = (nums) ->  (nums[0] + nums[1] + nums[2]) / (float)3 ;
		System.out.println("\nPromedio5 = " + promediador5.promediar(10.56F, 5.89F, 17.33F) );

	}
	
	public static void testLambda04_refMetodos() {
		//Version de testLambda02 que crea interfaces funcionales con referencia a metodos
		List<String> listaMeses;
		
		listaMeses = Arrays.asList(MESES); // Crea una lista de tamaño fijo con base en un arreglo
		System.out.println("Meses antes de ordenar:");
		System.out.println(listaMeses);
		
		// La interfaz funcional se instancia con una referencia a un metodo
		Collections.sort(listaMeses, String::compareTo );
		System.out.println("\nMeses despues de ordenar alfabeticamente:");
		System.out.println(listaMeses);
	}
	
	public static void main(String[] args) {
//		testLambda01();
//		testLambda02();
//		testLamba03_Promedio();
		testLambda04_refMetodos();
	}

}
