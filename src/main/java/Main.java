import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.View;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Polinom A = new Polinom();
        Polinom B = new Polinom();

        Monom m1 = new Monom(1, 3);
        Monom m2 = new Monom(2, 2);
        Monom m3 = new Monom(5, 1);
        Monom m4 = new Monom(1, 0);
        Monom m5 = new Monom(4, 0);

        A.getPolinom().add(m3);
        A.getPolinom().add(m4);
        B.getPolinom().add(m2);
        B.getPolinom().add(m1);
        B.getPolinom().add(m5);

        System.out.println("A: " + A);
        System.out.println("B: " + B);

        Operatii o = new Operatii();
        Polinom rez = new Polinom();
        //rez = o.adunare(A, B);
        //System.out.println("Adunare: " + rez);
        //rez = o.scadere(A, B);
        //System.out.println("Scadere:" + rez);
        rez = o.inmultire(A, B);
        System.out.println("Inmultire:" + rez);
        //rez = o.derivata(B);
        //System.out.println("Derivata B:" + rez);
        //rez = o.integrala(A);
        //System.out.println("Integrala A:" + rez);

        String sir = "1x^3+4x^2+5x^1+1";
        Polinom C = o.citestePolinom(sir);
        System.out.println(C);
    }
}