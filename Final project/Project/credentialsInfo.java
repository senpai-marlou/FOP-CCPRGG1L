package Project;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class credentialsInfo {

    static ArrayList<String> listUsername = new ArrayList<>();
    static ArrayList<String> listPassword = new ArrayList<>();
    static ArrayList<String> listType = new ArrayList<>();

    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating an account: ");

        String inputCAUsername = usernameChecker.username(); //rodney

        String inputCAPassword = passwordChecker.password(); //12345

        String inputCAType = typeChecker.type(); //admin

        listUsername.add(inputCAUsername);
        listPassword.add(inputCAPassword);
        listType.add(inputCAType);
        System.out.println("Creating account.... Done!");

        Project.groceryAcc();
    }

    public static void loginAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Account....");

        System.out.println("Username: ");    // idx: 0   rod   12345   admin
        String inputLAUsername = sc.next();

        System.out.println("Password: ");
        String inputLAPassword = sc.next();

        int accCount = 0;
        int idx = 0;
        for (int i = 0; i < listUsername.size(); i++) { // [rod,lei,estrada, paul, philip, marlou, Paul]
            String tempUsername = listUsername.get(i); //    0   1    2         3   4      5

            if (tempUsername.equals(inputLAUsername)) {
                accCount++;
                idx = i;
                break;
            }
        }
        if (accCount != 1) {
            System.out.println("Account doesn't exist");
            Project.groceryAcc();
        }
        String LAUsername = listUsername.get(idx);
        String LAPassword = listPassword.get(idx);
        String LAType = listType.get(idx);

        if (!Objects.equals(inputLAPassword, LAPassword)) {  // !inputLAPassword.equals(LAPassword)
            System.out.println("Wrong password.");
            Project.groceryAcc();
        }

        if (LAType.equals("admin")) {
            System.out.println(""+"Welcome admin "+LAUsername+"....");
            Project.adminInterface();
        }
        else if (LAType.equals("consumer")) {
            System.out.println(""+"Welcome "+LAUsername+"....");
            Project.consumerInterface();
        }
    }
}
