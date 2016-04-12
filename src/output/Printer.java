package output;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by mmishanin on 11.03.2016.
 */
public class Printer {

    public void writeCheque(int cash, double balance) throws ParseException {
        long curTime = System.currentTimeMillis();
        String curStringDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(curTime);

        System.out.println("********CHEQUE**********");
        System.out.println("GIVEN: "+cash+" rub.");
        System.out.println("BALANCE: "+balance+" rub.");
        System.out.println("TRANSACTION TIME: " + curStringDate);
        System.out.println("************************\n");
    }
}
