package javacources.api.services;

import javacources.entitiy.BaseEntity;

public interface AbstractService<T extends BaseEntity> {
    void add(T entity);

    void changePrice(int entityId, int price);
}
