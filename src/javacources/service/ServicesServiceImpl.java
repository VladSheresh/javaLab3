package javacources.service;

import javacources.api.services.ServicesService;
import javacources.entitiy.Service;
import javacources.api.repositories.ServicesRepository;
import javacources.repository.ServicesRepositoryImpl;

public class ServicesServiceImpl implements ServicesService {
    private ServicesRepository servicesRepository;
    private  static ServicesServiceImpl instance;

    private ServicesServiceImpl(){
        servicesRepository = ServicesRepositoryImpl.getInstance();

    }

    public static ServicesService getInstance(){
        if(instance == null){
            instance = new ServicesServiceImpl();
        }
        return instance;
    }


    @Override
    public void changePrice(int serviceId, int price) {
        Service service = servicesRepository.get(serviceId);
        service.setPrice(price);
        servicesRepository.update(service);
    }

    @Override
    public void add(Service service) {
        servicesRepository.add(service);
    }

}
