package org.example;

// TODO: 31.10.2022 Описать базовый интерфейс BaseRepository для реализации паттерна DAO с CRUD операциями и выборкой всех объектов (для любого класса) findAll()

public interface BaseRepository {

    public static final String DB_URL = "jdbc:h2:mem:db";
    public static final String DB_DRIVER = "org.h2.Driver";

    void connectToDB(String DB_URL, String DB_DRIVER);
    void disconnectFromDB();

    void createTable(String name, int weight, boolean isAngry);
    void insertRecord(String name, int weight, boolean isAngry);
    void findAll(String name);

    default void findAll() {

    }

}
