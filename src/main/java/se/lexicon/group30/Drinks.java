package se.lexicon.group30;

import java.util.Objects;

public class Drinks extends Product {
    private int volume;
    private boolean bubbles;

    public Drinks(String name, int price, String description, int volume, boolean bubbles) {
        super(name, price, description);
        this.volume = volume;
        this.bubbles = bubbles;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isBubbles() {
        return bubbles;
    }

    public void setBubbles(boolean bubbles) {
        this.bubbles = bubbles;
    }

    @Override
    public String toString() {
        if (bubbles) {
            return "Drinks{" +
                    "volume=" + volume +
                    ", bubbles= yes" +
                    '}';
        }else{
            return "Drinks{" +
                    "volume=" + volume +
                    ", bubbles= no" +
                    '}';
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drinks drinks = (Drinks) o;
        return volume == drinks.volume &&
                bubbles == drinks.bubbles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume, bubbles);
    }

    @Override
    String examine() {
        return getName() + " is " + getVolume() + " ml and costs " + getPrice() + " kr.";
    }

    @Override
    String use() {
        return "You can take your " + getName() + ", don't forget the change.";
    }
}
