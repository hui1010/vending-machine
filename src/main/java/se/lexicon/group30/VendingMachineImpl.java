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


    public boolean addProducts (Product toAdd){ //todo check if the product already exists
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
    //add to the deposit pool
    public void addCurrency (int amount) {
        boolean moneyIsValid = false;
        MoneyInput[] values = MoneyInput.values();

            for (int i = 0; i < values.length; i++) {
                if (amount == values[i].getValue()){
                    moneyIsValid = true;
                }
            }
            if (moneyIsValid){
                balance += amount;
                setBalance(balance);
            }
    }


    @Override
    //buy a product
    public Product request(int productNumber) {
        boolean productExists = productExist(productNumber);
        boolean moneyIsEnough = moneyEnough(productNumber);
        if (productExists == true && moneyIsEnough == true){
            balance -= products[productNumber-1].getPrice(); // mind the difference between number and element's index
            setBalance(balance);
            return products[productNumber - 1];
        }else if (productExists == false && moneyIsEnough == true){
            System.out.println("Product doesn't exist");
            return null;
        }else if (productExists == true && moneyIsEnough == false){
            System.out.println("You don't have enough money");
            return null;
        }else
        return null;
    }

    private boolean moneyEnough(int productNumber) {
        boolean moneyIsEnough = false;

            if (products[productNumber - 1].getPrice() <= balance){
                moneyIsEnough = true;
            }
        return moneyIsEnough;
    }

    private boolean productExist(int productNUmber){
        boolean exists = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == productNUmber){

                exists = true;
            }
        }
        return exists;
    }

    @Override
    //returns change and resets the deposit pool
    public int endSession() {
        int change = balance;
        setBalance(0);
        return change;
    }

    @Override
    //view a product description
    public String getDescription(int productionNumber) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == productionNumber) {
                return products[i].getDescription();
            }
        }
        return null;
    }

    @Override
    //returns the deposit pool amount
    public int getBalance() {
        return balance;
    }

    @Override
    //return all Products' names and product numbers
    //not sure if this is the correct way to write
    public String[] getProducts() {
        String[] allProducts= new String[0];
        String str = new String();
        for (int i = 0; i < products.length; i++) {
            str = str.concat(products[i].getProductId() + ". " + products[i].getName());
            allProducts = Arrays.copyOf(allProducts, allProducts.length + 1);
            allProducts[allProducts.length - 1] = str;
            str = "";
        }
        return allProducts;
    }


}
