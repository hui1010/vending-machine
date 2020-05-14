package se.lexicon.group30;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        VendingMachineImpl impl = new VendingMachineImpl();
        Product cola = new Drinks("cola", 20, "zero sugar", 215, true);
        Product latte = new Drinks ("latte", 25, "warm" , 150, false);
        impl.addProducts(cola);
        impl.addProducts(latte);

        System.out.println("Welcome to vending machine, money in!");

        MoneyInput[] money = MoneyInput.values();
        for (int i = 0; i < money.length; i++) {
            System.out.print(money[i].getValue() + "kr" + " ");
        }

        boolean validMoney = false;
        while(!validMoney){
            int deposit =scanner.nextInt();
            for (int i = 0; i < money.length; i++) {
                if (deposit == money[i].getValue()){
                    impl.addCurrency(deposit);
                    System.out.println("Your balance is: " + impl.getBalance() + "kr.");
                    validMoney = true;
                    break;
                }
            }
        }

        System.out.println("Choose a product to buy");
        for (int i = 0; i < impl.getProducts().length; i++){
            System.out.println(impl.getProducts()[i]);
        }


    }


}
