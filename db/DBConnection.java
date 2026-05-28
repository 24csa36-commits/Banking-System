package db;
import java.sql.*;

public class DBConnection{
    public static Connection con;

    public static Connection getConnection()
    {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankdb",
                "root",
                "SJdh2007#@@#"
            );
        }
        catch(Exception e){

            System.out.println(e);
        }

        return con;
    }
}