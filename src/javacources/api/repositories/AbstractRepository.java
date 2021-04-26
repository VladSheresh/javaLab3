package javacources.api.repositories;

import javacources.entitiy.BaseEntity;

public interface AbstractRepository<T extends BaseEntity> {
    void add(T entity);
    T get(int entityId);
    void update(T entity);
}
