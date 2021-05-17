package javacources.repository;

import javacources.api.ds.AbstractDataStorage;
import javacources.api.repositories.AbstractRepository;
import javacources.entitiy.BaseEntity;

import java.util.List;

public abstract class AbstractRepositoryImpl<T extends BaseEntity>
        implements AbstractRepository<T> {

    protected final AbstractDataStorage<T> storage;

    private MyId myId = new MyId();

    protected AbstractRepositoryImpl(AbstractDataStorage<T> storage) {
        this.storage = storage;
    }

    @Override
    public void add(T entity) {
        entity.setId(myId.generationId());
        storage.create(entity);
    }

    @Override
    public T get(int entityId) {
        return storage.getAll().stream().filter(entity -> entity.getId() == entityId).findFirst().orElse(null);
    }

    @Override
    public List<T> getAll() {
        return storage.getAll();
    }

    @Override
    public void update(T entity) {
        int index = storage.getAll().indexOf(entity);
        storage.getAll().set(index, entity);
    }
}
