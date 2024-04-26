package ray1024.labs.st.function.logarithmic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LnTest extends BasePrecisionedFunctionTest {
    @Test
    void argumentCantBeNegativeOrZero() {
        assertThrows(IllegalArgumentException.class, () -> new Ln().evaluate(ONE.negate(), precision, context));
        assertThrows(IllegalArgumentException.class, () -> new Ln().evaluate(ZERO, precision, context));
    }

    @Test
    void one() {
        assertEqualsByPrecisionAndContext(ZERO, new Ln().evaluate(ONE, precision, context));
    }

    public static Ln tableStub() {
        Ln ln = mock(Ln.class);
        when(ln.evaluate(ONE.negate(), DEFAULT_PRECISION, DEFAULT_CONTEXT)).thenThrow(IllegalArgumentException.class);
        when(ln.evaluate(ZERO, DEFAULT_PRECISION, DEFAULT_CONTEXT)).thenThrow(IllegalArgumentException.class);
        when(ln.evaluate(ONE, DEFAULT_PRECISION, DEFAULT_CONTEXT)).thenReturn(ZERO);
        return ln;
    }
}