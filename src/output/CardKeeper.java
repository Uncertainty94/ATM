package output;

import model.Card;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class CardKeeper {

    Set<Card> cards = new HashSet<>();

    public void addCard(Card c){
        cards.add(c);
        System.out.println("Card in CardKeeper");
    }
}
