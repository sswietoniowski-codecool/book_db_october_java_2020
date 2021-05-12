package com.codecool.bookdb.model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookDaoJdbc implements BookDao {
    private DataSource dataSource;

    public BookDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Book book) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // TODO:
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(Book book) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // TODO:
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Book get(int id) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // TODO:
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

        return null;
    }

    @Override
    public List<Book> getAll() {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // TODO:
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

        return null;
    }
}
