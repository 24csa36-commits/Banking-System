package model;

public class Admin{

    private int adminId;
    private String email;
    private String password;

    public Admin(int adminId,
                 String email,
                 String password)
    {
        this.adminId=adminId;
        this.email=email;
        this.password=password;
    }

    public int getAdminId(){
        return adminId;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}