package ray1024.labs.st.function;

import java.math.BigDecimal;
import java.math.MathContext;

public interface PrecisionedFunction {
    BigDecimal evaluate(BigDecimal x, BigDecimal precision, MathContext context);
}
