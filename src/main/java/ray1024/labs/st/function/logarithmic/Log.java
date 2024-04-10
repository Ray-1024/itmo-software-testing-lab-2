package ray1024.labs.st.function.logarithmic;


import ray1024.labs.st.function.PrecisionedFunction;

import java.math.BigDecimal;
import java.math.MathContext;

public class Log implements PrecisionedFunction {
    private final PrecisionedFunction ln;
    private final BigDecimal base;

    public Log(long base) {
        this.ln = new Ln();
        this.base = BigDecimal.valueOf(base);
        if (base < 0) throw new IllegalArgumentException("Base cannot be negative");
        if (base == 1) throw new IllegalArgumentException("Base cannot be equal to 1");
    }

    public Log(PrecisionedFunction ln, long base) {
        this.ln = ln;
        this.base = BigDecimal.valueOf(base);
        if (base < 0) throw new IllegalArgumentException("Base cannot be negative");
        if (base == 1) throw new IllegalArgumentException("Base cannot be equal to 1");
    }

    @Override
    public BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context) {
        if (x.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Cannot evaluate log(x) when x <= 0");
        return ln.evaluate(x, precision, context).divide(ln.evaluate(base, precision, context), context);
    }
}
