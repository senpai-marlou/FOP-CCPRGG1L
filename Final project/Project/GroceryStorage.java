package Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class GroceryStorage {

    static ArrayList<String> pName = new ArrayList<>();
    static ArrayList<String> pDescription = new ArrayList<>();
    static ArrayList<Double> pPrice = new ArrayList<>();
    static ArrayList<Integer> pQuantity = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void addItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adding products...");

        System.out.println("Product name: ");
        String newPN = sc.nextLine();
        pName.add(newPN);

        System.out.println("Description: ");
        String newD = sc.nextLine();
        pDescription.add(newD);

        System.out.println("Price: ");
        double newP = sc.nextDouble();
        pPrice.add(newP);
//        if (newP >= 0) {
//        	pPrice.add(newP);
//        } else {
//        	System.out.println("Invalid Input");
//        }

        System.out.println("Quantity: ");
        int newQ = sc.nextInt();
        pQuantity.add(newQ);
//      if (newQ >= 0) {
//    	pQuantity.add(newQ);
//    } else {
//    	System.out.println("Invalid Input");
//    }

    }

    public static void displayItems() {
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 1; i <= pName.size(); i++) { // 2
            String productName = pName.get(i - 1); // 1
            String productDescription = pDescription.get(i - 1); // 1
            double productPrice = pPrice.get(i - 1);
            int productQuantity = pQuantity.get(i - 1);
            System.out.println(""+"["+i+"] "+productName+" - "+productDescription+" - "+"P"+df.format(productPrice)+" - "+productQuantity+" items");
        }
    }

    public static void editItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What to edit? ");
        int inputProductIdx = sc.nextInt(); // 3

        System.out.println("Editing products...");
        System.out.println("[1] product name");
        System.out.println("[2] description");
        System.out.println("[3] price");
        System.out.println("[4] quantity");
        System.out.println("[5] to exit");
        System.out.println("What to change? ");
        String editUserInput = sc.next();

        if (editUserInput.equals("1")) {
            int idxProduct = inputProductIdx - 1; // 2
            if (idxProduct > pName.size() - 1 || idxProduct < 0) {
                System.out.println("Index Product Error.");
                editItem();
            }
            String oldInfo = pName.get(idxProduct);
            System.out.println(""+"old name: "+oldInfo);
            System.out.println("input new name: ");
            String newInfo = sc.next();

            pName.set(idxProduct, newInfo);
            Project.adminInterfaceMaintenance();
        }

        else if (editUserInput.equals("2")) {
            int idxProduct = inputProductIdx - 1;
            if (idxProduct > pDescription.size() - 1 || idxProduct < 0) {
                System.out.println("Index Product Error.");
                editItem();
            }
            String oldInfo = pDescription.get(idxProduct);
            System.out.println(""+"old description: "+oldInfo);
            System.out.println("input new description: ");
            String newInfo = sc.next();

            pDescription.set(idxProduct, newInfo);
            Project.adminInterfaceMaintenance();
        }

        else if (editUserInput.equals("3")) {
            int idxProduct = inputProductIdx - 1;
            if (idxProduct > pPrice.size() - 1 || idxProduct < 0) {
                System.out.println("Index Product Error.");
                editItem();
            }
            double oldInfo = pPrice.get(idxProduct);
            System.out.println(""+"old price(P): "+oldInfo);
            System.out.println("input new price(P): ");
            double newInfo = sc.nextDouble();

            pPrice.set(idxProduct, newInfo);
            Project.adminInterfaceMaintenance();
        }

        else if (editUserInput.equals("4")) {
            int idxProduct = inputProductIdx - 1;
            if (idxProduct > pQuantity.size() - 1 || idxProduct < 0) {
                System.out.println("Index Product Error.");
                editItem();
            }
            int oldInfo = pQuantity.get(idxProduct);
            System.out.println(""+"old quantity: "+oldInfo);
            System.out.println("input new quantity: ");
            int newInfo = sc.nextInt();

            pQuantity.set(idxProduct, newInfo);
            Project.adminInterfaceMaintenance();
        }

        else if (editUserInput.equals("5")) {
            Project.adminInterface();
        }

        else {
            System.out.println("Input Error.");
            Project.adminInterfaceMaintenance();
        }
    }

    public static void deleteItem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deleting products...");
        displayItems();

        System.out.println("What to delete? ");
        int deleteUserInput = sc.nextInt()-1;

        if (deleteUserInput > pName.size() - 1 || deleteUserInput < 0) {
            System.out.println("Index Error: Can't find.");
            deleteItem();
        }
        /*
        * [jyre,marlou, philip]
        *   0    1     2       3
        * pName.remove(1)
        *
        * */
        pName.remove(deleteUserInput);
        pDescription.remove(deleteUserInput);
        pPrice.remove(deleteUserInput);
        pQuantity.remove(deleteUserInput);

        Project.adminInterfaceMaintenance();
    }


}
