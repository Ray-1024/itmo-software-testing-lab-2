package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.stream.DoubleStream;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ray1024.labs.st.function.trigonimetric.CircledFunctionUtils.*;

@ExtendWith(MockitoExtension.class)
public class SinTest extends BasePrecisionedFunctionTest {

    private final Sin sin = new Sin();

    private static DoubleStream from0To2PiNumbers() {
        return DoubleStream.iterate(0.0, d -> d < Math.PI * 2.0, d -> d + 0.1);
    }

    @ParameterizedTest
    @MethodSource("from0To2PiNumbers")
    void from0To2Pi(double x) {
        assertEqualsByPrecisionAndContext(BigDecimal.valueOf(Math.sin(x)), sin.evaluate(BigDecimal.valueOf(x), precision, context));
    }

    @Test
    void zero() {
        assertEqualsByPrecisionAndContext(sin.evaluate(ZERO, precision, context), ZERO);
    }

    @Test
    void pi_2() {
        assertEqualsByPrecisionAndContext(sin.evaluate(PI_2, precision, context), ONE);
    }

    @Test
    void pi() {
        assertEqualsByPrecisionAndContext(sin.evaluate(PI, precision, context), ZERO);
    }

    @Test
    void pi3_2() {
        assertEqualsByPrecisionAndContext(sin.evaluate(PI3_2, precision, context), ONE.negate());
    }

    public static Sin tableStub() {
        Sin mocked = mock(Sin.class);
        when(mocked.evaluate(eq(ZERO.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.round(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ONE.round(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.round(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI3_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ONE.negate(DEFAULT_CONTEXT));
        return mocked;
    }
}