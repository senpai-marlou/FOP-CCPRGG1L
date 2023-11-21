package Project;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class transactionHistory {

    static ArrayList<String> THdate = new ArrayList<>();

    static ArrayList<String> THname = new ArrayList<>();

    static ArrayList<Double> THprice = new ArrayList<>();

    static ArrayList<Integer> THqty = new ArrayList<>();

    static ArrayList<Double> THconsPayment = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void addTranscationHistory(String date, String name, double price, int qty, double consPayment) {

        THdate.add(date);
        THname.add(name);
        THprice.add(price);
        THqty.add(qty);
        THconsPayment.add(consPayment);
    }

    public static void displayTransactionHistory() {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Transaction history....");
        System.out.println("Date\tName\tprice\tqty\tconsumer payment\n");
        for (int i = 0; i < THdate.size(); i++) {
            System.out.println(THdate.get(i)+"\t"+THname.get(i)+"\tP"+THprice.get(i)+"\t"+THqty.get(i)+"\t"+THconsPayment.get(i));
        }
        System.out.println();
        Project.adminInterface();
    }

    public static double userChangeRecord(int productIdx) {
        Scanner sc = new Scanner(System.in);
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/y");

        String date = ""; String productName = ""; double productPrice = 0; int qty = 0; double userInputAmt = 0;
        double outputChange = 0; double outputTotal = 0;

        date = String.valueOf(dateForm.format(thisDate));

        System.out.println("Quantity: ");
        int userInputQty = sc.nextInt();

        System.out.println("Money: ");
        userInputAmt = sc.nextDouble();

        for (int i = 0; i < GroceryStorage.pName.size(); i++) {
            if (productIdx == i + 1) {
                productName = GroceryStorage.pName.get(i);
                productPrice = GroceryStorage.pPrice.get(i);
                qty = GroceryStorage.pQuantity.get(i);
                if (userInputQty > qty) {
                    System.out.println("Not enough stock.");
                    System.out.println("Please try again...");
                    Project.consumerInterface();
                }
                outputTotal = total(userInputQty, productPrice);

                if (outputTotal > userInputAmt) {
                    System.out.println("Money amount not sufficient.");
                    Project.consumerInterface();
                }

                GroceryStorage.pQuantity.set(i, qty - userInputQty);

                outputChange = userInputAmt - outputTotal;
                addTranscationHistory(date, productName, productPrice, userInputQty, userInputAmt);
                break;
            }
        }
        return outputChange;
    }

    private static double total(int qty, double price) {

        return (double) qty * price;
    }
}
