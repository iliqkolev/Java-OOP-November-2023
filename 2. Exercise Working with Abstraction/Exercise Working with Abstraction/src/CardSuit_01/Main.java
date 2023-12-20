package CardSuit_01;

public class Main {
    public static void main(String[] args) {
        CardSuits[] cardSuits = CardSuits.values();
        System.out.println("Card Suits:");
        for (CardSuits cards : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", cards.ordinal(), cards.name());
        }
    }
}
