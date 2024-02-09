package qtx.test.herenMultiple;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface IRedondeador {
	default BigDecimal redondear(double num) {
		BigDecimal numBd = new BigDecimal(num);
		return numBd.setScale(2, RoundingMode.HALF_UP);
	}

}
