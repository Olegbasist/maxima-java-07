package org.example.repository;

//  Описать интерфейс BaseRepository для реализации репозитория котов:
//  CRUD-операции + выборка данных с методами:
//      boolean create(T element);
//      T read(I id);
//      int update(I id, T element);
//      void delete(I id);
//      List<T> findAll(); //search(), get.. select

import org.example.model.IncorrectCatWeightException;

import java.sql.SQLException;
import java.util.List;

public interface BaseRepository<T, I> {



    // Create
    boolean create(T element) throws SQLException;

    // Read
    T read(I id) throws SQLException, IncorrectCatWeightException;

    // Update
    int update(I id, T element) throws SQLException;


    // Delete
    void delete(I id) throws SQLException;

    //Поиск (Search)
    List<T> findAll() throws SQLException, IncorrectCatWeightException;
}
