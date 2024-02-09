package qtx.interfunc;


//Ejemplo de interfaz funcional: Tiene un solo metodo

@FunctionalInterface // Es opcional esta declaracion
public interface IPromediador<T> {
	public double promediar(T... num); //T... (varargs) indica argumentos variables que se reciben en un arreglo
}
