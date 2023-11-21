package Project;

import java.util.Scanner;

public class usernameChecker {

    public static String username() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username: ");
        String inputCAUsername = sc.next();

        for (int i = 0; i < credentialsInfo.listUsername.size(); i++){
            String tempPassword = credentialsInfo.listUsername.get(i);

            if (tempPassword.equals(inputCAUsername)) {
                System.out.println("Username already used.");
                System.out.println("Account declined: Please try again");
                Project.groceryAcc();
            }
        }
        return inputCAUsername;
    }
}
