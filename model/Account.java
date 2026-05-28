package model;

public class Account{

    private int accNo;
    private String name;
    private String aadhaar;
    private String phone;
    private String email;
    private String password;
    private double balance;

    public Account(int accNo,String name,String aadhaar,String phone,String email,String password,double balance)
{
    this.accNo=accNo;
    this.name=name;
    this.aadhaar=aadhaar;
    this.phone=phone;
    this.email=email;
    this.password=password;
    this.balance=balance;
}

    public int getAccNo(){
        return accNo;
    }

    public String getName(){
        return name;
    }

    public String getAadhaar(){
        return aadhaar;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public double getBalance(){
        return balance;
    }
    public String getPhone(){
    return phone;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
}