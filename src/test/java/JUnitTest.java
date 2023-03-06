import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JUnitTest {
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;
    private static Operatii op ;

    public String polinomToString(Polinom A){
        String sir = "";
        for(int i=0; i< A.getPolinom().size(); i++)
            sir += A.getPolinom().get(i).toString();
        return sir;
    }
    public JUnitTest() {
        System.out.println("Constructor inaintea fiecarui test!");
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("O singura data inaintea executiei setului de teste din clasa!");

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("O singura data dupa terminarea executiei setului de teste din clasa!");
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
    }

    @Test
    public void testAdunare() {
        op = new Operatii();
        Polinom A = new Polinom();
        Polinom B = new Polinom();
        Polinom C;

        Monom m1 = new Monom(1, 3);
        Monom m2 = new Monom(2, 2);
        Monom m3 = new Monom(5, 1);
        Monom m4 = new Monom(1, 0);
        Monom m5 = new Monom(4, 0);

        A.getPolinom().add(m1);
        A.getPolinom().add(m3);
        A.getPolinom().add(m4);
        B.getPolinom().add(m2);
        B.getPolinom().add(m3);
        B.getPolinom().add(m5);
        C = op.adunare(A, B);
        assertEquals(polinomToString(C), "+10.0x^1+5.0+x^3+2.0x^2");
        nrTesteCuSucces ++;
    }

    @Test
    public void testScadere() {
        op = new Operatii();
        Polinom A = new Polinom();
        Polinom B = new Polinom();
        Polinom C;

        Monom m1 = new Monom(1, 3);
        Monom m2 = new Monom(2, 2);
        Monom m3 = new Monom(5, 1);
        Monom m4 = new Monom(1, 0);
        Monom m5 = new Monom(4, 0);

        A.getPolinom().add(m1);
        A.getPolinom().add(m3);
        A.getPolinom().add(m4);
        B.getPolinom().add(m2);
        B.getPolinom().add(m3);
        B.getPolinom().add(m5);
        C = op.scadere(A, B);
        assertEquals(polinomToString(C), "-3.0+x^3-2.0x^2");
        nrTesteCuSucces ++;
    }

    @Test
    public void testInmultire() {
        op = new Operatii();
        Polinom A = new Polinom();
        Polinom B = new Polinom();
        Polinom C;

        Monom m2 = new Monom(2, 2);
        Monom m3 = new Monom(5, 1);
        Monom m4 = new Monom(1, 0);
        Monom m5 = new Monom(4, 0);

        A.getPolinom().add(m3);
        A.getPolinom().add(m4);
        B.getPolinom().add(m2);
        B.getPolinom().add(m3);
        B.getPolinom().add(m5);
        C = op.inmultire(A, B);
        assertEquals(polinomToString(C), "+10.0x^3+27.0x^2+25.0x^1+4.0");
        nrTesteCuSucces ++;
    }

    @Test
    public void testDerivata() {
        op = new Operatii();
        Polinom A = new Polinom();
        Polinom C;

        Monom m2 = new Monom(2, 2);
        Monom m3 = new Monom(5, 1);

        A.getPolinom().add(m2);
        A.getPolinom().add(m3);
        C = op.derivata(A);

        assertEquals(polinomToString(C), "+4.0x^1+5.0");
        nrTesteCuSucces ++;
    }

    @Test
    public void testIntegrala() {
        op = new Operatii();
        Polinom A = new Polinom();
        Polinom C;

        Monom m2 = new Monom(6, 2);
        Monom m3 = new Monom(2, 0);

        A.getPolinom().add(m2);
        A.getPolinom().add(m3);
        C = op.integrala(A);

        assertEquals(polinomToString(C), "+2.0x^3+2.0x^1");
        nrTesteCuSucces ++;
    }
}