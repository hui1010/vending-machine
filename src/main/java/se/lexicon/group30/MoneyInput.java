package se.lexicon.group30;

public enum MoneyInput {
    ONE_SEK(1),
    TWO_SEK(2),
    FIVE_SEK(5),
    TEN_SEK(10),
    TWENTY_SEK(20),
    FIFTY_SEK(50),
    ONE_HUNDRED_SEK(100),
    TWO_HUNDRED_SEK(200),
    FIVE_HUNDRED_SEK(500),
    ONE_THOUSAND_SEK(1000);

    private int value;

    MoneyInput(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
