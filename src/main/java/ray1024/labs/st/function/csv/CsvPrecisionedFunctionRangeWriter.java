package ray1024.labs.st.function.csv;

import lombok.AllArgsConstructor;
import ray1024.labs.st.function.PrecisionedFunction;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Paths;

public class CsvPrecisionedFunctionRangeWriter implements Closeable {

    private static final String DEFAULT_SEPARATOR = ",";

    private final PrintWriter writer;
    private final String separator;

    @AllArgsConstructor
    public static final class CsvFunctionAreaArgs {
        private PrecisionedFunction function;
        private BigDecimal l;
        private BigDecimal r;
        private BigDecimal step;
        private BigDecimal precision;
        private MathContext context;
    }

    public CsvPrecisionedFunctionRangeWriter(String filename, String separator) throws IOException {
        this.separator = separator;

        File file = new File(Paths.get(filename).toUri());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        writer = new PrintWriter(file);
    }

    public CsvPrecisionedFunctionRangeWriter(String filename) throws IOException {
        this(filename, DEFAULT_SEPARATOR);
    }

    public void write(CsvFunctionAreaArgs args) {

        for (; args.l.compareTo(args.r) <= 0; args.l = args.l.add(args.step, args.context)) {
            BigDecimal f;
            try {
                f = args.function.evaluate(args.l, args.precision, args.context);
            } catch (Exception ex) {
                f = null;
            }
            writer.println(args.l + separator + f);
        }

    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
