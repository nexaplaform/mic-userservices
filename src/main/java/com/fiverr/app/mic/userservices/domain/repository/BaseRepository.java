package com.fiverr.app.mic.userservices.domain.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collections;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, K> {

    default T create(T model) {return null; }

    default T getById(K id) {return null; }

    default T update(T model, K id) {return null; }

    default T update(T model) {return null; }

    default List<T> findAll(Integer page, Integer size, String sort) { return Collections.emptyList(); }

    default void deleteById(K id) { }
}
