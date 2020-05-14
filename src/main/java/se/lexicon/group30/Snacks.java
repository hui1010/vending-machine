package se.lexicon.group30;

import java.util.Objects;

public class Snacks extends Product{
    private int weight;
    private int calorie;

    public Snacks(String name, int price, String description, int weight, int calorie) {
        super(name, price, description);
        this.weight = weight;
        this.calorie = calorie;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public Snacks(String name, int price, String description) {
        super(name, price, description);
    }

    @Override
    public String toString() {
        return "Snacks{" +
                "weight=" + weight +
                ", calorie=" + calorie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Snacks snacks = (Snacks) o;
        return weight == snacks.weight &&
                calorie == snacks.calorie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight, calorie);
    }

    @Override
    String examine() {
       return getName() + " is " + getWeight() + " g, " + getCalorie() + " Kcal and costs " + getPrice() + " kr.";
    }

    @Override
    String use() {
        return "You can take your " + getName() + ", don't forget the change.";
    }
}
