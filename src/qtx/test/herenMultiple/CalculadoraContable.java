package qtx.test.herenMultiple;

public class CalculadoraContable implements ICalculadorImpuestos, IRedondeador {

	@Override
	public double calcularISAN(double importe) {
		float tasaXimporte = getTasa(importe);
		return importe * tasaXimporte;
	}

	private float getTasa(double importe) {
		// Obtener tasa proporcional al importe... 
		return 0.14f;
	}

	@Override
	public double calcularIva(double importe) {
		double base = ICalculadorImpuestos.super.calcularIva(importe); //Invocación método default desde implementación
		double iva = base * 1.01;
		return this.redondear(iva).doubleValue();
	}
}
