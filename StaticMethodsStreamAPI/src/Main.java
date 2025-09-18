import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.IntSupplier;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        scanner.useDelimiter("[^а-яА-Яa-zA-Z0-9]+");
        Stream<String> stream = Stream.generate(() -> (scanner.hasNext()) ?
                scanner.next() : null).limit(100000).filter(a -> (a != null));

        HashMap<String, Integer> amountsByWords = new HashMap<>();
        HashSet<String> words = new HashSet<>();

        stream.forEach(a -> {
            String toLowerA = a.toLowerCase();
            if (amountsByWords.containsKey(toLowerA)) {
                amountsByWords.put(toLowerA, amountsByWords.get(toLowerA) + 1);
            } else {
                amountsByWords.put(toLowerA, 1);
                words.add(toLowerA);
            }
        });

        String[] wordsArray = words.toArray(new String[words.size()]);

        Comparator<String> compare = (a, b) -> {
            int amountsCompareResults = Integer.compare(amountsByWords.get(a), amountsByWords.get(b));
            if (amountsCompareResults != 0) {
                return -amountsCompareResults;
            }
            return a.compareTo(b);
        };

        Arrays.stream(wordsArray).sorted(compare).limit(10).forEach(System.out::println);

    }

    public static IntStream pseudoRandomStream(int seed) {
        IntSupplier supplier = () -> Integer.parseInt(safetySubstring(Integer.valueOf(seed * seed).toString()));
        IntStream stream = IntStream.iterate(seed, n -> Integer.parseInt(safetySubstring(Integer.toString(n * n))));
        return stream; // your implementation here

    }

    public static String safetySubstring(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return "0";
        }
        return str.substring(Integer.max(0, str.length() - 4), Integer.max(str.length() - 1, 1));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        T[] array = (T[]) stream.toArray();

        if (array.length == 0) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T max = array[0], min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (order.compare(max, array[i]) < 0) {
                max = array[i];
            } else if (order.compare(min, array[i]) > 0) {
                min = array[i];
            }
        }

        minMaxConsumer.accept(min, max);
    }




}