package com.progressoft.test.first;

public interface SignUpRepository<T> {

    void persist(T entity);
}
