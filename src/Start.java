import model.Card;
import model.MainSystem;

import java.io.IOException;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class Start {
    public static void main(String[] args) throws IOException {
        MainSystem mainSystem = new MainSystem();
        Card bankCard = new Card("Mishanin", 2014999900001234l);
        Card bankCard2 = new Card("Mishanin", 12014999900001234l);
        mainSystem.loopSystem(bankCard);
    }
}
