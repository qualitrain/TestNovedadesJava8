package qtx.test.interFunc;

//Ejemplo de interfaz funcional: Tiene un solo m�todo

@FunctionalInterface // Es opcional esta declaraci�n
public interface IPromediador<T> {
	public double promediar(T... num); //T... (varargs) indica argumentos variables que se reciben en un arreglo
}
