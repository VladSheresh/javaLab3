package javacources.repository;

import javacources.api.repositories.ServicesRepository;
import javacources.entitiy.Service;

import java.util.ArrayList;
import java.util.List;

public class ServicesRepositoryImpl implements ServicesRepository {
    private MyId myId;
    private List<Service> allServices = new ArrayList<>();
    private static ServicesRepositoryImpl instance;

    private ServicesRepositoryImpl() {
        myId = new MyId();
    }

    public static ServicesRepository getInstance() {
        if (instance == null) {
            instance = new ServicesRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(Service service) {
        service.setId(myId.generationId());
        allServices.add(service);
    }

    @Override
    public Service get(int serviceId) {
        for (Service service : allServices) {
            if (service.getId() == serviceId) {
                return service;
            }
        }
        return null;
    }

    @Override
    public void update(Service updService) {
        allServices.replaceAll(service -> {
            return updService.equals(service) ? updService : service;
        });
    }
}
