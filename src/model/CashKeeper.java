package model;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class CashKeeper {

    double cash = 4500;

    public double giveCash(double neededCash){
        if (cash > neededCash){
            cash -= neededCash;
            return neededCash;
        }
        return 0.0;
    }
}
