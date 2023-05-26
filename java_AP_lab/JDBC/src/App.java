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

class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/JavaLab";
        String user = "root";
        String password = "";
        String query = "SELECT * FROM `test`";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,user,password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)  ;
        while (rs.next()) {
            System.out.print(rs.getInt("id") + " : ");
            
            System.out.print(rs.getString("Name") + "-->");
            
           System.out.print(rs.getString("pass")+ "-->");
            
            System.out.println(rs.getInt("num"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}

