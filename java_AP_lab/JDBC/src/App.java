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
import java.sql.DatabaseMetaData;
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
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("____________________________________\n|id  | Name --> pass   --> num      |");
        System.out.println("-------------------------------------");

        while (rs.next()) {
            System.out.print("| " + rs.getInt("id") + " : ");

            System.out.print(rs.getString("Name") + "-->");

            System.out.print(rs.getString("pass") + "-->");

            System.out.println(rs.getInt("num") + "|");
            System.out.println("-------------------------------------");

        }
        DatabaseMetaData dbmd = conn.getMetaData();
System.out.println("Driver Name: " + dbmd.getDriverName());
System.out.println("Driver Version: " + dbmd.getDriverVersion());
System.out.println("UserName: " + dbmd.getUserName());
System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
        rs.close();
        stmt.close();
        conn.close();
    }
}
// ! out put 
/*
____________________________________
|id  | Name --> pass   --> num      |
-------------------------------------
| 1 : abebe-->1235jhgui-->986465486|
-------------------------------------
| 2 : adaad-->1235jhgui-->90465486|
-------------------------------------
| 3 : kebebe-->vfd35jhgui-->9755686|
-------------------------------------
| 4 : abebe-->134353443gui-->96765476|
-------------------------------------
| 5 : abebe-->1000jhgui-->967465486|
-------------------------------------
| 6 : abebe-->1be35jhgui-->986465486|
-------------------------------------
| 7 : abebe-->1fgu00fggfi-->986465486|
-------------------------------------
DatabaseMetaData dbmd = connection.getMetaData();
System.out.println("Driver Name: " + dbmd.getDriverName());
System.out.println("Driver Version: " + dbmd.getDriverVersion());
System.out.println("UserName: " + dbmd.getUserName());
System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
*/
