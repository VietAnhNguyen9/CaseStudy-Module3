package com.example.casestudymd3.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IGenrate<E> {
    List<E> findAll();
    E findOne(HttpServletRequest request);
    void add(HttpServletRequest request);
    void update(HttpServletRequest request);
    void delete(HttpServletRequest request);
}
