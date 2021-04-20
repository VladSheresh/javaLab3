package javacources.repository;

import javacources.entitiy.MyId;
import javacources.entitiy.Service;

import java.util.ArrayList;
import java.util.List;

public class ServicesRepositoryImpl implements ServicesRepository {
    private List<Service> allServices = new ArrayList<>();
    private static ServicesRepositoryImpl instance;

    private ServicesRepositoryImpl(){

    }

    public static ServicesRepository getInstance(){
        if(instance == null){
            instance = new ServicesRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addService(Service service) {
        service.setId(MyId.generationId());
        allServices.add(service);
    }

    @Override
    public Service getService(int serviceId) {
        for (int i = 0; i < allServices.size(); i++){
            Service service = allServices.get(i);
            if(service.getId() == serviceId) {
                return service;
            }
        }
        return null;
    }
}
