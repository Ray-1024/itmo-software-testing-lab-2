package ray1024.labs.st.function.trigonimetric;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Cot extends LimitedIteartionsPrecisionedFunction {
    private final Sin sin;
    private final Cos cos;

    public Cot() {
        sin = new Sin();
        cos = new Cos(sin);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        var sinD = sin.evaluate(x, precision, context);
        var cosD = cos.evaluate(x, precision, context);

        if (sinD.abs(context).compareTo(precision) <= 0)
            throw new IllegalArgumentException("Argument can't be equal to pi*n, n ∈ Z");

        return cosD.divide(sinD, context);
    }
}
