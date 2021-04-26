package javacources.controller;

import javacources.entitiy.Service;
import javacources.api.services.ServicesService;
import javacources.service.ServicesServiceImpl;

public class ServicesController {
    private ServicesService servicesService;
    private static ServicesController instance;

    private ServicesController(){
        servicesService = ServicesServiceImpl.getInstance();
    }

    public static ServicesController getInstance(){
        if(instance == null){
            instance = new ServicesController();
        }
        return instance;
    }

    public void addServices(int price){
        Service service = new Service();
        service.setPrice(price);
        servicesService.add(service);
    }

    public void changePrice(int serviceId, int price){

        servicesService.changePrice(serviceId, price);
    }
}
