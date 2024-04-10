package ray1024.labs.st.function.system;


import lombok.AllArgsConstructor;
import ray1024.labs.st.function.PrecisionedFunction;
import ray1024.labs.st.function.logarithmic.Ln;
import ray1024.labs.st.function.logarithmic.Log;
import ray1024.labs.st.function.trigonimetric.*;

import java.math.BigDecimal;
import java.math.MathContext;

@AllArgsConstructor
public class LabFunctionsSystem implements PrecisionedFunction {

    private final PrecisionedFunction sin;
    private final PrecisionedFunction cos;
    private final PrecisionedFunction tan;
    private final PrecisionedFunction cot;
    private final PrecisionedFunction sec;

    private final PrecisionedFunction ln;
    private final PrecisionedFunction log2;
    private final PrecisionedFunction log3;
    private final PrecisionedFunction log5;
    private final PrecisionedFunction log10;

    public LabFunctionsSystem() {
        sin = new Sin();
        cos = new Cos(sin);
        tan = new Tan(sin, cos);
        cot = new Cot(sin, cos);
        sec = new Sec(cos);

        ln = new Ln();
        log2 = new Log(ln, 2);
        log3 = new Log(ln, 3);
        log5 = new Log(ln, 5);
        log10 = new Log(ln, 10);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        BigDecimal sinX = sin.evaluate(x, precision, context);
        BigDecimal cosX = cos.evaluate(x, precision, context);
        BigDecimal tanX = tan.evaluate(x, precision, context);
        BigDecimal cotX = cot.evaluate(x, precision, context);
        BigDecimal secX = sec.evaluate(x, precision, context);

        BigDecimal lnX = ln.evaluate(x, precision, context);
        BigDecimal log2X = log2.evaluate(x, precision, context);
        BigDecimal log3X = log3.evaluate(x, precision, context);
        BigDecimal log5X = log5.evaluate(x, precision, context);
        BigDecimal log10X = log10.evaluate(x, precision, context);

        if (x.compareTo(BigDecimal.ZERO) <= 0) {
            BigDecimal left = sinX.add(tanX, context).subtract(cosX, context).divide(tanX, context).add(sinX, context);
            BigDecimal right = secX.subtract(cosX, context).multiply(sinX, context).subtract(cotX, context);
            return left.multiply(right, context);
        } else {
            BigDecimal left = lnX.divide(log2X, context).pow(3).subtract(log3X, context).subtract(log5X, context);
            BigDecimal right = log10X.add(log2X.divide(lnX, context), context).divide(log2X, context).subtract(cotX, context);
            return left.add(right, context);
        }
    }
}