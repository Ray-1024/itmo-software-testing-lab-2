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

        if (cosD.abs(context).compareTo(precision) <= 0)
            throw new IllegalArgumentException("Argument can't be equal to pi/2 + pi*n, n ∈ Z");

        return sinD.divide(cosD, context);
    }
}
