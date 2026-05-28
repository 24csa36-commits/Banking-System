package view;

import java.util.*;

public class BankView{

    public Scanner sc=new Scanner(System.in);
    public void showMainMenu()
{
    System.out.println("\n===== BANK SYSTEM =====");

    System.out.println("1.Customer");

    System.out.println("2.Admin");

    System.out.println("3.Exit");

    System.out.print("Enter choice : ");
}

    public void showCustomerMenu()
{
    System.out.println("\n===== CUSTOMER MENU =====");

    System.out.println("1.Register");

    System.out.println("2.Login");

    System.out.println("3.Deposit");

    System.out.println("4.Withdraw");

    System.out.println("5.Check Balance");

    System.out.println("6.Logout");

    System.out.println("7.Back");

    System.out.print("Enter choice : ");
}
public void showAdminMenu()
{
    System.out.println("\n===== ADMIN MENU =====");

    System.out.println("1.Admin Login");

    System.out.println("2.Search Account");

    System.out.println("3.Display All Accounts");

    System.out.println("4.Delete Account");

    System.out.println("5.Logout");

    System.out.println("6.Back");

    System.out.print("Enter choice : ");
}

    public String getName()
    {
        sc.nextLine();

        System.out.print("Enter Name : ");

        return sc.nextLine();
    }

    public String getAadhaar()
{
    while(true)
    {
        System.out.print(
        "Enter Aadhaar : "
        );

        String aadhaar=
        sc.nextLine();

        if(aadhaar.matches("\\d{12}"))
        {
            return aadhaar;
        }

        System.out.println(
        "Aadhaar must contain exactly 12 digits!!"
        );
    }
}
    public String getEmail()
{
    while(true)
    {
        System.out.print(
        "Enter Email : "
        );

        String email=
        sc.nextLine();

        if(email.matches(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        ))
        {
            return email;
        }

        System.out.println(
        "Invalid email format!!"
        );
    }
}

    public String getPassword()
{
    while(true)
    {
        System.out.print(
        "Enter Password : "
        );

        String password=
        sc.nextLine();

        if(password.matches(
        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$"
        ))
        {
            return password;
        }

        System.out.println(
        "Weak password!!"
        );

        System.out.println(
        "Use uppercase, lowercase, number, special character and minimum 8 characters."
        );
    }
}

    public double getAmount()
    {
        System.out.print("Enter Amount : ");

        return Double.parseDouble(sc.nextLine());
    }

    public int getAccNo()
    {
        System.out.print("Enter Account Number : ");
        return Integer.parseInt(sc.nextLine());
    }
    public String getPhone()
{
    while(true)
    {
        System.out.print(
        "Enter Phone Number : "
        );

        String phone=
        sc.nextLine();

        if(phone.matches("\\d{10}"))
        {
            return phone;
        }

        System.out.println(
        "Invalid phone number!! Enter exactly 10 digits."
        );
    }
}
    public void displayMessage(String msg)
    {
        System.out.println(msg);
    }
}