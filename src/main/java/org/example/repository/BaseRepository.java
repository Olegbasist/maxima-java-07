package org.example.repository;

// TODO: Описать интерфейс BaseRepository для реализации репозитория котов:
//  CRUD-операции + выборка данных с методами:
//      boolean create(T element);
//      T read(I id);
//      int update(I id, T element);
//      void delete(I id);
//      List<T> findAll(); //search(), get.. select

public interface BaseRepository {

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
