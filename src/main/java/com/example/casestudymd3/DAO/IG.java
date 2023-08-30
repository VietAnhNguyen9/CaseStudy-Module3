package com.example.casestudymd3.DAO;

import java.util.List;

public interface IG<E> {
    List<E> findAll();
    E findOne(int id);
    void create(E e);
    void update(E e);
    void delete(int id);
}
