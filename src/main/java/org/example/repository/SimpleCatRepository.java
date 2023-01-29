package org.example.repository;
//
// TODO: Описать класс SimpleCatRepository для реализации этого интерфейса.
// TODO: URL базы данных и имя таблицы задайте в конструкторе класса выбранным Вами способом
//
// В каждом методе отрыть и закрыть отдельный connection

import org.example.model.Cat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SimpleCatRepository implements CatRepository <Cat, List> {

    //Соединение с БД -------------------------------------------------

    private final String DB_URL;
    private final String DB_DRIVER;

    private Connection connection = null;
    private Statement statement = null;


    public SimpleCatRepository(String DB_URL, String DB_DRIVER) {
        this.DB_URL = DB_URL;
        this.DB_DRIVER = DB_DRIVER;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void createTable() {
        connectToDB();
        try {
            statement.executeUpdate("CREATE TABLE cats (ID BIGINT, Name VARCHAR(30), Weight INT, Angry BIT)");
            statement.executeUpdate("INSERT INTO cats(ID, Name) VALUES (1,'Cat')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        disconnectFromDB();
        // Скорее всего не надо
    }

    @Override
    public void connectToDB() {

        System.out.print("Подключаюсь с БД ...");
        try {
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(" неудачно!");
            throw new RuntimeException(e);
        }
        System.out.println(" ОК");

    }

    @Override
    public void disconnectFromDB() {
        System.out.print("Отключаюсь от БД ...");
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(" неудачно!");
            throw new RuntimeException(e);
        }
        System.out.println(" ОК");
    }

    // ----------------------------------------------------------------


    @Override
    public boolean create(Cat element) {

        connectToDB();
        disconnectFromDB();

        return false;
    }

    @Override
    public Cat read(List id) {

        connectToDB();
        disconnectFromDB();

        return null;
    }

    @Override
    public int update(List id, Cat element) {

        connectToDB();
        disconnectFromDB();

        return 0;
    }

    @Override
    public void delete(List id) {

        connectToDB();
        disconnectFromDB();

    }

    @Override
    public List<Cat> findAll() {
        connectToDB();
        disconnectFromDB();
        return null;
    }

}
