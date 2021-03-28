package utils;

import java.sql.*;

public class JDBCPractice {
    /*
    Connection --> it helps us to provide db and connect to the database
    Statement --> we define our conditions to get the result from database
    ResultSet --> We store the data from database to the resultset object in java
    Three of them are interface.
     */
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection(
                "jdbc:database-1.cwpszounzwn4.us-east-2.rds.amazonaws.com:1521/ORCL",
                "admin",
                "admin123"
        );
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery("select * from employees;");
        resultSet.next(); //it will go to the next row, if there is next (row it will return true and go to the next row)
        System.out.println(resultSet.getString("first_name"));


    }
}
