package ray1024.labs.st.function;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class LimitedIteartionsPrecisionedFunction implements PrecisionedFunction {
    private final static long DEFAULT_ITERATIONS_LIMIT = 1000;

    protected final long iterationsLimit;

    public LimitedIteartionsPrecisionedFunction() {
        iterationsLimit = DEFAULT_ITERATIONS_LIMIT;
    }
}
