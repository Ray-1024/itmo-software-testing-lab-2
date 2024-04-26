package ray1024.labs.st.function.logarithmic;


import ray1024.labs.st.function.LimitedIteartionsPrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

public class Log extends LimitedIteartionsPrecisionedFunction {
    private final Ln ln;
    private final BigDecimal base;

    public Log(Ln ln, BigDecimal base) {
        this.ln = ln;
        this.base = base;
        if (base.signum() < 0) throw new IllegalArgumentException("Base cannot be negative");
        if (base.compareTo(BigDecimal.ONE) == 0) throw new IllegalArgumentException("Base cannot be equal to 1");
    }

    public Log(BigDecimal base) {
        this(new Ln(), base);
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        return ln.evaluate(x, precision, context).divide(ln.evaluate(base, precision, context), context);
    }
}
