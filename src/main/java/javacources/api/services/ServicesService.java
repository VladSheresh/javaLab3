package javacources.api.services;

import javacources.entitiy.Services;

import java.util.List;

public interface ServicesService extends AbstractService<Services> {

    void changePrice(int entityId, int price);

    List<Services> getPriceSorted();
}
