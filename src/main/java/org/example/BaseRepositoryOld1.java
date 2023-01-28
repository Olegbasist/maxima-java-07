package org.example;

// 31.10.2022 Описать базовый интерфейс BaseRepository для реализации паттерна DAO
// с CRUD операциями и выборкой всех объектов (для любого класса) findAll()

//Комментарий преподавателя:
//Первая версия сильно перегружена разными идеями,
// на самом деле я ждал гораздо более простого решения.

// См. комментарии в BaseRepository2

public interface BaseRepositoryOld1 {

    public static final String DB_URL = "jdbc:h2:mem:db";
    public static final String DB_DRIVER = "org.h2.Driver";


    void connectToDB(String DB_URL, String DB_DRIVER);
    void disconnectFromDB();

    //Заполнение
    void createTable(String name, int weight, boolean isAngry);
    void addRecord(String name, int weight, boolean isAngry);
    void deleteRecord(String name);

    //Изменение данных
    int editRecord(String nameToChange, String rowToChange, String name, int weight, boolean isAngry);
    int editRecordName(String nameToChange, String name);
    int editRecordWeight(String nameToChange, int weight);
    int editRecordAngry(String nameToChange, boolean isAngry);

    //Поиск
    void findAll(String name);//Но лучше бы ID

    //Все операции разом
    int executes(String operation, String string, String row, String name, int weight, boolean isAngry);


}
