package se.lexicon.group30;

import java.util.Objects;

public abstract class Product {
    private static int idCounter = 0;
    private String name;
    private int price;
    private String description;
    private int productId;

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productId = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", productId=" + productId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                productId == product.productId &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, productId);
    }

    abstract String examine();
    abstract String use();

    public static void reset(){
        idCounter = 0;
    }

}
