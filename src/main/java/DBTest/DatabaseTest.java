package DBTest;

import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) {
        //to build the connection with the database, we need URL, username, Password

        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        //url= jdbc:typeofdatabase://addressofdatabase:port

        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        //we need to establish the connection to the database
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");

            Statement statement = conn.createStatement(); //create a statement to send sql queries

            // when we send any query to DB and DB returns results //ResultSet = tables with rows and columns
            ResultSet rset = statement.executeQuery("select Firstname, Lastname from person");
            rset.next(); //this will get you the next data after default

            String fName=rset.getString("FirstName");
            String lName=rset.getString("LastName");
            System.out.println(fName+" "+lName);

            rset.next();
            fName=rset.getString("FirstName");
            lName=rset.getString("LastName");
            System.out.println(fName+" "+lName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
