import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        int prev = System.in.read();
        int cur = System.in.read();
        while (prev != -1) {
            if (prev == 13 && cur == 10) {
                // ignore
            } else {
                System.out.write(prev);
            }
            prev = cur;
            cur = System.in.read();
        }
        System.out.flush();
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int Cn = 0;
        int b = inputStream.read();
        while (b != -1) {
            Cn = Integer.rotateLeft(Cn, 1) ^ b;
            b = inputStream.read();
        }
        return Cn;
    }




}