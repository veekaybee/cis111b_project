package com.devsnearme.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by vboykis on 4/9/17.
 */
public class StoreProfilestoDB {


    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public static void main(String[] args) throws Exception {
        new StoreProfilestoDB().connectToDB();

    }

    public void connectToDB() throws Exception {
        // This will load the MySQL driver, each DB has its own driver
        //Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/github?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
                        + "user=root&password=vicki1");

        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement
                .executeQuery("select * from github.logins");
        writeResultSet(resultSet);
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String login= resultSet.getString("login");
            String url = resultSet.getString("url");
            System.out.println("Login: " + login);
            System.out.println("GitHub Repos: " + url);
        }
    }

}
