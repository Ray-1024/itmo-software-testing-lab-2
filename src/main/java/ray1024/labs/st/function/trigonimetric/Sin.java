package ray1024.labs.st.function.trigonimetric;


import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;
import ray1024.labs.st.function.PrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

public class Sin extends LimitedIteartionsPrecisionedFunction {
    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        final MathContext mc = new MathContext(precision.scale());
        x = CircledFunctionUtils.circle(x, context);

        final BigDecimal x2 = x.pow(2, context);

        boolean isPositive = true;
        BigDecimal pow = x;
        BigDecimal fact = BigDecimal.ONE;
        long index = 2;
        long step = 1;
        BigDecimal delta;
        BigDecimal f = x;

        do {
            ++step;
            if (step >= iterationsLimit) break;
            isPositive = !isPositive;
            pow = pow.multiply(x2, context);
            fact = fact.multiply(BigDecimal.valueOf(index++), context).multiply(BigDecimal.valueOf(index++), context);
            delta = pow.divide(fact, context);
            f = isPositive ? f.add(delta, context) : f.subtract(delta, context);
        } while (delta.abs().compareTo(precision) > 0);

        return f;
    }
}
