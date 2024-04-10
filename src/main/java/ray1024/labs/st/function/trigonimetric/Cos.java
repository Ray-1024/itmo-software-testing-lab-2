package ray1024.labs.st.function.trigonimetric;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.PrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Cos implements PrecisionedFunction {
    private final PrecisionedFunction sin;

    public Cos() {
        sin = new Sin();
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        var sinD = sin.evaluate(x, precision, context);
        var cosD = BigDecimal.ONE.subtract(sinD.pow(2)).sqrt(context);
        BigDecimal pi2 = BigDecimal.valueOf(Math.PI / 2.0);
        BigDecimal pi32 = BigDecimal.valueOf(1.5 * Math.PI);
        if (x.compareTo(pi2) >= 0 && x.compareTo(pi32) <= 0) cosD = cosD.negate();
        return cosD;
    }
}
