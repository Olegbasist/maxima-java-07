package org.example;

import org.example.model.Cat;
import org.example.model.IncorrectCatWeightException;
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

    public static void main( String[] args ) throws ClassNotFoundException, SQLException, IncorrectCatWeightException {
        //Пробую БД
        /*System.out.print("Соединяюсь с БД ...");
        Class.forName(DB_DRIVER);
        Connection connection;
        connection = DriverManager.getConnection(DB_URL);
        System.out.println(" ОК");

        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE cats (Name VARCHAR(30), Weight INT, Angry BIT)");
        statement.executeUpdate("INSERT INTO cats(Name, Weight, Angry) VALUES ('Cat', 5, 0)");


        //connection.close();
        System.out.println("Соединение с БД закрыто: " +connection.isClosed());
        //connection = DriverManager.getConnection(DB_URL);

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
        //System.out.println(UUID.randomUUID());

        // -----------------------------------------------------------------
        SimpleCatRepository simpleCatRepository = new SimpleCatRepository(DB_URL, DB_DRIVER);
        simpleCatRepository.addTestCats();
        //simpleCatRepository.getAllCats();

        System.out.println("-------------------------------------------");
        Cat cat = new Cat(12L,"Kott",7,false);
        simpleCatRepository.create(cat);
        simpleCatRepository.getAllCats();

        //Cat cat2 = new Cat(13L,"Kott2",5,true);
        //System.out.println(simpleCatRepository.update(12L,cat2));
        //simpleCatRepository.create(cat2);
        //simpleCatRepository.getAllCats();
        //simpleCatRepository.findAll().forEach(cat1 -> System.out.println(cat1.toString()));

        //System.out.println(simpleCatRepository.read(9l));

        simpleCatRepository.delete(1L);






    }
}
