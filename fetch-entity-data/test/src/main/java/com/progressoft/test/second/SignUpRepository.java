package com.progressoft.test.second;

public interface SignUpRepository<T> {

    void persist(T entity);
}
