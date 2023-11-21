package Project;

import java.util.Scanner;
import java.text.DecimalFormat;

public class consInterfaceBuy {

    public static void main(String[] args) {

    }

    public static void CIBuy(String productIDX) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner sc = new Scanner(System.in);

        int productIDXint = Integer.parseInt(productIDX);

        double change = transactionHistory.userChangeRecord(productIDXint);

        System.out.println("Successful, your change is P"+df.format(change));
        Project.consumerInterface();

    }
}