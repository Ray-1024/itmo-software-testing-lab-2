package ray1024.labs.st.function.trigonimetric;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public interface CircledFunctionUtils {
    static BigDecimal circle(BigDecimal x, MathContext context) {
        final BigDecimal pi2 = BigDecimal.valueOf(Math.PI * 2.0);
        if (x.compareTo(pi2) >= 0) {
            return x.subtract(
                    x.divide(pi2, context)
                            .setScale(0, RoundingMode.HALF_EVEN)
                            .multiply(pi2, context),
                    context);
        }
        if (x.signum() < 0) {
            x = x.negate(context);
            return pi2.subtract(
                    x.subtract(
                            x.divide(pi2, context)
                                    .setScale(0, RoundingMode.HALF_EVEN)
                                    .multiply(pi2, context),
                            context),
                    context);
        }
        return x;
    }
}
