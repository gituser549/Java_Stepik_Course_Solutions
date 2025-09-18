import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if (counter % 2 != 0) {
                    list.add(scanner.nextInt());
                } else {
                    scanner.nextInt();
                }
                counter++;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
    }
}