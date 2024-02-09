package qtx.test.herenMultiple;

public interface ICalculadorImpuestos {
	default double calcularIva(double importe) { //Impuesto al valor agregado
		return importe * 0.16;
	}
	double calcularISAN(double importe); //Impuesto sobre adquisición de autos
}
