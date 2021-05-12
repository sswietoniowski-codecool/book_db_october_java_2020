package com.codecool.bookdb.manager;

import com.codecool.bookdb.model.AuthorDao;
import com.codecool.bookdb.model.AuthorDaoJdbc;
import com.codecool.bookdb.model.BookDao;
import com.codecool.bookdb.model.BookDaoJdbc;
import com.codecool.bookdb.view.UserInterface;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class BookDbManager {
    private UserInterface ui;
    private AuthorDao authorDao;
    private BookDao bookDao;

    public BookDbManager(UserInterface ui) {
        this.ui = ui;
    }

    private void setup() throws SQLException, IOException {
        DataSource dataSource = connect();
        authorDao = new AuthorDaoJdbc(dataSource);
        bookDao = new BookDaoJdbc(dataSource);

    }

    public void run() {
        try {
            setup();
        } catch (SQLException | IOException exception) {
            System.out.println("Could not connect to the database");
            return;
        }

        boolean running = true;

        while (running) {
            ui.printTitle("Main Menu");
            ui.printOption('a', "Authors");
            ui.printOption('b',"Books");
            ui.printOption('q', "Quit");

            switch (ui.choice("abq")) {
                case 'a':
                    new AuthorManager(ui, authorDao).run();
                    break;
                case 'b':
                    new BookManager(ui, bookDao, authorDao).run();
                    break;
                case 'q':
                    running = false;
                    break;
            }
        }
    }

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
