import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringBuilder expr = new StringBuilder();
        int symb = 0;
        try {
            while ((symb = System.in.read()) != -1) {
                expr.append((char) symb);
            }
        } catch (Throwable exc) {
            // ignore
        }
        String[] parsedDoubles = expr.toString().split("[ \n\r]");
        double[] doubles = new double[parsedDoubles.length];
        int i = 0;
        for (String curStr : parsedDoubles) {
            try {
                double curDouble = Double.parseDouble(curStr);
                doubles[i++] = curDouble;
            } catch (Throwable exc) {
                // ignore
            }
        }
        System.out.printf("%.6f\n", Arrays.stream(doubles).sum());
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int symb = 0;
        while ((symb = inputStream.read()) != -1) {
            outputStream.write(symb);
        }
        return new String(outputStream.toByteArray(), charset);
    }
}