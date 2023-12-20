package CardsWithPower_03;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;

    public Card(CardSuits cardSuit, CardRanks cardRank){
        //новва празна карта
        // cardSuit = null;
        // cardRank = null;
        this.cardSuit=cardSuit;
        this.cardRank=cardRank;
    }

    public int calculatePower(){
        return this.cardSuit.getValue() + this.cardRank.getValue();
    }
}
