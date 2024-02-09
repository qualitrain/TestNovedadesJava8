package qtx.test.interFunc;

public class Perro {
	private String nombre;
	private String raza;
	private int edad;
	private float peso;
	public Perro(String nombre, String raza, int edad, float peso) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", peso=" + peso + "]" +"\n";
	}
	public int compararXnombre(Perro otroPerro) {
		if( this.nombre.compareToIgnoreCase(otroPerro.nombre) < 0 )
			return -1;
		else 
			return 1;
	}
	public int compararXraza(Perro otroPerro) {
		if( this.raza.compareToIgnoreCase(otroPerro.raza) < 0 )
			return -1;
		else 
			return 1;
	}
	public int compararXrazaYnombre(Perro otroPerro) {
		
		int iComparador =  this.raza.compareToIgnoreCase(otroPerro.raza);
		if(iComparador != 0) //Son distintos
			return iComparador;
		return this.compararXnombre(otroPerro);
	}
	public static int compararXedadYpeso(Perro perro, Perro perro2) {
		if(perro.edad == perro2.edad)
			if(perro.peso <= perro2.peso)
				return -1;
			else
				return 1;
		else
			if(perro.edad < perro2.edad)
				return -1;
			else
				return 1;
	}
	
}
