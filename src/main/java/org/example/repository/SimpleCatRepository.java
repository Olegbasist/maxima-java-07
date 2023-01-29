package org.example.repository;
//
// TODO: Описать класс SimpleCatRepository для реализации этого интерфейса.
// TODO: URL базы данных и имя таблицы задайте в конструкторе класса выбранным Вами способом
//
// В каждом методе отрыть и закрыть отдельный connection
// После вызова метода close толка от объекта connection уже нет.
// Для повторной установки соединения придётся воспользоваться метод getConnection

import org.example.model.Cat;

import java.sql.*;
import java.util.List;

public class SimpleCatRepository implements CatRepository <Cat, Long>{

    //Соединение с БД -------------------------------------------------

    private final String DB_URL;

    public SimpleCatRepository(String DB_URL, String DB_DRIVER) throws ClassNotFoundException, SQLException {
        this.DB_URL = DB_URL;
        Class.forName(DB_DRIVER);
        createTable();
    }
    public void createTable() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        statement.executeUpdate("CREATE TABLE cats (ID BIGINT, Name VARCHAR(30), Weight INT, Angry BIT)");

        //addTestCats();
        //getAllCats();
    }

    // Мои тестовые методы ----------------------------------------------------------------


    public void addTestCats () throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        statement.executeUpdate("INSERT INTO cats(ID, Name, Weight, Angry) VALUES (9223372036854775807,'Cat', 5, 1)");
        statement.executeUpdate("INSERT INTO cats(ID, Name, Weight, Angry) VALUES (9,'Cat9', 4, 0)");
        statement.executeUpdate("INSERT INTO cats(ID, Name, Weight, Angry) VALUES (2,'Cat2', 6, 0)");
        statement.executeUpdate("INSERT INTO cats(ID, Name, Weight, Angry) VALUES (3,'Cat3', 7, 1)");

        connection.close();
    }

    public void getAllCats() throws SQLException {
        try {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        System.out.println("Вывожу всех котов:");
        ResultSet resultSet;

            resultSet = statement.executeQuery("SELECT * FROM cats");

            while (resultSet.next()){
                Long id = resultSet.getLong("ID");
                String name = resultSet.getString("Name");
                int weight = resultSet.getInt("Weight");
                boolean isAngry = resultSet.getBoolean("Angry");
                System.out.println(id + " " + name + " " + weight + " " + isAngry);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Коты кончились.");
    }

    // CRUD методы -----------------------------------------------------------------------
    @Override
    public boolean create(Cat cat) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();
        String id = cat.getId().toString();
        String name = cat.getName();

        //createTable();
        // Не видит переменные в SQL запросе

        statement.executeUpdate("INSERT INTO cats(ID, Name, Weight, Angry) VALUES (88,'" +name +"',5,1)");

        connection.close();
        return false;
    }

    @Override
    public Cat read(Long id) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        connection.close();
        return null;
    }

    @Override
    public int update(Long id, Cat cat) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        connection.close();
        return 0;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        connection.close();

    }

    @Override
    public List<Cat> findAll() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        connection.close();
        return null;
    }
}
