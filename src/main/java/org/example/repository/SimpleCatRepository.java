package org.example.repository;

import java.util.List;

public class SimpleCatRepository implements CatRepository{

    //Соединение с БД -------------------------------------------------

    public static final String DB_URL = "jdbc:h2:mem:db";
    public static final String DB_DRIVER = "org.h2.Driver";


    @Override
    public void connectToDB(String DB_URL, String DB_DRIVER) {

    }

    @Override
    public void disconnectFromDB() {

    }

    // ----------------------------------------------------------------

    public void createTable(String name, int weight, boolean isAngry) {

    }

    @Override
    public boolean create(Object element) {
        return false;
    }

    @Override
    public Object read(Object id) {
        return null;
    }

    @Override
    public int update(Object id, Object element) {
        return 0;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List findAll() {
        return null;
    }
}
