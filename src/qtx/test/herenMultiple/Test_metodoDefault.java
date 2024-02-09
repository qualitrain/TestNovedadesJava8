package qtx.test.herenMultiple;

public class Test_metodoDefault {

	public static void main(String[] args) {
		ICalculadorImpuestos taxer = new CalculadoraImpuestos();
		ICalculadorImpuestos taxer2 = new CalculadoraContable();
		
		System.out.println("IVA (1):" + taxer.calcularIva(9999));
		System.out.println("IVA (2):" + taxer2.calcularIva(9999));
	}

}
