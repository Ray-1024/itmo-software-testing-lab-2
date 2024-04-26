package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ray1024.labs.st.function.trigonimetric.CircledFunctionUtils.*;


@ExtendWith(MockitoExtension.class)
public class CircledFunctionUtilsTest extends BasePrecisionedFunctionTest {

    private static Stream<BigDecimal> fromZeroTo2PiPoints() {
        return Stream.of(ZERO, BigDecimal.valueOf(0.1), PI_2, BigDecimal.valueOf(1.0), PI, BigDecimal.valueOf(4.0), PI3_2);
    }

    private static Stream<BigDecimal> negativePoints() {
        return fromZeroTo2PiPoints().map(x -> x.subtract(PI2, DEFAULT_CONTEXT));
    }

    private static Stream<BigDecimal> longPositivePoints() {
        return fromZeroTo2PiPoints().map(x -> x.add(PI2, DEFAULT_CONTEXT));
    }


    @ParameterizedTest
    @MethodSource("fromZeroTo2PiPoints")
    public void circleValueFromZeroTo2Pi(BigDecimal x) {
        assertEqualsByPrecisionAndContext(x, circle(x, context));
    }

    @ParameterizedTest
    @MethodSource("negativePoints")
    public void circleNegativeValue(BigDecimal x) {
        assertEqualsByPrecisionAndContext(x.add(PI2, context), circle(x, context));
    }

    @ParameterizedTest
    @MethodSource("longPositivePoints")
    public void circleLongPositiveValue(BigDecimal x) {
        assertEqualsByPrecisionAndContext(x.subtract(PI2, context), circle(x, context));
    }

}