package qtx.test;

import java.util.Arrays;
import java.util.TreeSet;

import qtx.implement.PromediadorInt;
import qtx.interfunc.IPromediador;

public class Test {

	public static void testInterFuncional01() {
		IPromediador<Integer> promediador = new PromediadorInt();		
		double promedio = promediador.promediar(1 ,2 ,3, 4, 5, 10, 15);
		System.out.println("El promedio fue:" + promedio);
	}
	
	public static void testInterFuncional02() {
		IPromediador<Integer> promediador = arr -> ( arr[0] + arr[1] + arr[2] ) / 3.0;
		double promedio = promediador.promediar(5, 10, 15);
		System.out.println("El promedio fue:" + promedio);		
	}
	
	public static void testInterFuncional03() {
		IPromediador<Double> promediador = 
				arr -> { 
					      double acum = 0.0;
					      for(int i=0; i<arr.length; i++)
					    	  acum += arr[i];
					      return acum / arr.length;
						};
		double promedio = promediador.promediar(5.0, 10.0, 15.0, 99.0, 121.45);
		System.out.println("El promedio fue:" + promedio);		
	}
	
	/**
	 * Ejemplifica la implementación de una Interfaz Comparator por medio de una lambda
	 */
	public static void testInterFuncional04() {
		TreeSet<String> arbolSet = new TreeSet<>( (cad1,cad2)-> cad1.length() < cad2.length() ? -1 : 1);
		arbolSet.addAll(Arrays.asList("Perro", "Gato", "Raton", "Cocodrilo", "Rinoceronte","Jirafa", "Elefante", "Pato"));
		System.out.println(arbolSet);
		
		TreeSet<String> arbolSet2 = new TreeSet<>( (cad1,cad2)-> cad2.compareTo(cad1));
		arbolSet2.addAll(arbolSet);
		System.out.println(arbolSet2);		
	}
	
	public static void main(String[] args) {
		testInterFuncional01();
		testInterFuncional02();
		testInterFuncional03();	
		testInterFuncional04();			
	}

}
