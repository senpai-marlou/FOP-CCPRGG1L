package Project;

import java.util.Scanner;

public class Project {

    public static void main(String[] args) {
        groceryAcc();

    }

    public static void groceryAcc() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Running system....");
        System.out.println("[1] Create an account");
        System.out.println("[2] Log-in");
        String inputAccPath = sc.next();

        if (inputAccPath.equals("1")) {
            credentialsInfo.createAccount();
        }

        else if (inputAccPath.equals("2")) {
            credentialsInfo.loginAccount();
        }

        else {
            System.out.println("Input Error.");
            groceryAcc();
        }

    }

    public static void consumerInterface() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Available products are the following...");
        GroceryStorage.displayItems();

        String endExitIdx = String.valueOf(GroceryStorage.pName.size()+1);
        System.out.println("["+(endExitIdx)+"]"+" to exit...");

        System.out.println("Do you want to purchase something? ");
        String userInput = sc.next();

        if (userInput.equals(endExitIdx)) {
            groceryAcc();
        }

        else if (Integer.parseInt(userInput) > Integer.parseInt(endExitIdx) || Integer.parseInt(userInput) <= 0) {
            System.out.println("INPUT ERROR: Product index doesn't exist.");
            consumerInterface();
        }

        else if (Integer.parseInt(userInput) < Integer.parseInt(endExitIdx) && Integer.parseInt(userInput) > 0) {
            consInterfaceBuy.CIBuy(userInput);
        }
        else {
            System.out.println("INPUT ERROR: Inappropriate input.");
            consumerInterface();
        }
    }

    public static void adminInterface() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[1] Maintenance");
        System.out.println("[2] Display transactions");
        System.out.println("[3] to exit...");

        String aInterface = sc.next();

        if (aInterface.equals("1")) {
            adminInterfaceMaintenance();
        }

        else if (aInterface.equals("2")) {
            adminInterfaceDisplayT();
        }

        else if (aInterface.equals("3")) {
            groceryAcc();
        }

        else {
            System.out.println("Input Error.");
            adminInterface();
        }
    }
    public static void adminInterfaceDisplayT() {

        transactionHistory.displayTransactionHistory();
    }
    public static void adminInterfaceMaintenance() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Maintenance on going...");
        System.out.println("[1] Display");
        System.out.println("[2] Add");
        System.out.println("[3] Edit");
        System.out.println("[4] Delete");
        System.out.println("[5] to exit...");

        String userInput = sc.next();

        if (userInput.equals("1")) {
            GroceryStorage.displayItems();
            adminInterfaceMaintenance();
        }

        else if (userInput.equals("2")) {
            GroceryStorage.addItem();
            adminInterfaceMaintenance();
        }

        else if (userInput.equals("3")) {
            System.out.println("Editing Products...");
            GroceryStorage.displayItems();
            GroceryStorage.editItem();
        }

        else if (userInput.equals("4")) {
            GroceryStorage.deleteItem();
        }

        else if (userInput.equals("5")) {
            adminInterface();
        }

        else {
            System.out.println("Input Error.");
            adminInterfaceMaintenance();
        }
    }


}
