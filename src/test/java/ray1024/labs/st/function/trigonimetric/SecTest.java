package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static ray1024.labs.st.function.trigonimetric.CircledFunctionUtils.*;

@ExtendWith(MockitoExtension.class)
public class SecTest extends BasePrecisionedFunctionTest {
    private final Cot sec = new Cot();

    @Test
    void testOnceCallSin() {
        Sin spySin = spy(new Sin());
        Cos spyCos = spy(new Cos(spySin));
        Cot spiedCot = new Cot(spySin, spyCos);
        spiedCot.evaluate(BigDecimal.TEN, precision, context);

        verify(spySin, times(2)).evaluate(any(BigDecimal.class), eq(precision), eq(context));
        verify(spyCos, atLeastOnce()).evaluate(any(BigDecimal.class), eq(precision), eq(context));
    }

    @Test
    void useSinCosMock() {
        Cot mockedCot = new Cot(SinTest.tableStub(), CosTest.tableStub());

        assertEqualsByPrecisionAndContext(ZERO.round(context), mockedCot.evaluate(PI_2.round(context), precision, context));
        assertEqualsByPrecisionAndContext(ZERO.round(context), mockedCot.evaluate(PI3_2.round(context), precision, context));
        assertThrows(IllegalArgumentException.class, () -> mockedCot.evaluate(ZERO.round(context), precision, context));
        assertThrows(IllegalArgumentException.class, () -> mockedCot.evaluate(PI.round(context), precision, context));
    }

    @Test
    void zero() {
        assertThrows(IllegalArgumentException.class, () -> sec.evaluate(ZERO.round(context), precision, context));
    }

    @Test
    void pi_2() {
        assertEqualsByPrecisionAndContext(ZERO.round(context), sec.evaluate(PI_2, precision, context));
    }

    @Test
    void pi() {
        assertThrows(IllegalArgumentException.class, () -> sec.evaluate(PI.round(context), precision, context));
    }

    @Test
    void pi3_2() {
        assertEqualsByPrecisionAndContext(ZERO.round(context), sec.evaluate(PI3_2.round(context), precision, context));
    }

    public static Cot tableStub() {
        Cot mocked = mock(Cot.class);
        when(mocked.evaluate(eq(PI_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.round(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI3_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.negate(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(ZERO.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenThrow(IllegalArgumentException.class);
        when(mocked.evaluate(eq(PI.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenThrow(IllegalArgumentException.class);
        return mocked;
    }
}