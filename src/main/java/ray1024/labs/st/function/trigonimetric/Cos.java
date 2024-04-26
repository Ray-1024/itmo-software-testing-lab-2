package ray1024.labs.st.function.trigonimetric;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class Cos extends LimitedIteartionsPrecisionedFunction {
    private final Sin sin;

    public Cos() {
        sin = new Sin();
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        x = CircledFunctionUtils.circle(x, context);

        var sinD = sin.evaluate(x, precision, context);
        var sin2D = sinD.pow(2, context);
        if (sin2D.compareTo(BigDecimal.ONE) > 0) sin2D = BigDecimal.ONE;
        var cosD = BigDecimal.ONE.subtract(sin2D, context).sqrt(context);

        if (x.compareTo(CircledFunctionUtils.PI_2) > 0 && x.compareTo(CircledFunctionUtils.PI3_2) < 0)
            cosD = cosD.negate(context);

        return cosD;
    }
}
