import controller.BankController;

import view.BankView;

public class Main{

    public static void main(String[] args){

        BankController controller=
        new BankController();

        BankView view=
        new BankView();

        while(true)
        {
            view.showMainMenu();

            int role=
            Integer.parseInt(
            view.sc.nextLine()
            );

            switch(role)
            {
                case 1:

                    customerMenu(
                    controller,
                    view
                    );

                    break;

                case 2:

                    adminMenu(
                    controller,
                    view
                    );

                    break;

                case 3:

                    System.out.println(
                    "Thank You!!"
                    );

                    System.exit(0);

                default:

                    System.out.println(
                    "Invalid Choice!!"
                    );
            }
        }
    }

    public static void customerMenu(
        BankController controller,
        BankView view)
    {
        while(true)
        {
            view.showCustomerMenu();

            int choice=
            Integer.parseInt(
            view.sc.nextLine()
            );

            String msg="";

            switch(choice)
            {
                case 1:

                    String name=
                    view.getName();

                    String aadhaar=
                    view.getAadhaar();

                    String email=
                    view.getEmail();

                    String phone=
                    view.getPhone();

                    String password=
                    view.getPassword();

                    double balance=
                    view.getAmount();

                    msg=controller.register(
                        name,
                        aadhaar,
                        phone,
                        email,
                        password,
                        balance
                    );

                    view.displayMessage(msg);

                    break;

                case 2:

                    email=
                    view.getEmail();

                    password=
                    view.getPassword();

                    msg=controller.login(
                        email,
                        password
                    );

                    view.displayMessage(msg);

                    break;

                case 3:

                    balance=
                    view.getAmount();

                    msg=
                    controller.deposit(balance);

                    view.displayMessage(msg);

                    break;

                case 4:

                    balance=
                    view.getAmount();

                    msg=
                    controller.withdraw(balance);

                    view.displayMessage(msg);

                    break;

                case 5:

                    double bal=
                    controller.checkBalance();

                    if(bal==-1)
                    {
                        System.out.println(
                        "Please login first!!"
                        );
                    }
                    else
                    {
                        System.out.println(
                        "Balance : "+bal
                        );
                    }

                    break;

                case 6:

                    msg=
                    controller.logout();

                    view.displayMessage(msg);

                    break;

                case 7:

                    return;

                default:

                    System.out.println(
                    "Invalid Choice!!"
                    );
            }
        }
    }

    public static void adminMenu(
        BankController controller,
        BankView view)
    {
        while(true)
        {
            view.showAdminMenu();

            int choice=
            Integer.parseInt(
            view.sc.nextLine()
            );

            String msg="";

            switch(choice)
            {
                case 1:

                    String email=
                    view.getEmail();

                    String password=
                    view.getPassword();

                    msg=
                    controller.adminLogin(
                        email,
                        password
                    );

                    view.displayMessage(msg);

                    break;

                case 2:

                    int accNo=
                    view.getAccNo();

                    controller.searchAccount(
                        accNo
                    );

                    break;

                case 3:

                    controller.displayAllAccounts();

                    break;

                case 4:

                    accNo=
                    view.getAccNo();

                    msg=
                    controller.deleteAccount(
                        accNo
                    );

                    view.displayMessage(msg);

                    break;

                case 5:

                    msg=
                    controller.adminLogout();

                    view.displayMessage(msg);

                    break;

                case 6:

                    return;

                default:

                    System.out.println(
                    "Invalid Choice!!"
                    );
            }
        }
    }
}