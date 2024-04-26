package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static ray1024.labs.st.function.trigonimetric.CircledFunctionUtils.*;

@ExtendWith(MockitoExtension.class)
class CosTest extends BasePrecisionedFunctionTest {

    private final Cos cos = new Cos();

    @Test
    void testOnceCallSin() {
        Sin spySin = spy(new Sin());
        Cos spiedCos = new Cos(spySin);
        spiedCos.evaluate(BigDecimal.TEN, precision, context);
        verify(spySin, atLeastOnce()).evaluate(any(BigDecimal.class), eq(precision), eq(context));
    }

    @Test
    void useSinMock() {
        Cos mockedCos = new Cos(SinTest.tableStub());
        assertEqualsByPrecisionAndContext(ONE, mockedCos.evaluate(ZERO, precision, context));
        assertEqualsByPrecisionAndContext(ZERO, mockedCos.evaluate(PI_2, precision, context));
        assertEqualsByPrecisionAndContext(ONE.negate(), mockedCos.evaluate(PI, precision, context));
        assertEqualsByPrecisionAndContext(ZERO, mockedCos.evaluate(PI3_2, precision, context));
    }

    @Test
    void zero() {
        assertEqualsByPrecisionAndContext(ONE, cos.evaluate(ZERO, precision, context));
    }

    @Test
    void pi_2() {
        assertEqualsByPrecisionAndContext(ZERO, cos.evaluate(PI_2, precision, context));
    }

    @Test
    void pi() {
        assertEqualsByPrecisionAndContext(ONE.negate(), cos.evaluate(PI, precision, context));
    }

    @Test
    void pi3_2() {
        assertEqualsByPrecisionAndContext(ZERO, cos.evaluate(PI3_2, precision, context));
    }

    public static Cos tableStub() {
        Cos mocked = mock(Cos.class);
        when(mocked.evaluate(eq(ZERO.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ONE.round(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.round(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ONE.negate(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI3_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.round(DEFAULT_CONTEXT));
        return mocked;
    }
}