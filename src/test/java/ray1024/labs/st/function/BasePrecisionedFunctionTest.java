package ray1024.labs.st.function;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePrecisionedFunctionTest {
    public static final BigDecimal DEFAULT_PRECISION = BigDecimal.valueOf(1e-6);
    public static final MathContext DEFAULT_CONTEXT = MathContext.DECIMAL128;

    protected BigDecimal precision = DEFAULT_PRECISION;
    protected MathContext context = DEFAULT_CONTEXT;

    protected void assertEqualsByPrecisionAndContext(BigDecimal a, BigDecimal b) {
        assertTrue(a.subtract(b, context).abs(context).compareTo(precision) <= 0, a + " != " + b);
    }
}
