package org.example.repository;

//  Описать интерфейс BaseRepository для реализации репозитория котов:
//  CRUD-операции + выборка данных с методами:
//      boolean create(T element);
//      T read(I id);
//      int update(I id, T element);
//      void delete(I id);
//      List<T> findAll(); //search(), get.. select

import java.util.List;

public interface BaseRepository<T, I> {

    //Соединение с БД -------------------------------------------------

    public static final String DB_URL = "jdbc:h2:mem:db";
    public static final String DB_DRIVER = "org.h2.Driver";

    void connectToDB(String DB_URL, String DB_DRIVER);
    void disconnectFromDB();

    // -----------------------------------------------------------------


    //Заполнение
    void createTable(String name, int weight, boolean isAngry);

    // Create
    boolean create(T element);

    // Read
    T read(I id);

    //Update
    int update(I id, T element);

/*    int editRecord(I id, String nameToChange, String rowToChange, String name, int weight, boolean isAngry);
    int editRecordName(I id, String nameToChange, String name);
    int editRecordWeight(I id, String nameToChange, int weight);
    int editRecordAngry(I id, String nameToChange, boolean isAngry);*/

    // Delete
    void delete(I id);

    //Поиск (Search)
    List<T> findAll();

   /* //Все операции разом (старое)
    int executes(String operation, String string, String row, String name, int weight, boolean isAngry);
    */
}
