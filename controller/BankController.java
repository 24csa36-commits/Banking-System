package controller;

import java.sql.*;

import db.DBConnection;

import model.Account;
import model.Admin;

public class BankController{

    Connection con;

    Account currentUser=null;

    Admin currentAdmin=null;

    public BankController()
    {
        con=DBConnection.getConnection();
    }

    public String register(String name,
                           String aadhaar,
                           String phone,
                           String email,
                           String password,
                           double balance)
    {
        if(!phone.matches("\\d{10}"))
    {
        return
        "Phone number must contain exactly 10 digits!!";
    }
    if(!aadhaar.matches("\\d{12}"))
    {
        return
        "Aadhar number must contain exactly 12 digits!!";
    }
    if(!email.endsWith("@gmail.com"))
    {
    return "Invalid email format!!";
    }
    if(!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$"
))
    {
    return
    "Password must contain minimum 8 characters with uppercase, lowercase, number and special character!!";
    }
        try{

            String checkQuery=
            "select * from account where aadhaar=?";

            PreparedStatement checkPs=
            con.prepareStatement(checkQuery);

            checkPs.setString(1,aadhaar);

            ResultSet checkRs=
            checkPs.executeQuery();

            if(checkRs.next())
            {
                return "Account already exists!!";
            }

            String query=
            "insert into account(name,aadhaar,phone,email,password,balance) values(?,?,?,?,?,?)";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setString(1,name);
            ps.setString(2,aadhaar);
            ps.setString(3,phone);
            ps.setString(4,email);
            ps.setString(5,password);
            ps.setDouble(6,balance);

            int rows=ps.executeUpdate();

            if(rows>0)
            {
                return "Account created successfully!!";
            }
        }
        catch(Exception e){

            return e.toString();
        }

        return "Registration failed!!";
    }

    public String login(String email,
                        String password)
    {
        try{

            String query=
            "select * from account where email=? and password=?";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs=
            ps.executeQuery();

            if(rs.next())
            {
                currentUser=new Account(
                    rs.getInt("acc_no"),
                    rs.getString("name"),
                    rs.getString("aadhaar"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getDouble("balance")
                );

                return "Login successful!!";
            }
        }
        catch(Exception e){

            return e.toString();
        }

        return "Invalid email or password!!";
    }

    public String logout()
    {
        if(currentUser!=null)
        {
            currentUser=null;

            return "Logout successful!!";
        }

        return "No user logged in!!";
    }

    public String deposit(double amount)
    {
        if(currentUser==null)
        {
            return "Please login first!!";
        }

        try{

            String query=
            "update account set balance=balance+? where acc_no=?";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setDouble(1,amount);
            ps.setInt(2,currentUser.getAccNo());

            int rows=ps.executeUpdate();

            if(rows>0)
            {
                return "Amount deposited successfully!!";
            }
        }
        catch(Exception e){

            return e.toString();
        }

        return "Deposit failed!!";
    }

    public String withdraw(double amount)
    {
        if(currentUser==null)
        {
            return "Please login first!!";
        }

        try{

            String balanceQuery=
            "select balance from account where acc_no=?";

            PreparedStatement balancePs=
            con.prepareStatement(balanceQuery);

            balancePs.setInt(1,currentUser.getAccNo());

            ResultSet rs=
            balancePs.executeQuery();

            double balance=0;

            if(rs.next())
            {
                balance=
                rs.getDouble("balance");
            }

            if(balance<amount)
            {
                return "Insufficient balance!!";
            }

            String query=
            "update account set balance=balance-? where acc_no=?";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setDouble(1,amount);
            ps.setInt(2,currentUser.getAccNo());

            int rows=ps.executeUpdate();

            if(rows>0)
            {
                return "Amount withdrawn successfully!!";
            }
        }
        catch(Exception e){

            return e.toString();
        }

        return "Withdraw failed!!";
    }

    public double checkBalance()
    {
        if(currentUser==null)
        {
            return -1;
        }

        try{

            String query=
            "select balance from account where acc_no=?";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setInt(1,currentUser.getAccNo());

            ResultSet rs=
            ps.executeQuery();

            if(rs.next())
            {
                return rs.getDouble("balance");
            }
        }
        catch(Exception e){

            System.out.println(e);
        }

        return 0;
    }

    public String adminLogin(String email,
                             String password)
    {
        try{

            String query=
            "select * from admin where email=? and password=?";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs=
            ps.executeQuery();

            if(rs.next())
            {
                currentAdmin=new Admin(
                    rs.getInt("admin_id"),
                    rs.getString("email"),
                    rs.getString("password")
                );

                return "Admin login successful!!";
            }
        }
        catch(Exception e){

            return e.toString();
        }

        return "Invalid admin credentials!!";
    }

    public String adminLogout()
    {
        if(currentAdmin!=null)
        {
            currentAdmin=null;

            return "Admin logout successful!!";
        }

        return "No admin logged in!!";
    }

    public void searchAccount(int accNo)
    {
        if(currentAdmin==null)
        {
            System.out.println(
            "Access denied!! Admin only."
            );

            return;
        }

        try{

            String query=
            "select * from account where acc_no=?";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setInt(1,accNo);

            ResultSet rs=
            ps.executeQuery();

            if(rs.next())
            {
                System.out.println(
                "\n===== ACCOUNT DETAILS ====="
                );

                System.out.println(
                "Account Number : "+
                rs.getInt("acc_no")
                );

                System.out.println(
                "Name : "+
                rs.getString("name")
                );

                System.out.println(
                "Aadhaar : "+
                rs.getString("aadhaar")
                );

                System.out.println(
                "Phone : "+
                rs.getString("phone")
                );

                System.out.println(
                "Email : "+
                rs.getString("email")
                );

                System.out.println(
                "Balance : "+
                rs.getDouble("balance")
                );
            }
            else
            {
                System.out.println(
                "Account not found!!"
                );
            }
        }
        catch(Exception e){

            System.out.println(e);
        }
    }

    public void displayAllAccounts()
    {
        if(currentAdmin==null)
        {
            System.out.println(
            "Access denied!! Admin only."
            );

            return;
        }

        try{

            String query=
            "select * from account";

            PreparedStatement ps=
            con.prepareStatement(query);

            ResultSet rs=
            ps.executeQuery();

            while(rs.next())
            {
                System.out.println(
                "\n======================"
                );

                System.out.println(
                "Account Number : "+
                rs.getInt("acc_no")
                );

                System.out.println(
                "Name : "+
                rs.getString("name")
                );

                System.out.println(
                "Phone : "+
                rs.getString("phone")
                );

                System.out.println(
                "Balance : "+
                rs.getDouble("balance")
                );
            }
        }
        catch(Exception e){

            System.out.println(e);
        }
    }

    public String deleteAccount(int accNo)
    {
        if(currentAdmin==null)
        {
            return "Access denied!! Admin only.";
        }

        try{

            String query=
            "delete from account where acc_no=?";

            PreparedStatement ps=
            con.prepareStatement(query);

            ps.setInt(1,accNo);

            int rows=
            ps.executeUpdate();

            if(rows>0)
            {
                return "Account deleted successfully!!";
            }
        }
        catch(Exception e){

            return e.toString();
        }

        return "Account not found!!";
    }
}