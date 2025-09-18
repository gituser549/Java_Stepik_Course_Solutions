import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.print("It's alive! It's alive!\n");
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double sum = 0;
        while (a < b) {
            sum += f.applyAsDouble(a) * 0.000001;
            a += 0.000001;
        }
        return sum;
    }
}