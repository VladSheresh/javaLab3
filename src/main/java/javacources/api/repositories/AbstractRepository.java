package javacources.api.repositories;

import javacources.entitiy.BaseEntity;
import javacources.entitiy.Booking;

import java.util.List;

public interface AbstractRepository<T extends BaseEntity> {
    void add(T entity);
    T get(int entityId);
    List<T> getAll();
    void update(T entity);
}
