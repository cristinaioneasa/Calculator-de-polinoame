import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Polinom {
    private ArrayList<Monom> polinom;

    public Polinom() {
        polinom = new ArrayList<Monom>();
    }

    public ArrayList<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(ArrayList<Monom> polinom) {
        this.polinom = polinom;
    }

    @Override
    public String toString() {
        String sir = "";
        for(int i=0; i< polinom.size(); i++)
            sir += polinom.get(i).toString();
        return sir;
    }
}
