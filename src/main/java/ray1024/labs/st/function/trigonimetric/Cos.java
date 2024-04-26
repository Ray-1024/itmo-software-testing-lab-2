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
        var cosD = BigDecimal.ONE.subtract(sinD.pow(2)).sqrt(context);

        if (x.compareTo(CircledFunctionUtils.PI_2) >= 0 && x.compareTo(CircledFunctionUtils.PI3_2) <= 0)
            cosD = cosD.negate();

        return cosD;
    }
}
