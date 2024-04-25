package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SinTest extends BasePrecisionedFunctionTest {

    private final Sin sin = new Sin();

    private DoubleStream from0To2PiNumbers() {
        return DoubleStream.iterate(0.0, d -> d < Math.PI * 2.0, d -> d + 0.1);
    }

    @Test
    @MethodSource("from0To2PiNumbers")
    void from0To2Pi(double x) {
        BigDecimal expected = BigDecimal.valueOf(Math.sin(x)).setScale(precision.scale(), RoundingMode.HALF_UP);
        BigDecimal actual = sin.evaluate(BigDecimal.valueOf(x), precision, context)
                .setScale(precision.scale(), RoundingMode.HALF_UP);
        assertEquals(expected, actual);
    }
}