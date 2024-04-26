package ray1024.labs.st.function;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BasePrecisionedFunctionTest {
    protected final static BigDecimal PI = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679");
    protected final static BigDecimal PI2 = PI.multiply(BigDecimal.TWO);
    protected final static BigDecimal PI_2 = PI.divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);
    protected final static BigDecimal PI3_2 = PI.multiply(BigDecimal.valueOf(3)).divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);

    protected BigDecimal precision = BigDecimal.valueOf(1e-6);
    protected MathContext context = MathContext.DECIMAL128;

    protected boolean checkEqualsByPrecisionAndContext(BigDecimal a, BigDecimal b) {
        return a.subtract(b, context).abs(context).compareTo(precision) <= 0;
    }
}
