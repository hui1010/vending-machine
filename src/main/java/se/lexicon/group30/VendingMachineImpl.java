package se.lexicon.group30;

import java.util.Arrays;

public class VendingMachineImpl implements VendingMachine {
    Product[] products = new Product[0];
    int balance = 0;

    public VendingMachineImpl() {
    }

    public VendingMachineImpl(Product[] products) {
        this.products = products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean addProducts (Product toAdd){
        /*if (productExists(products, toAdd)){
            return false;
        }*/
        products = add(products, toAdd);
        return true;
    }

    /*private boolean productExists(Product[] source, Product toAdd) {
        for (int i = 0; i < source.length; i++) {

        }
    }*/

    private Product[] add(Product[] source, Product toAdd) {
        Product[] added = Arrays.copyOf(source, source.length + 1);
        added[added.length - 1] = toAdd;
        return added;
    }

    @Override
    public void addCurrency(int amount) {

        balance += amount;
        setBalance(balance);
    }

    @Override
    public Product request(int productNumber) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == productNumber && products[i].getPrice() <= balance){
                balance-= products[i].getPrice();
                return products[i];
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        return balance;
    }

    @Override
    public String getDescription(int productionNumber) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == productionNumber) {
                return products[i].getDescription();
            }
        }
        return null;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public String[] getProducts() {
        String[] allProducts= new String[0];
        String str = new String();
        for (int i = 0; i < products.length; i++) {
            str = str.concat(products[i].getProductId() + ": " + products[i].getName());
            allProducts = Arrays.copyOf(allProducts, allProducts.length + 1);
            allProducts[allProducts.length - 1] = str;
            str = "";
        }
        return allProducts;
    }


}
