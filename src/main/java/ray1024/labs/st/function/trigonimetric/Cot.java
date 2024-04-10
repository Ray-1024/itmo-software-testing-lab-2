package ray1024.labs.st.function.trigonimetric;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.PrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Cot implements PrecisionedFunction {
    private final PrecisionedFunction sin;
    private final PrecisionedFunction cos;

    public Cot() {
        sin = new Sin();
        cos = new Cos(sin);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        var sinD = sin.evaluate(x, precision, context);
        var cosD = cos.evaluate(x, precision, context);
        if (sinD.compareTo(BigDecimal.ZERO) == 0)
            throw new IllegalArgumentException("Cannot calculate cot(x) when sin(x) = 0");
        return cosD.divide(sinD, context);
    }
}
