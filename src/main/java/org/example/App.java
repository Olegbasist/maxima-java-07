package org.example;

import org.example.repository.SimpleCatRepository;

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

    public static void main( String[] args )
    {
        //Соединение с БД -------------------------------------------------

        final String DB_URL = "jdbc:h2:mem:db";
        final String DB_DRIVER = "org.h2.Driver";

        /*void connectToDB(String DB_URL, String DB_DRIVER);
        void disconnectFromDB();*/

        //Генерация UUID
        //System.out.println(UUID.randomUUID());

        // -----------------------------------------------------------------
        SimpleCatRepository simpleCatRepository = new SimpleCatRepository(DB_URL, DB_DRIVER);
        simpleCatRepository.connectToDB();
    }
}
