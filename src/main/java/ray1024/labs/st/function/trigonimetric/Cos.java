package ray1024.labs.st.function.trigonimetric;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@AllArgsConstructor
public class Cos extends LimitedIteartionsPrecisionedFunction {

    private static final BigDecimal PI = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679");
    private static final BigDecimal PI2 = PI.divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);
    private static final BigDecimal PI32 = PI.multiply(BigDecimal.valueOf(3)).divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);

    private final Sin sin;

    public Cos() {
        sin = new Sin();
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        x = CircledFunctionUtils.circle(x, context);

        var sinD = sin.evaluate(x, precision, context);
        var cosD = BigDecimal.ONE.subtract(sinD.pow(2)).sqrt(context);

        if (x.compareTo(PI2) >= 0 && x.compareTo(PI32) <= 0) cosD = cosD.negate();

        return cosD;
    }
}
