package output;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class CashOut {

    boolean state;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void giveCash(double cash){
        System.out.println("Cash given: "+ cash);
    }
}
