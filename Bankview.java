import java.util.*;

class Bankview
{
    Scanner sc = new Scanner(System.in);
    void showMenu()
    {
        System.out.println("\n===== BANK MENU =====");

        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Delete Account");
        System.out.println("6. Display All Accounts");
        System.out.println("7. Exit");

        System.out.print("Enter your choice: ");
    }

    int getId()
    {
        System.out.print("Enter Account ID: ");
        return sc.nextInt();
    }

    String getName()
    {
        sc.nextLine();
        System.out.print("Enter Name: ");
        return sc.nextLine();
    }

    double getAmount()
    {
        System.out.print("Enter Amount: ");
        return sc.nextDouble();
    }

    void displayMessage(String msg)
    {
        System.out.println(msg);
    }

   
}