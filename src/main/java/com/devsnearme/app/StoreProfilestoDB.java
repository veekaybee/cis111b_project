package com.devsnearme.app;

import java.sql.DriverManager;

/**
 * Created by vboykis on 4/9/17.
 */
public class StoreProfilestoDB {

    //Begin templating for DB connection


    public void connectToDB() {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("test");
        dataSource.setServerName("myDBHost.example.org");

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID FROM USERS");
        ...
        rs.close();
        stmt.close();
        conn.close();
    }

}
