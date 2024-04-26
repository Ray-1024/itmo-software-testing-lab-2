package ray1024.labs.st;

import ray1024.labs.st.function.csv.CsvPrecisionedFunctionRangeWriter;
import ray1024.labs.st.function.logarithmic.Ln;
import ray1024.labs.st.function.logarithmic.Log;
import ray1024.labs.st.function.system.LabFunctionsSystem;
import ray1024.labs.st.function.trigonimetric.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        final BigDecimal step = BigDecimal.valueOf(0.1);
        final MathContext context = MathContext.DECIMAL128;
        final BigDecimal precision = BigDecimal.valueOf(1e-8);

        new HashMap<String, CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs>() {{
            put("csv/sin.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Sin(),
                    BigDecimal.valueOf(-10),
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/cos.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Cos(),
                    BigDecimal.valueOf(-10),
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/tan.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Tan(),
                    BigDecimal.valueOf(-10),
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/cot.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Cot(),
                    BigDecimal.valueOf(-10),
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/sec.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Sec(),
                    BigDecimal.valueOf(-10),
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/ln.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Ln(),
                    step,
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/log2.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Log(BigDecimal.TWO),
                    step,
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/log3.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Log(BigDecimal.valueOf(3)),
                    step,
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/log5.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Log(BigDecimal.valueOf(5)),
                    step,
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/log10.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new Log(BigDecimal.TEN),
                    step,
                    BigDecimal.valueOf(10),
                    step,
                    precision,
                    context
            ));
            put("csv/system.csv", new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                    new LabFunctionsSystem(),
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