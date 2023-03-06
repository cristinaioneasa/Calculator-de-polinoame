public class Monom {
    private double coeficient;
    private int exponent;
    boolean esteInPolinom;

    public Monom(double coeficient, int exponent) {
        this.coeficient = coeficient;
        this.exponent = exponent;
    }

    public boolean isEsteInPolinom() {
        return esteInPolinom;
    }

    public void setEsteInPolinom(boolean esteInPolinom) {
        this.esteInPolinom = esteInPolinom;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        if( coeficient == 0 )
            return "";

        if( exponent == 0 && coeficient > 0 )
            return "+" + coeficient ;

        if( exponent == 0 && coeficient < 0 )
            return  coeficient + "";

        if(coeficient == 1)
            return "+x^" + exponent;

        if(coeficient > 1)
            return "+" + coeficient + "x^" + exponent;
        else
            return coeficient + "x^" + exponent;
    }
}
