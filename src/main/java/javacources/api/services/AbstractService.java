package javacources.api.services;

import javacources.entitiy.BaseEntity;
import javacources.entitiy.Room;

public interface AbstractService<T extends BaseEntity> {
    void add(T entity);
    T get(int entityId);
}
