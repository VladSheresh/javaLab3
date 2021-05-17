package javacources.MemoDataStorage;

import javacources.api.ds.AbstractDataStorage;
import javacources.entitiy.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataStorageImpl <T extends BaseEntity>
        implements AbstractDataStorage<T> {

    protected List<T> storage = new ArrayList<>();

    @Override
    public void create(T entity) {
        storage.add(entity);
    }

    @Override
    public List<T> getAll() {
        return storage;
    }
}
