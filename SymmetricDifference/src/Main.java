import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("It's alive! It's alive!");
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<>();

        T[] arr1 = (T[]) set1.toArray();
        T[] arr2 = (T[]) set2.toArray();

        for (int i = 0; i < arr1.length; i++) {
            if (!set2.contains(arr1[i])) {
                resultSet.add(arr1[i]);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (!set1.contains(arr2[i])) {
                resultSet.add(arr2[i]);
            }
        }

        return resultSet;
    }
}