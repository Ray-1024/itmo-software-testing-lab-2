package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CircledFunctionUtilsTest {

    private static final MathContext CONTEXT = MathContext.DECIMAL128;

    @Test
    public void circleValueFromZeroTo2Pi() {
        DoubleStream.of(0.0, 0.1, Math.PI / 2.0, 1.0, Math.PI, 4.0, 1.5 * Math.PI).mapToObj(BigDecimal::valueOf).forEach(x -> assertEquals(x, CircledFunctionUtils.circle(x, CONTEXT)));
    }

    @Test
    public void circleNegativeValue() {
        DoubleStream.of(-0.1, -Math.PI / 2.0, -1.0, -Math.PI, -4.0, -1.5 * Math.PI).mapToObj(BigDecimal::valueOf).forEach(x -> assertEquals(x.add(BigDecimal.valueOf(Math.PI * 2.0), CONTEXT), CircledFunctionUtils.circle(x, CONTEXT)));
    }

    @Test
    public void circleLongValue() {
        DoubleStream.of(0.0, 0.1, Math.PI / 2.0, 1.0, Math.PI, 4.0, 1.5 * Math.PI).map(x -> x + Math.PI * 2.0).mapToObj(BigDecimal::valueOf).forEach(x -> assertEquals(x.subtract(BigDecimal.valueOf(Math.PI * 2.0), CONTEXT), CircledFunctionUtils.circle(x, CONTEXT)));
    }

    @Test
    public void circle2Pi() {
        assertEquals(
                BigDecimal.ZERO,
                CircledFunctionUtils.circle(BigDecimal.valueOf(Math.PI * 2.0), CONTEXT)
                        .setScale(CONTEXT.getPrecision(), RoundingMode.HALF_EVEN));
    }
}