package com.progressoft.test.fourth;

public interface SignUpRepository<T> {

    void persist(T entity);
}
