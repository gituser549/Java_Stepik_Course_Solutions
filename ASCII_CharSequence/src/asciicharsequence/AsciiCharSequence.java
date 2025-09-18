package asciicharsequence;

public class AsciiCharSequence implements java.lang.CharSequence/* extends/implements */ {

    private byte[] charSequence;

    public AsciiCharSequence(byte[] byteArray) {
        charSequence = byteArray.clone();
    }

    public int length() {
        return charSequence.length;
    }

    public char charAt(int index) {
        return (char)charSequence[index];
    }

    public AsciiCharSequence subSequence(int start, int end) {
        byte[] newByteSequence = new byte[end - start];
        for (int i = start; i < end; i++) {
            newByteSequence[i - start] = charSequence[i];
        }
        return new AsciiCharSequence(newByteSequence);
    }

    public String toString() {
        StringBuilder newString = new StringBuilder("");
        for (int i = 0; i < charSequence.length; i++) {
            newString.append((char)charSequence[i]);
        }
        return newString.toString();
    }

}










