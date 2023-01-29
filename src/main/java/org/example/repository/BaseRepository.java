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

    void connectToDB();
    void disconnectFromDB();

    // -----------------------------------------------------------------

    // Create
    boolean create(T element);

    // Read
    T read(I id);

    // Update
    int update(I id, T element);


    // Delete
    void delete(I id);

    //Поиск (Search)
    List<T> findAll();
}
