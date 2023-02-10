package org.example;

import org.example.model.Cat;
import org.example.model.IncorrectCatWeightException;
import org.example.repository.SimpleCatRepository;

import java.sql.*;



//  Описать интерфейс BaseRepository для реализации репозитория котов:
//  CRUD-операции + выборка данных с методами:
//      boolean create(T element);
//      T read(I id);
//      int update(I id, T element);
//      void delete(I id);
//      List<T> findAll(); //search(), get.. select
//
//  Описать класс SimpleCatRepository для реализации этого интерфейса.
//
//  URL базы данных и имя таблицы задайте в конструкторе класса выбранным Вами способом
public class App 
{
    public static final String DB_URL = "jdbc:h2:mem:db";
    public static final String DB_DRIVER = "org.h2.Driver";

    public static void main( String[] args ) throws ClassNotFoundException, SQLException, IncorrectCatWeightException {


        SimpleCatRepository simpleCatRepository = new SimpleCatRepository(DB_URL, DB_DRIVER);





    }
}
