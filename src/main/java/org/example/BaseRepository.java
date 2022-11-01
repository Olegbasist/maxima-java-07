package org.example;

// 31.10.2022 Описать базовый интерфейс BaseRepository для реализации паттерна DAO с CRUD операциями и выборкой всех объектов (для любого класса) findAll()

public interface BaseRepository {

    public static final String DB_URL = "jdbc:h2:mem:db";
    public static final String DB_DRIVER = "org.h2.Driver";


    void connectToDB(String DB_URL, String DB_DRIVER);
    void disconnectFromDB();

    //Заполнение
    void createTable(String name, int weight, boolean isAngry);
    void insertRecord(String name, int weight, boolean isAngry);
    void deleteRecord(String name);

    //Изменение данных
    int updateRecord(String nameToChange, String rowToChange, String name, int weight, boolean isAngry);
    int updateRecordName(String nameToChange, String name);
    int updateRecordWeight(String nameToChange, int weight);
    int updateRecordAngry(String nameToChange, boolean isAngry);

    //Поиск
    void findAll(String name);

    //Все операции разом
    int executer(String operation, String string, String row, String name, int weight, boolean isAngry);


}
