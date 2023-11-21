package Project;

import java.util.Scanner;

public class typeChecker {

    public static String type() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type: ");
        String inputCAType = sc.next().toLowerCase();

        if (inputCAType.equals("admin") || inputCAType.equals("consumer")) {
            return inputCAType;
        }
        System.out.println("Input Error (Type): [admin / consumer] only");
        System.out.println("Account declined: Please try again");
        Project.groceryAcc();
        return inputCAType;
    }
}