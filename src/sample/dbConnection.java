package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1337";
    private static final String CONN = "jdbc:mysql://localhost:3306/mustore?";


    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(CONN + "user="+USERNAME+"&password="+PASSWORD);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
