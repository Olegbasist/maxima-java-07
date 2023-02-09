package org.example.repository;

import org.example.model.IncorrectCatWeightException;

import java.sql.SQLException;
import java.util.List;

public interface CatRepository <Cat, Long> extends BaseRepository <Cat, Long>{


    @Override
    boolean create(Cat cat) throws SQLException;

    @Override
    Cat read(Long id) throws SQLException, IncorrectCatWeightException;

    @Override
    int update(Long id, Cat cat) throws SQLException;

    @Override
    void delete(Long id) throws SQLException;

    @Override
    List<Cat> findAll() throws SQLException, IncorrectCatWeightException;
}
