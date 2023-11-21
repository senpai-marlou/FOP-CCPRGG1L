package Project;

import java.util.Scanner;

public class passwordChecker {
    public static String password() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Password: ");
        String inputCAPassword = sc.next();

        if (inputCAPassword.length() < 4) {
            System.out.println("Password too weak...");
            System.out.println("Account declined: Please try again");
            Project.groceryAcc();
        }
        return inputCAPassword;
    }
}
