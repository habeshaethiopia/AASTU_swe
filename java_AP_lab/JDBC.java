
/**
 * !steps to connect to java databse
 * *1- import package --> import java.sql
 * *2- load and register the drivers --> com.mysql.jdbc.Driver
 * *3- create connection --> connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
 * *4- create statement --> statement = connection.createStatement();
 * *5- execute query --> ResultSet resultSet = statement.executeQuery("select * from users");
 * *6- process result set --> while(resultSet.next()){
 * *7- close
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.Statement;

class JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.driver");
        Connection conn = DriverManager.getConnection("localhost:8080", "root", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}