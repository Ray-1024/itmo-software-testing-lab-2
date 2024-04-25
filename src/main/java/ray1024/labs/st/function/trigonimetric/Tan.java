package ray1024.labs.st.function.trigonimetric;

import lombok.AllArgsConstructor;
import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Tan extends LimitedIteartionsPrecisionedFunction {
    private final Sin sin;
    private final Cos cos;

    public Tan() {
        sin = new Sin();
        cos = new Cos(sin);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        var sinD = sin.evaluate(x, precision, context);
        var cosD = cos.evaluate(x, precision, context);

        if (cosD.compareTo(BigDecimal.ZERO) == 0)
            throw new IllegalArgumentException("Cannot calculate tan(x) when cos(x) = 0");

        return sinD.divide(cosD, context);
    }
}
