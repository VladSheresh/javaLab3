package javacources.service;

import javacources.api.repositories.AbstractRepository;
import javacources.api.services.AbstractService;
import javacources.entitiy.BaseEntity;

public abstract class AbstractServiceImpl <T extends BaseEntity>
        implements AbstractService<T> {

    protected final AbstractRepository<T> repository;

    protected AbstractServiceImpl(AbstractRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void add(T entity) {
        repository.add(entity);
    }

    @Override
    public T get(int entityId) {
        return repository.get(entityId);
    }
}
