package ray1024.labs.st.function.trigonimetric;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Sec extends LimitedIteartionsPrecisionedFunction {
    private final Cos cos;

    public Sec() {
        cos = new Cos();
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        BigDecimal cosD = cos.evaluate(x, precision, context);

        if (cosD.abs(context).compareTo(precision) <= 0) {
            throw new IllegalArgumentException("Argument can't be equal to pi/2 + pi*n, n ∈ Z");
        }

        return BigDecimal.ONE.divide(cos.evaluate(x, precision, context), context);
    }
}
