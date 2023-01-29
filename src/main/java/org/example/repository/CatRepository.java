package org.example.repository;

import java.util.List;

public interface CatRepository <Cat, Long> extends BaseRepository <Cat, Long>{


    @Override
    boolean create(Cat element);

    @Override
    Cat read(Long id);

    @Override
    int update(Long id, Cat element);

    @Override
    void delete(Long id);

    @Override
    List<Cat> findAll();
}
