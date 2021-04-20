package javacources.service;

import javacources.entitiy.Service;
import javacources.repository.ServicesRepository;
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
    public void addServices(int price) {
        Service service = new Service();
        service.setPrice(price);
        servicesRepository.addService(service);
    }

    @Override
    public void changePrice(int serviceId, int price) {
        Service service = servicesRepository.getService(serviceId);
        service.setPrice(price);
    }
}
