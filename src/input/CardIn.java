package input;

import model.Card;

/**
 * Created by mmishanin on 11.03.2016.
 */
public class CardIn {
    public Card card;

    public void getCard(Card inputCard){
        card = inputCard;
        System.out.println("Card taken");

    }
    public Card giveCard(){
        System.out.println("Card given");
        return card;
    }

    public Card giveCardToCardKeeper(){
        System.out.println("Card given to card keeper");
        return card;
    }
    public boolean checkCard(){
        if (card.number > 0000000000000000l && card.number < 9999999999999999l) {
            System.out.println("Card valid\nName: " + card.name + "\nNumber: " + card.number);
            return true;
        }
        System.out.println("Card invalid");
        return false;
    }
}
