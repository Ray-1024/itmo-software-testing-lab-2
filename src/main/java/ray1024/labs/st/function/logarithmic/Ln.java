package ray1024.labs.st.function.logarithmic;


import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

public class Ln extends LimitedIteartionsPrecisionedFunction {
    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        x = x.subtract(BigDecimal.ONE, context);

        BigDecimal f = x;
        boolean isPositive = true;
        BigDecimal pow = x;
        long index = 2;
        long step = 1;
        BigDecimal delta;

        do {
            ++step;
            if (step >= iterationsLimit) break;
            pow = pow.multiply(x, context);
            isPositive = !isPositive;
            delta = pow.divide(BigDecimal.valueOf(index++), context);
            f = isPositive ? f.add(delta, context) : f.subtract(delta, context);
        } while (delta.abs().compareTo(precision) > 0);

        return f;
    }
}
