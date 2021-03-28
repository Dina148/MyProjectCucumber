package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCPractice {
    /*
    Connection --> it helps us to provide db and connect to the database
    Statement --> we define our conditions to get the result from database
    ResultSet --> We store the data from database to the resultset object in java
    Three of them are interface.
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@database-1.cwpszounzwn4.us-east-2.rds.amazonaws.com:1521/ORCL",
                "admin",
                "admin123"
        );
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery("select * from employees");
        resultSet.next(); //it will go to the next row, if there is next (row it will return true and go to the next row)
        System.out.println(resultSet.getString("first_name"));

        resultSet.last();
        System.out.println(resultSet.getString("last_name"));
        resultSet.first();
        System.out.println(resultSet.getString("last_name"));
        System.out.println(resultSet.getRow());
        System.out.println(resultSet.next());
        //-----------------------------------------

        resultSet.beforeFirst();
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        //METADATA--> information about the your columbs, row etc in your table

        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(3));


        List<Map<String, Object>> employees=new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> employee=new LinkedHashMap<>();
            for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                employee.put(resultSetMetaData.getCatalogName(i), resultSet.getObject(i));
            }

            employees.add(employee);

        }
        System.out.println(employees.get(2).get("EMAIL"));


    }
}
