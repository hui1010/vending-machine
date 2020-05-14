package se.lexicon.group30;

public interface VendingMachine {
    void addCurrency (int amount);
    Product request (int productNumber);
    int endSession ();
    String getDescription(int productionNumber);
    int getBalance();
    String[] getProducts();
}
