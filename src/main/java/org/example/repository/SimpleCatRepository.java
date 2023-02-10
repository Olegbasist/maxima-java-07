package org.example.repository;
//
// Описать класс SimpleCatRepository для реализации этого интерфейса.
// URL базы данных и имя таблицы задайте в конструкторе класса выбранным Вами способом
//
// В каждом методе отрыть и закрыть отдельный connection
// После вызова метода close толка от объекта connection уже нет.
// Для повторной установки соединения придётся воспользоваться метод getConnection

import org.example.model.Cat;
import org.example.model.IncorrectCatWeightException;
import java.sql.*;
import java.util.ArrayList;
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
        final String tableName = "CATS";
        String sqlQueryCreateTable = String.format("CREATE TABLE %s (ID BIGINT, Name VARCHAR(64), Weight INT, Angry BIT)",tableName);

        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null,tableName, null);

        if (!resultSet.next()){
            statement.executeUpdate(sqlQueryCreateTable);

        }else {
            System.out.print("Таблица ");
            System.out.print(resultSet.getString(3));
            System.out.println(" уже существует");
        }
    }

    // CRUD методы -----------------------------------------------------------------------
    @Override
    public boolean create(Cat cat) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);

        //Statement
        String sqlQuery = String.format("INSERT INTO cats (ID, Name, Weight, Angry) " +
                "VALUES (%s, '%s', %s, %s)",
                cat.getId(),
                cat.getName(),
                cat.getWeight(),
                (cat.isAngry() ? 1 : 0));

        Statement statement = connection.createStatement();
        boolean result = statement.execute(sqlQuery);

        // Prepared Statement
        /*String sqlInsert = "INSERT INTO cats(ID, Name, Weight, Angry) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, String.valueOf(cat.getId()));
        preparedStatement.setString(2, cat.getName());
        preparedStatement.setString(3, String.valueOf(cat.getWeight()));
        preparedStatement.setString(4, String.valueOf((cat.isAngry() ? 1 : 0)));
        boolean result = preparedStatement.executeUpdate() != 0;*/
        
        connection.close();
        return result;
    }

    @Override
    public Cat read(Long id) throws SQLException, IncorrectCatWeightException {
        Connection connection = DriverManager.getConnection(DB_URL);

        // Statement
        String sqlQuery = String.format("SELECT * FROM cats WHERE ID = %s", id);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Prepared Statement
        /*String sqlSelect = "SELECT * FROM cats WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setString(1, String.valueOf(id));

        ResultSet resultSet = preparedStatement.executeQuery();*/

        resultSet.next();
        Cat cat = new Cat(resultSet.getLong("ID")
                , resultSet.getString("Name")
                , resultSet.getInt("Weight")
                ,resultSet.getBoolean("Angry"));

        connection.close();
        return cat;
    }

    @Override
    public int update(Long id, Cat cat) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);

        // Statement
        String sqlQuery = String.format("UPDATE cats SET " +
                "Name = '%s', " +
                "Weight = %s, " +
                "Angry = %s " +
                        "WHERE ID = %s",
                cat.getName(),
                cat.getWeight(),
                (cat.isAngry() ? 1 : 0),
                id);

        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(sqlQuery);

        // Prepared Statement
        /*String sqlUpdate = "UPDATE cats SET Name = ?, Weight = ?, Angry = ? WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
        preparedStatement.setString(1, cat.getName());
        preparedStatement.setString(2, String.valueOf(cat.getWeight()));
        preparedStatement.setString(3, String.valueOf((cat.isAngry() ? 1 : 0)));
        preparedStatement.setString(4, String.valueOf(id));
        int result = preparedStatement.executeUpdate();*/

        connection.close();
        return result;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);

        // Statement
        String sqlQuery = String.format("DELETE FROM cats WHERE ID = %s", id);
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlQuery);

        // Prepared Statement
        /*String sqlSelect = "DELETE FROM cats WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setString(1, String.valueOf(id));
        preparedStatement.executeUpdate();*/

        connection.close();
    }

    @Override
    public List<Cat> findAll() throws SQLException, IncorrectCatWeightException {
        Connection connection = DriverManager.getConnection(DB_URL);
        List<Cat> catList = new ArrayList<>();

        // Statement
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM cats");

        while (resultSet.next()){
                catList.add(new Cat(resultSet.getLong("ID")
                        ,resultSet.getString("Name")
                        ,resultSet.getInt("Weight")
                        , resultSet.getBoolean("Angry")));
        }

        connection.close();
        return catList;
    }

    // Мои тестовые методы ----------------------------------------------------------------


    public void addTestCats () throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();

        statement.executeUpdate("INSERT INTO cats(ID, Name, Weight, Angry) VALUES (1,'Cat', 5, 1)");
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
}
