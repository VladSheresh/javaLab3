package javacources.service;

import javacources.api.repositories.AbstractRepository;
import javacources.api.services.ServicesService;
import javacources.entitiy.Services;
import javacources.api.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesServiceImpl extends AbstractServiceImpl<Services> implements ServicesService {

    protected ServicesServiceImpl(ServicesRepository servicesRepository) {
        super(servicesRepository);
    }


    @Override
    public void changePrice(int serviceId, int price) {
        Services service = repository.get(serviceId);
        service.setPrice(price);
        repository.update(service);
    }

    @Override
    public List<Services> getPriceSorted() {
        return repository.getAll().stream().sorted(Comparator.comparing(Services::getPrice)).collect(Collectors.toList());
    }
}
