package javacources.repository;

import javacources.entitiy.Service;

public interface ServicesRepository {
    void addService(Service service);
    Service getService(int serviceId);
}
