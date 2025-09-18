
public class Main {
    public static void main(String[] args) {
        System.out.print("It's alive! It's alive!\n");
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x); // your implementation here
    }

    public static String getCallerClassAndMethodName() {
        Throwable checker = new Throwable();
        StackTraceElement[] stackOfCalls = checker.getStackTrace();
        return stackOfCalls.length >= 3 ? stackOfCalls[2].getClassName() + "#" + stackOfCalls[2].getMethodName() : null;
    }
}