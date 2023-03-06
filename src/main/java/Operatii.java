import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Operatii {

    public Operatii(){
    }

    public int getGrad (Polinom A) {
        ArrayList<Integer> exp = new ArrayList<Integer>();
        for(Monom m: A.getPolinom())
            exp.add(m.getExponent());
        Collections.sort(exp, Collections.reverseOrder());

        int grad = exp.get(0);

        return grad;
    }

    Polinom adunare (Polinom A, Polinom B) {
        Polinom rezultat = new Polinom();

            for (Monom ma : A.getPolinom()){
                for (Monom mb : B.getPolinom())
                    if (ma.getExponent() == mb.getExponent()) {
                        Monom aux = new Monom(0, 0);
                        aux.setExponent(ma.getExponent());
                        aux.setCoeficient(ma.getCoeficient()+mb.getCoeficient());
                        ma.setEsteInPolinom(true);
                        mb.setEsteInPolinom(true);
                        rezultat.getPolinom().add(aux);
                    }
            }
        for(Monom ma : A.getPolinom())
            if(ma.isEsteInPolinom()==false) {
                rezultat.getPolinom().add(ma);
                ma.setEsteInPolinom(true);
            }

        for(Monom mb : B.getPolinom())
            if(mb.isEsteInPolinom()==false) {
                rezultat.getPolinom().add(mb);
                mb.setEsteInPolinom(true);
            }

        return rezultat;
    }

    Polinom inmultireCuScalar (Polinom A){
        Polinom rezultat = new Polinom();

        for (Monom ma : A.getPolinom()) {
            Monom aux = new Monom(0, 0);
            aux.setExponent(ma.getExponent());
            aux.setCoeficient(-1 * ma.getCoeficient());
            rezultat.getPolinom().add(aux);
        }
        return rezultat;
    }

    Polinom scadere(Polinom A, Polinom B){
        Polinom rezultat = new Polinom();
        Polinom minusB = inmultireCuScalar(B);
        rezultat = adunare(A, minusB);
        return rezultat;
    }

    Polinom inmultire(Polinom A, Polinom B) {
        Polinom rezultat = new Polinom();
        Polinom r2 = new Polinom();

        for (Monom ma : A.getPolinom()) {
            for (Monom mb : B.getPolinom()) {
                Monom aux = new Monom(0, 0);
                aux.setExponent(ma.getExponent() + mb.getExponent());
                aux.setCoeficient(ma.getCoeficient() * mb.getCoeficient());
                rezultat.getPolinom().add(aux);
            }
        }
        int grad = getGrad(rezultat);
        while(grad>-1) {
            int coef = 0;
            for (Monom m : rezultat.getPolinom()) {
                    if (m.getExponent() == grad)
                        coef+=m.getCoeficient();
            }
            Monom aux = new Monom(0, 0);
            aux.setExponent(grad);
            aux.setCoeficient(coef);
            r2.getPolinom().add(aux);
            grad--;
        }
        return r2;
    }
/*
    ArrayList<Polinom> impartire (Polinom A, Polinom B){
        ArrayList<Polinom> rezultat = new ArrayList<Polinom>();
        Polinom C = new Polinom();
        while(getGrad(A) >= getGrad(B)){
            Monom ma = A.getMonomMax;
            Monom mb = B.getMonomMax();
            Monom mc = ma.devide(mb);
            C.getPolinom().add(mc);
        }
    } */

    Polinom derivata (Polinom A){
        Polinom rezultat = new Polinom();

        for (Monom ma : A.getPolinom()) {
            Monom aux = new Monom(0, 0);
            aux.setExponent(ma.getExponent()-1);
            aux.setCoeficient(ma.getExponent() * ma.getCoeficient());
            rezultat.getPolinom().add(aux);
        }
        return rezultat;
    }

    Polinom integrala (Polinom A){
        Polinom rezultat = new Polinom();

        for (Monom ma : A.getPolinom()) {
            Monom aux = new Monom(0, 0);
            aux.setExponent(ma.getExponent()+1);
            aux.setCoeficient(ma.getCoeficient() / (ma.getExponent()+1));
            rezultat.getPolinom().add(aux);
        }
        return rezultat;
    }

    public int exponent(String s){
        int exp=0;
        //System.out.println(s.length());
        if(s.length() == 2)
            exp = 0;
        else {
            String[] aux = s.split("\\^");
            //System.out.println(aux[0]);
            exp = Integer.parseInt(aux[1]);
            //System.out.println(exp);
        }
        return exp;
    }

    public double coeficient(String s){
        String[] aux = s.split("x");
        double coef = Double.parseDouble(aux[0]);
        return coef;
    }

    public Polinom citestePolinom(String s){
        //imparte sirul in grupuri (monoame)
        Polinom p = new Polinom();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()){
            //System.out.println(matcher.group(1));
            //gaseste coef si exp din fiecare grup pentru a forma monoamele pe care le adaug in polinom
            double c = coeficient(matcher.group(1));
            int e = exponent(matcher.group(1));
            Monom m = new Monom(c, e);
            p.getPolinom().add(m);
        }
        return p;
    }
}
