package ray1024.labs.st.function.logarithmic;


import ray1024.labs.st.function.PrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

public class Ln implements PrecisionedFunction {
    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        x = x.subtract(BigDecimal.ONE, context);

        if (x.abs().compareTo(BigDecimal.ONE) >= 0) throw new IllegalArgumentException("The power series diverges");

        BigDecimal f = x;
        boolean isPositive = true;
        BigDecimal pow = x;
        long index = 2;
        BigDecimal delta;

        do {
            pow = pow.multiply(x, context);
            isPositive = !isPositive;
            delta = pow.divide(BigDecimal.valueOf(index++), context);
            f = isPositive ? f.add(delta, context) : f.subtract(delta, context);
        } while (delta.abs().compareTo(precision) > 0);

        return f;
    }
}
