import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField p1;
    private JTextField p2;
    private JButton integrala;
    private JButton inmultire;
    private JButton impartire;
    private JButton derivata;
    private JButton scadere;
    private JButton adunare;
    private JTextField rezultat;
    private JTextField rest;
    private JPanel Calculator;
    private JButton c;

    private Operatii op = new Operatii();

    public View(){
        setContentPane(Calculator);
        setTitle("Calculator Polinoame");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        adunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adunare(e);
            }
        });

        scadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scadere(e);
            }
        });

        inmultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inmultire(e);
            }
        });

        impartire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                impartire(e);
            }
        });

        derivata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                derivata(e);
            }
        });

        integrala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                integrala(e);
            }
        });

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear(e);
            }
        });
    }

    public void adunare(ActionEvent e){
        Polinom A= new Polinom();
        A = op.citestePolinom(p1.getText());
        Polinom B= new Polinom();
        B = op.citestePolinom(p2.getText());
        Polinom rez = new Polinom();
        rez = op.adunare(A, B);
        rezultat.setText(rez.toString());
    }

    public void scadere(ActionEvent e){
        Polinom A= new Polinom();
        A = op.citestePolinom(p1.getText());
        Polinom B= new Polinom();
        B = op.citestePolinom(p2.getText());
        Polinom rez = new Polinom();
        rez = op.scadere(A, B);
        rezultat.setText(rez.toString());
    }

    public void inmultire(ActionEvent e){
        Polinom A= new Polinom();
        A = op.citestePolinom(p1.getText());
        Polinom B= new Polinom();
        B = op.citestePolinom(p2.getText());
        Polinom rez = new Polinom();
        rez = op.inmultire(A, B);
        rezultat.setText(rez.toString());
    }

    public void impartire(ActionEvent e){
        rezultat.setText("Nu am implementat aceasta operatie");
    }

    public void derivata(ActionEvent e){
        Polinom A= new Polinom();
        A = op.citestePolinom(p1.getText());
        Polinom rez = new Polinom();
        rez = op.derivata(A);
        rezultat.setText(rez.toString());
    }

    public void integrala(ActionEvent e){
        Polinom A= new Polinom();
        A = op.citestePolinom(p1.getText());
        Polinom rez = new Polinom();
        rez = op.integrala(A);
        rezultat.setText(rez.toString());
    }

    public void clear(ActionEvent e){
        rezultat.setText("");
    }

        public static void main(String[] args) {
            View v = new View();
        }
}
