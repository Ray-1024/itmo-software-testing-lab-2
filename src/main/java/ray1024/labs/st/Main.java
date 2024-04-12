package ray1024.labs.st;

import ray1024.labs.st.function.csv.CsvPrecisionedFunctionRangeWriter;
import ray1024.labs.st.function.logarithmic.Ln;
import ray1024.labs.st.function.logarithmic.Log;
import ray1024.labs.st.function.system.LabFunctionsSystem;
import ray1024.labs.st.function.trigonimetric.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        final BigDecimal step = BigDecimal.valueOf(0.1);
        final MathContext context = MathContext.DECIMAL128;
        final BigDecimal precision = BigDecimal.valueOf(1e-6);

        for (CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs csvFunctionAreaArgs : Arrays.asList(
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/sin.csv",
                        new Sin(),
                        BigDecimal.valueOf(-10),
                        BigDecimal.valueOf(10),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/cos.csv",
                        new Cos(),
                        BigDecimal.valueOf(-10),
                        BigDecimal.valueOf(10),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/tan.csv",
                        new Tan(),
                        BigDecimal.valueOf(-10),
                        BigDecimal.valueOf(10),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/cot.csv",
                        new Cot(),
                        BigDecimal.valueOf(-10),
                        BigDecimal.valueOf(10),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/sec.csv",
                        new Sec(),
                        BigDecimal.valueOf(-10),
                        BigDecimal.valueOf(10),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/ln.csv",
                        new Ln(),
                        BigDecimal.valueOf(0.1),
                        BigDecimal.valueOf(20),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/log2.csv",
                        new Log(2),
                        BigDecimal.valueOf(0.1),
                        BigDecimal.valueOf(20),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/log3.csv",
                        new Log(3),
                        BigDecimal.valueOf(0.1),
                        BigDecimal.valueOf(20),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/log5.csv",
                        new Log(5),
                        BigDecimal.valueOf(0.1),
                        BigDecimal.valueOf(20),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/log10.csv",
                        new Log(10),
                        BigDecimal.valueOf(0.1),
                        BigDecimal.valueOf(20),
                        step,
                        precision,
                        context
                ),
                new CsvPrecisionedFunctionRangeWriter.CsvFunctionAreaArgs(
                        "csv/system.csv",
                        new LabFunctionsSystem(),
                        BigDecimal.valueOf(-20),
                        BigDecimal.valueOf(20),
                        step,
                        precision,
                        context
                )
        ))
            CsvPrecisionedFunctionRangeWriter.write(csvFunctionAreaArgs);
    }
}