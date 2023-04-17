package org.sda.pcms.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
    Optional<T> findById(int id);

}
