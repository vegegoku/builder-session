package com.progressoft.test;

public interface Repository<T> {
    void persist(T entity);
}
