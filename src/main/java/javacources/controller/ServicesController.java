package javacources.controller;

import javacources.entitiy.Services;
import javacources.api.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping
    public Services ping() {
        return new Services();
    }


    public void addServices(int price){
        Services service = new Services();
        service.setPrice(price);
        servicesService.add(service);
    }

    public void changePrice(int serviceId, int price){

        servicesService.changePrice(serviceId, price);
    }

    public List<Services> getSortPriceServices(){
        return servicesService.getPriceSorted();
    }
}
