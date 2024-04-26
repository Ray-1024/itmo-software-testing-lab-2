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
import static org.mockito.Mockito.*;
import static ray1024.labs.st.function.trigonimetric.CircledFunctionUtils.*;

@ExtendWith(MockitoExtension.class)
public class TanTest extends BasePrecisionedFunctionTest {
    private final Tan tan = new Tan();

    @Test
    void testOnceCallSin() {
        Sin spySin = spy(new Sin());
        Cos spyCos = spy(new Cos(spySin));
        Tan spiedTan = new Tan(spySin, spyCos);
        spiedTan.evaluate(BigDecimal.TEN, precision, context);

        verify(spySin, times(2)).evaluate(any(BigDecimal.class), eq(precision), eq(context));
        verify(spyCos, atLeastOnce()).evaluate(any(BigDecimal.class), eq(precision), eq(context));
    }

    @Test
    void useSinCosMock() {
        Tan mockedTan = new Tan(SinTest.tableStub(), CosTest.tableStub());

        assertEqualsByPrecisionAndContext(ZERO, mockedTan.evaluate(ZERO, precision, context));
        assertThrows(IllegalArgumentException.class, () -> mockedTan.evaluate(PI_2.round(context), precision, context));
        assertEqualsByPrecisionAndContext(ZERO, mockedTan.evaluate(PI.round(context), precision, context));
        assertThrows(IllegalArgumentException.class, () -> mockedTan.evaluate(PI3_2.round(context), precision, context));
    }

    @Test
    void zero() {
        assertEqualsByPrecisionAndContext(ZERO, tan.evaluate(ZERO, precision, context));
    }

    @Test
    void pi_2() {
        assertThrows(IllegalArgumentException.class, () -> tan.evaluate(PI_2, precision, context));
    }

    @Test
    void pi() {
        assertEqualsByPrecisionAndContext(ZERO, tan.evaluate(PI, precision, context));
    }

    @Test
    void pi3_2() {
        assertThrows(IllegalArgumentException.class, () -> tan.evaluate(PI3_2, precision, context));
    }

    public static Tan tableStub() {
        Tan mocked = mock(Tan.class);
        when(mocked.evaluate(eq(ZERO.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.round(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenThrow(IllegalArgumentException.class);
        when(mocked.evaluate(eq(PI.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenReturn(ZERO.negate(DEFAULT_CONTEXT));
        when(mocked.evaluate(eq(PI3_2.round(DEFAULT_CONTEXT)), any(BigDecimal.class), any(MathContext.class))).thenThrow(IllegalArgumentException.class);
        return mocked;
    }
}