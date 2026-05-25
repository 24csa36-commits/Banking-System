import java.util.*;
class BankController{
    List<Account> list=new ArrayList<>();
    String createAccount(int id,String name,double amount)
    {
        for(int i=0;i<list.size();i++ ){
        if(list.get(i).getId()==id)
        return "Account already excists!!";
        }
        Account a=new Account(id,name,amount);
        list.add(a);
        return "Account created successfully!!";
    }
    String deposit(int id,double amount)
    {
        if(amount<=0)
           return "Invalid amount!!";
       for(int i=0;i<list.size();i++ ){
        if(list.get(i).getId()==id){
            double bal=list.get(i).getBalance();
            bal+=amount;
            list.get(i).setBalance(bal);
            return "Amount deposited successfully!!";
        }
        }
        return "Account is not available ...first create the account!!";
           
    }
    String Withdraw(int id,double amount)
    {
        if(amount<=0)
        return "Invalid amount!!";
       for(int i=0;i<list.size();i++ ){
        if(list.get(i).getId()==id){
            double bal=list.get(i).getBalance();
            if(bal>=amount){
            bal-=amount;
            list.get(i).setBalance(bal);
            return "Amount withdrawn successfully!!";
            }
            else
            return "Amount not sufficient!!";
        }
        }
        return "Account is not available ...first create the account!!";
           
    }
    double CheckBalance(int id)
    {
        for(int i=0;i<list.size();i++ ){
        if(list.get(i).getId()==id){
            double bal=list.get(i).getBalance();
            return bal;
        }
        }
        return 0;
           
    }
    void Search(int id)
    {
        for(int i=0;i<list.size();i++ ){
        if(list.get(i).getId()==id){
            System.out.println("Account details :");
            System.out.println("Account id :"+list.get(i).getId() );
            System.out.println("User name :"+list.get(i).getName() );
            System.out.println("Account balance :"+ list.get(i).getBalance());
            return ;
        }
        }
        System.out.println("Account not found with that id "+ id);
           
    }
    String deleteAccount(int id)
    {
        for(int i=0;i<list.size();i++ ){
        if(list.get(i).getId()==id){
            list.remove(i);
            return "Account deleted successfully!!!" ;
            
        }
        }
        return "Account not found with that id "+ id;
        
    }
    void displayAll(){
        if(list.size()==0)
       {
        System.out.println("No accounts found!!");
        return;
        }
        for(int i=0;i<list.size();i++ ){
            System.out.println("Account details :"+i);
            System.out.println("Account id :"+list.get(i).getId() );
            System.out.println("User name :"+list.get(i).getName() );
            System.out.println("Account balance :"+list.get(i).getBalance() );
        }
    }

}