package com.ip.bankmanager.interfaces;

import java.util.List;

public interface BaseEntityInterface<T> {
    List<T> getAll();
    T getEntity(int id);
    T createEntity(T entity);
    T updateEntity(int id, T newEntity);
    void deleteEntity(int id);
}
