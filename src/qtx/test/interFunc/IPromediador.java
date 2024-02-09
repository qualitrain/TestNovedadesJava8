package qtx.test.interFunc;

//Ejemplo de interfaz funcional: Tiene un solo método

@FunctionalInterface // Es opcional esta declaración
public interface IPromediador<T> {
	public double promediar(T... num); //T... (varargs) indica argumentos variables que se reciben en un arreglo
}
