package com.codecool.bookdb.manager;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class BookDbManager {
    public DataSource connect() throws SQLException, IOException {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().
                getResourceAsStream("database.properties"));
        pgSimpleDataSource.setUrl(properties.getProperty("database.postgresql.url"));
        pgSimpleDataSource.setUser(properties.getProperty("database.postgresql.user"));
        pgSimpleDataSource.setPassword(properties.getProperty("database.postgresql.password"));
        System.out.println("Trying to connect...");
        pgSimpleDataSource.getConnection().close();
        System.out.println("Connection OK");
        return pgSimpleDataSource;
    }
}
