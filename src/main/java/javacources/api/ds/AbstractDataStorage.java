package javacources.api.ds;

import javacources.entitiy.BaseEntity;

import java.util.List;

public interface AbstractDataStorage<T extends BaseEntity> {

    void create(T entity);

    List<T> getAll();
}
