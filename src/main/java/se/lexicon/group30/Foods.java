package se.lexicon.group30;

import java.util.Objects;

public class Foods extends Product {
    private boolean meat;
    private boolean nuts;
    private int weight;

    public Foods(String name, int price, String description, boolean meat, boolean nuts, int weight) {
        super(name, price, description);
        this.meat = meat;
        this.nuts = nuts;
        this.weight = weight;
    }

    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isNuts() {
        return nuts;
    }

    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        if (isMeat() && isNuts()){
            return "Foods{" +
                    "meat= yes"  +
                    ", nuts= yes" +
                    ", weight=" + weight +
                    " g}";
        }else if (!isMeat() && isNuts()){
            return "Foods{" +
                    "meat= no" +
                    ", nuts= yes" + nuts +
                    ", weight=" + weight + " g}";
        }else if (isMeat() && !isNuts()){
            return "Foods{" +
                    "meat= yes" +
                    ", nuts= no" + nuts +
                    ", weight=" + weight + " g}";
        }else{
            return "Foods{" +
                    "meat= no" +
                    ", nuts= no" + nuts +
                    ", weight=" + weight + " g}";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Foods foods = (Foods) o;
        return meat == foods.meat &&
                nuts == foods.nuts &&
                weight == foods.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), meat, nuts, weight);
    }

    @Override
    String examine() {
        if (isMeat() && isNuts()){
            return getName() + " is " + getWeight() + " g, contains meat and nuts, and costs " + getPrice() + " kr.";
        } else if (!isMeat() && isNuts()){
            return getName() + " is " + getWeight() + " g, contains nuts and no meat, and costs " + getPrice() + " kr.";
        } else if (isMeat() && !isNuts()){
            return getName() + " is " + getWeight() + " g, contains meat and no nuts, and costs " + getPrice() + " kr.";
        } else{
            return getName() + " is " + getWeight() + " g, contains no meat and no nuts, and costs " + getPrice() + " kr.";
        }

    }

    @Override
    String use() {
        return "You can take your " + getName() + ", don't forget the change";
    }
}
