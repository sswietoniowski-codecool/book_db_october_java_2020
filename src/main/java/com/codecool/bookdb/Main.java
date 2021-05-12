package com.codecool.bookdb;

import com.codecool.bookdb.manager.BookDbManager;
import com.codecool.bookdb.model.Author;
import com.codecool.bookdb.model.AuthorDao;
import com.codecool.bookdb.model.AuthorDaoJdbc;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        BookDbManager bookDbManager = new BookDbManager();
        try {
            DataSource dataSource = bookDbManager.connect();
            AuthorDao authorDao = new AuthorDaoJdbc(dataSource);
            List<Author> authors = authorDao.getAll();
            for (Author author : authors) {
                System.out.println(author);
            }
        } catch (SQLException | IOException exception) {
            System.out.println("Program is closing due to an error");
            logger.warning(exception.getMessage());
        }
    }
}
