package ray1024.labs.st.function;

import java.math.BigDecimal;
import java.math.MathContext;

public class BasePrecisionedFunctionTest {
    protected BigDecimal precision = BigDecimal.valueOf(1e-6);
    protected MathContext context = MathContext.DECIMAL128;
}
