package com.progressoft.test.fifth;

public interface SignUpRepository<T> {

    void persist(T entity);
}
