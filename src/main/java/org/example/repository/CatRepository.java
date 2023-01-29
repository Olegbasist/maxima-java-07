package org.example.repository;

import java.sql.SQLException;
import java.util.List;

public interface CatRepository <Cat, Long> extends BaseRepository <Cat, Long>{


    @Override
    boolean create(Cat element) throws SQLException;

    @Override
    Cat read(Long id) throws SQLException;

    @Override
    int update(Long id, Cat element) throws SQLException;

    @Override
    void delete(Long id) throws SQLException;

    @Override
    List<Cat> findAll() throws SQLException;
}
