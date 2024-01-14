package com.ip.bankmanager.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseEntityInterface<T> {
    List<T> getAll();
    T getEntity(int id);
    T createEntity(T entity);
    T updateEntity(int id, T newEntity) throws IllegalAccessException, InvocationTargetException;
    void deleteEntity(int id);
}
