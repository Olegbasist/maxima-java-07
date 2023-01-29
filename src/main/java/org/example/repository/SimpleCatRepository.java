package org.example.repository;
//
// TODO: Описать класс SimpleCatRepository для реализации этого интерфейса.
// TODO: URL базы данных и имя таблицы задайте в конструкторе класса выбранным Вами способом
//
// В каждом методе отрыть и закрыть отдельный connection

import org.example.model.Cat;

import java.sql.*;
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
    public void createTable() throws SQLException {
        connectToDB();

            statement.executeUpdate("CREATE TABLE cats (ID BIGINT, Name VARCHAR(30), Weight INT, Angry BIT)");
            statement.executeUpdate("INSERT INTO cats(ID, Name, Weight, Angry) VALUES (9223372036854775807,'Cat', 5, 1)");
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM cats");
            while (resultSet.next()){
                Long id = resultSet.getLong("ID");
                String name = resultSet.getString("Name");
                int weight = resultSet.getInt("Weight");
                boolean isAngry = resultSet.getBoolean("Angry");
                System.out.println(id + name + weight + isAngry);
            }

        disconnectFromDB();
        // Скорее всего не надо
        getAllCats();
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
    public void disconnectFromDB() throws SQLException {
        System.out.print("Отключаюсь от БД ...");

            //connection.close();

        System.out.println(" ОК");
    }

    // ----------------------------------------------------------------


    @Override
    public boolean create(Cat element) throws SQLException {

        connectToDB();
        disconnectFromDB();

        return false;
    }

    @Override
    public Cat read(List id) throws SQLException {

        connectToDB();
        disconnectFromDB();

        return null;
    }

    @Override
    public int update(List id, Cat element) throws SQLException {

        connectToDB();
        disconnectFromDB();

        return 0;
    }

    @Override
    public void delete(List id) throws SQLException {

        connectToDB();
        disconnectFromDB();

    }

    @Override
    public List<Cat> findAll() throws SQLException {
        connectToDB();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM cats");

        while (resultSet.next()){
            Long id = resultSet.getLong("ID");
            String name = resultSet.getString("Name");
            int weight = resultSet.getInt("Weight");
            boolean isAngry = resultSet.getBoolean("Angry");
            System.out.println(id + name + weight + isAngry);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        disconnectFromDB();
        return null;
    }
    public void getAllCats() throws SQLException {
        connectToDB();
        System.out.println("Вывожу всех котов:");
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("SELECT * FROM cats");

            while (resultSet.next()){
                //Long id = resultSet.getLong("ID");
                String name = resultSet.getString("Name");
                int weight = resultSet.getInt("Weight");
                boolean isAngry = resultSet.getBoolean("Angry");
                System.out.println(name + weight + isAngry);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Коты кончились.");
        disconnectFromDB();
    }

}
