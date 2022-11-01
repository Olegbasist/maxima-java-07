package org.example;

// 31.10.2022 Описать базовый интерфейс BaseRepository для реализации паттерна DAO с CRUD операциями и выборкой всех объектов (для любого класса) findAll()


import java.util.ArrayList;

public interface BaseRepository2<Cat> {


    ArrayList<Cat> allFilms();
    void add(Cat cats);
    void delete(Cat cats);
    void edit(Cat cats);
    Cat getById(int id);


}
