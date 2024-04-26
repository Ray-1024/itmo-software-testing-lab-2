package ray1024.labs.st.function.trigonimetric;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class CircledFunctionUtilsTest extends BasePrecisionedFunctionTest {

    private static Stream<BigDecimal> fromZeroTo2PiPoints() {
        return Stream.of(
                BigDecimal.valueOf(0.0),
                BigDecimal.valueOf(0.1),
                BigDecimal.valueOf(Math.PI / 2.0),
                BigDecimal.valueOf(1.0),
                BigDecimal.valueOf(Math.PI),
                BigDecimal.valueOf(4.0),
                BigDecimal.valueOf(1.5 * Math.PI)
        );
    }

    private static Stream<BigDecimal> negativePoints() {
        return fromZeroTo2PiPoints().map(BigDecimal::negate);
    }

    private static Stream<BigDecimal> longPositivePoints() {
        return fromZeroTo2PiPoints().map(x -> x.add(BasePrecisionedFunctionTest.PI2));
    }


    @ParameterizedTest
    @MethodSource("fromZeroTo2PiPoints")
    public void circleValueFromZeroTo2Pi(BigDecimal x) {
        assertTrue(checkEqualsByPrecisionAndContext(x, CircledFunctionUtils.circle(x, context)));
    }

    @ParameterizedTest
    @MethodSource("negativePoints")
    public void circleNegativeValue(BigDecimal x) {

    }

    @ParameterizedTest
    @MethodSource("longPositivePoints")
    public void circleLongPositiveValue(BigDecimal x) {

    }

}