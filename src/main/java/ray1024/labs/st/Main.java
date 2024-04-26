package ray1024.labs.st;

import ray1024.labs.st.function.csv.CsvPrecisionedFunctionRangeWriter;
import ray1024.labs.st.function.trigonimetric.Sin;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        final BigDecimal step = BigDecimal.valueOf(0.1);
        final MathContext context = MathContext.DECIMAL128;
        final BigDecimal precision = BigDecimal.valueOf(1e-6);

        new HashMap<String, CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs>() {{
            put("csv/sin.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Sin(),
                    BigDecimal.valueOf(-10),
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
        }}.forEach((filename, arguments) -> {
            try {
                var writer = new CsvPrecisionedFunctionRangeWriter(filename);
                writer.write(arguments);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}