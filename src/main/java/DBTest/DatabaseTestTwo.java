package DBTest;

import java.sql.*;

public class DatabaseTestTwo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            Statement statement = conn.createStatement();
            // ResultSet rset = statement.executeQuery("select Firstname, Lastname from person");

            ResultSet rset = statement.executeQuery("select firstname, lastname, age, city " +
                    "from person where city is not null;");

           /* while (rset.next()) {
                String fName = rset.getString("FirstName");
                String lName = rset.getString("LastName");
              System.out.println(fName+ " "+lName);
            }*/

            //ResultSet MetaData - object that contains information about the result
            // MetaDate - object that contains ALL THE DATA ABOUT THE TABLE
            //information such as in table, how many columns are there,
            //name of columns, rows and number of rows.

            ResultSetMetaData metaData = rset.getMetaData();
            for (int i=1; i<= metaData.getColumnCount(); i++){     //to print all the column header values
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);

            }

            //we want to loop through every column and every row
            while (rset.next()){
                for (int i=1; i<=metaData.getColumnCount(); i++){
                    String value = rset.getString(metaData.getColumnName(i));
                    System.out.println(value + " ");
                }
                //just to change the line statment added below
                System.out.println();
            }

        } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
