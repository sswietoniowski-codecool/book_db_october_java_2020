package com.codecool.bookdb;

import com.codecool.bookdb.manager.BookDbManager;
import com.codecool.bookdb.model.*;
import com.codecool.bookdb.view.UserInterface;

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
        try {
            UserInterface ui = new UserInterface(System.in, System.out);
            new BookDbManager(ui).run();
        } catch (Exception exception) {
            System.out.println("Program is closing due to an error");
            logger.warning(exception.getMessage());
        }
    }
}
