package pair;

import java.util.Objects;

class Pair<T1, T2> {
    private final T1 valueFir;
    private final T2 valueSec;

    private Pair(T1 valueFir, T2 valueSec) {
        this.valueFir = valueFir;
        this.valueSec = valueSec;
    }

    public static <T1, T2> Pair<T1, T2> of(T1 valueFir, T2 valueSec) {
        return new Pair<T1, T2>(valueFir, valueSec);
    }

    public T1 getFirst() {
        return valueFir;
    }

    public T2 getSecond() {
        return valueSec;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Pair<?, ?> pairSec = (Pair<?, ?>) obj;
        return Objects.equals(this.valueFir, pairSec.valueFir) &&
                Objects.equals(this.valueSec, pairSec.valueSec);
    }

    public int hashCode() {
        return Objects.hashCode(valueFir) + Objects.hashCode(valueSec);
    }

}
