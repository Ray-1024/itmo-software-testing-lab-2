package ray1024.labs.st.function.system;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ray1024.labs.st.function.BasePrecisionedFunctionTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class LabFunctionsSystemTest extends BasePrecisionedFunctionTest {
    private final LabFunctionsSystem system = new LabFunctionsSystem();

    // [-6.1;-6] [-5.7;-5.3] [-4.1;-4] [4.1;4.2] [-2.5;-2.2] [-2.1; -1.7] [-1.6; -0.9]
    // [0;0.1] [1.5;2]
    @Test
    public void test1() {
        assertTrue(system.evaluate(BigDecimal.valueOf(-6.05), precision, context).signum() > 0);
    }

    @Test
    public void test2() {
        assertTrue(system.evaluate(BigDecimal.valueOf(-5.5), precision, context).signum() < 0);
    }

    @Test
    public void test3() {
        assertTrue(system.evaluate(BigDecimal.valueOf(-4.05), precision, context).signum() < 0);
    }

    @Test
    public void test4() {
        assertTrue(system.evaluate(BigDecimal.valueOf(-4.15), precision, context).signum() < 0);
    }

    @Test
    public void test5() {
        assertTrue(system.evaluate(BigDecimal.valueOf(-2.3), precision, context).signum() < 0);
    }

    @Test
    public void test6() {
        assertTrue(system.evaluate(BigDecimal.valueOf(-1.0), precision, context).signum() < 0);
    }

    @Test
    public void test7() {
        assertTrue(system.evaluate(BigDecimal.valueOf(0.05), precision, context).signum() < 0);
    }

    @Test
    public void test8() {
        assertTrue(system.evaluate(BigDecimal.valueOf(1.5), precision, context).signum() > 0);
    }

    @Test
    public void test9() {
        assertTrue(system.evaluate(BigDecimal.valueOf(-6.05), precision, context).signum() > 0);
    }

}