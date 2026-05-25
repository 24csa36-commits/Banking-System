import java.util.*;

public class Main{
    public static void main(String[] args){

        BankController controller=new BankController();
        Bankview view=new Bankview();
        Scanner sc=new Scanner(System.in);

        while(true){

            view.showMenu();
            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    int id=view.getId();
                    String name=view.getName();
                    double amount=view.getAmount();
                    String msg1=controller.createAccount(id,name,amount);
                    view.displayMessage(msg1);

                    break;

                case 2:

                    id=view.getId();
                    amount=view.getAmount();
                    String msg2=controller.deposit(id,amount);
                    view.displayMessage(msg2);
                    break;

                case 3:

                    id=view.getId();
                    amount=view.getAmount();
                    String msg3=controller.Withdraw(id,amount);
                    view.displayMessage(msg3);
                    break;

                case 4:

                    id=view.getId();
                    controller.Search(id);
                    break;

                case 5:

                    id=view.getId();
                    String msg4=controller.deleteAccount(id);
                    view.displayMessage(msg4);
                    break;

                case 6:
                    controller.displayAll();
                    break;

                case 7:
                    System.out.println("Thank You!!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!!");
            }
        }
    }
}