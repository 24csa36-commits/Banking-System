class Account{
    private int accId;
    private String name;
    private double balance;
    public Account (int accId,String name ,double balance)
    {
        this.accId=accId;
        this.name = name;
        this.balance = balance;
    }
    public int getId(){ return accId;}
    public String getName(){ return name;}
    public double getBalance(){ return balance;}
    public void setBalance(double balance){ this.balance = balance;}
}