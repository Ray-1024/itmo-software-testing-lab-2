package ray1024.labs.st.function.trigonimetric;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class CircledFunctionUtils {
    public static final BigDecimal PI = new BigDecimal("3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679");
    public static final BigDecimal PI2 = PI.multiply(BigDecimal.TWO);
    public static final BigDecimal PI_2 = PI.divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);
    public static final BigDecimal PI3_2 = PI.multiply(BigDecimal.valueOf(3)).divide(BigDecimal.TWO, RoundingMode.HALF_EVEN);

    public static BigDecimal circle(BigDecimal x, MathContext context) {
        if (x.compareTo(PI2) >= 0) {
            return x.subtract(
                    x.divide(PI2, context)
                            .setScale(0, RoundingMode.HALF_EVEN)
                            .multiply(PI2, context),
                    context);
        }
        if (x.signum() < 0) {
            x = x.negate(context);
            return PI2.subtract(
                    x.subtract(
                            x.divide(PI2, context)
                                    .setScale(0, RoundingMode.HALF_EVEN)
                                    .multiply(PI2, context),
                            context),
                    context);
        }
        return x;
    }
}
