package complexnumber;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public boolean equals(Object second) {
        if (this == second) {
            return true;
        } else if (second instanceof ComplexNumber) {
            ComplexNumber newSecond = (ComplexNumber) second;
            return (this.getRe() == newSecond.getRe()) && (this.getIm() == newSecond.getIm());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Double.hashCode(re) + Double.hashCode(im);
    }

}