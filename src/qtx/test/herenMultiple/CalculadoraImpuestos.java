package qtx.test.herenMultiple;

public class CalculadoraImpuestos implements ICalculadorImpuestos {

	@Override
	public double calcularISAN(double importe) {
		float tasaXimporte = getTasa(importe);
		return importe * tasaXimporte;
	}

	private float getTasa(double importe) {
		// Obtener tasa proporcional al importe... 
		return 0.12f;
	}

}
