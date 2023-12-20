package CardsWithPower_03;

public enum CardSuits {
    CLUBS(0), // спатия
    DIAMONDS(13), // каро
    HEARTS(26), // купа
    SPADES(39); // пика

    private int value;

    CardSuits(int value) {
        this.value = value;
    }

    public int getValue () {
        return value;
    }
}
