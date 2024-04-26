package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SinTest extends BasePrecisionedFunctionTest {

    private final Sin sin = new Sin();

    private static DoubleStream from0To2PiNumbers() {
        return DoubleStream.iterate(0.0, d -> d < Math.PI * 2.0, d -> d + 0.1);
    }

    @ParameterizedTest
    @MethodSource("from0To2PiNumbers")
    void from0To2Pi(double x) {
        BigDecimal expected = BigDecimal.valueOf(Math.sin(x));
        BigDecimal actual = sin.evaluate(BigDecimal.valueOf(x), precision, context);
        assertTrue(expected.subtract(actual, context).abs(context).compareTo(precision) <= 0);
    }
}