package org.example;

import org.example.repository.SimpleCatRepository;

import java.sql.*;
import java.util.UUID;


//  Описать интерфейс BaseRepository для реализации репозитория котов:
//  CRUD-операции + выборка данных с методами:
//      boolean create(T element);
//      T read(I id);
//      int update(I id, T element);
//      void delete(I id);
//      List<T> findAll(); //search(), get.. select
//
// TODO: Описать класс SimpleCatRepository для реализации этого интерфейса.
//
// TODO: URL базы данных и имя таблицы задайте в конструкторе класса выбранным Вами способом
public class App 
{
    public static final String DB_URL = "jdbc:h2:mem:db";
    public static final String DB_DRIVER = "org.h2.Driver";

    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        //Пробую БД
        /*System.out.print("Соединяюсь с БД ...");
        Class.forName(DB_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL);
        System.out.println(" ОК");

        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE cats (Name VARCHAR(30), Weight INT, Angry BIT)");
        statement.executeUpdate("INSERT INTO cats(Name, Weight, Angry) VALUES ('Cat', 5, 0)");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM cats");

        while (resultSet.next()){
            String name = resultSet.getString("Name");
            int weight = resultSet.getInt("Weight");
            boolean isAngry = resultSet.getBoolean("Angry");
            System.out.println(name + weight + isAngry);
        }


        System.out.print("Отключаюсь от БД ...");
        connection.close();
        System.out.println(" ОК");*/
        //Соединение с БД -------------------------------------------------



        //Генерация UUID --------------------------------------------------
        System.out.println(UUID.randomUUID());

        // -----------------------------------------------------------------
        SimpleCatRepository simpleCatRepository = new SimpleCatRepository(DB_URL, DB_DRIVER);
        //simpleCatRepository.connectToDB();
        simpleCatRepository.createTable();
        //simpleCatRepository.getAllCats();
        //simpleCatRepository.disconnectFromDB();




    }
}
