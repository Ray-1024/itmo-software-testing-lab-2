package ray1024.labs.st.function.trigonimetric;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CosTest {

    private static final MathContext CONTEXT = MathContext.DECIMAL128;
    private static final BigDecimal DEFAULT_PRECISION = BigDecimal.valueOf(1e-16);

    private final Sin sinMock = Mockito.mock(Sin.class);

    @Before
    public void cleanMocks() {
        Mockito.reset(sinMock);
    }

    @Test
    public void pi2NCos() {
        Mockito.when(sinMock.evaluate(Mockito.eq(BigDecimal.valueOf(0)), Mockito.any(), Mockito.any()))
                .thenReturn(BigDecimal.ZERO);

        Mockito.when(sinMock.evaluate(Mockito.eq(BigDecimal.valueOf(Math.PI / 2.0)), Mockito.any(), Mockito.any()))
                .thenReturn(BigDecimal.ONE);

        Mockito.when(sinMock.evaluate(Mockito.eq(BigDecimal.valueOf(Math.PI)), Mockito.any(), Mockito.any()))
                .thenReturn(BigDecimal.ZERO);

        Mockito.when(sinMock.evaluate(Mockito.eq(BigDecimal.valueOf(Math.PI * 1.5)), Mockito.any(), Mockito.any()))
                .thenReturn(BigDecimal.ONE.negate());

        Cos cos = new Cos(sinMock);

        assertEquals(cos.evaluate(BigDecimal.valueOf(0), DEFAULT_PRECISION, CONTEXT), BigDecimal.ONE);
        assertEquals(cos.evaluate(BigDecimal.valueOf(Math.PI / 2.0), DEFAULT_PRECISION, CONTEXT), BigDecimal.ZERO);
        assertEquals(cos.evaluate(BigDecimal.valueOf(Math.PI), DEFAULT_PRECISION, CONTEXT), BigDecimal.ONE.negate());
        assertEquals(cos.evaluate(BigDecimal.valueOf(Math.PI * 1.5), DEFAULT_PRECISION, CONTEXT), BigDecimal.ZERO);
    }
}