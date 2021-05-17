package javacources.repository;

import javacources.api.ds.ServicesDataStorage;
import javacources.api.repositories.ServicesRepository;
import javacources.entitiy.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServicesRepositoryImpl extends AbstractRepositoryImpl<Services> implements ServicesRepository {

    @Autowired
    public ServicesRepositoryImpl(ServicesDataStorage servicesDataStorage) {
        super(servicesDataStorage);
    }
}
