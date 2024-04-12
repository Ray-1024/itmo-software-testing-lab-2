package ray1024.labs.st.function.csv;

import lombok.AllArgsConstructor;
import ray1024.labs.st.function.PrecisionedFunction;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Paths;

public class CsvPrecisionedFunctionRangeWriter {

    private static final String SEPARATOR = ",";

    @AllArgsConstructor
    public static final class CsvFunctionAreaArgs {
        private String filename;
        private PrecisionedFunction function;
        private BigDecimal l;
        private BigDecimal r;
        private BigDecimal step;
        private BigDecimal precision;
        private MathContext context;
    }

    public static void write(CsvFunctionAreaArgs args) throws IOException {
        File file = new File(Paths.get(args.filename).toUri());

        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        PrintWriter printWriter = new PrintWriter(file);

        for (; args.l.compareTo(args.r) <= 0; args.l = args.l.add(args.step, args.context)) {
            BigDecimal f;
            try {
                f = args.function.evaluate(args.l, args.precision, args.context);
            } catch (IllegalArgumentException ex) {
                f = null;
            }
            printWriter.println(args.l + SEPARATOR + f);
        }

        printWriter.close();
    }
}
