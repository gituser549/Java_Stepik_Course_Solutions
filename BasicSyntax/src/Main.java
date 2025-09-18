import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.print("It's alive! It's alive!\n");
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && !c && !d) || (a && c && !b && !d) || (a && d && !b && !c) ||
                (b && c && !a && !d) || (b && d && !a && !c) || (c && d && !a && !b);
    }

    public static int leapYearCount(int year) {
        return (year / 4) - (year / 100) + (year / 400);
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) <= 1.0e-4;
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));
    }

    public static char charExpression(int a) {
        return (char)('\\' + a);
    }

    public static boolean isPowerOfTwo(int value) {
        return (Integer.bitCount(Math.abs(value))) == 1;
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int i = 0, j = 0, k = 0;
        int[] a3 = new int[a1.length + a2.length];
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                a3[k] = a1[i];
                i++;
            } else {
                a3[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < a1.length) {
            a3[k++] = a1[i++];
        }
        while (j < a2.length) {
            a3[k++] = a2[j++];
        }
        return a3;
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder[] linesByRoles = new StringBuilder[roles.length];
        for (int i = 0; i < roles.length; i++) {
            linesByRoles[i] = new StringBuilder("");
        }

        int lineNum = 0;
        // String parsing
        for (String curStr : textLines) {
            lineNum++;
            String curRole = "";
            int i;
            for (i = 0; curStr.charAt(i) != ':'; i++) {
                curRole += curStr.charAt(i);
            }

            linesByRoles[find(roles, curRole)].append(lineNum + ")" + curStr.substring(i + 1, curStr.length()) + "\n");
        }

        StringBuilder newText = new StringBuilder("");
        for (int i = 0; i < linesByRoles.length; i++) {
            newText.append(roles[i] + ":\n");
            if (linesByRoles[i] != null) {
                newText.append(linesByRoles[i]);
            }
            newText.append("\n");
        }

        return newText.toString().trim();
    }

    public static int find(String[] strs, String goalStr) {
        int i = 0;
        for ( ; i < strs.length; i++) {
            if (strs[i].equals(goalStr)) {
                break;
            }
        }
        return i;
    }

}