package ray1024.labs.st.function.trigonimetric;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.PrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Sec implements PrecisionedFunction {
    private final PrecisionedFunction cos;

    public Sec() {
        cos = new Cos();
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        BigDecimal cosD = cos.evaluate(x, precision, context);
        if (cosD.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Cannot evaluate sec(x) when cos(x) is zero");
        }
        return BigDecimal.ONE.divide(cos.evaluate(x, precision, context), context);
    }
}
