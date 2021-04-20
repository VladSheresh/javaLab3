package javacources.counstructor;

import javacources.service.RoomService;
import javacources.service.RoomServiceImpl;
import javacources.service.ServicesService;
import javacources.service.ServicesServiceImpl;
import javacources.repository.ServicesRepository;
import javacources.repository.ServicesRepositoryImpl;

public class Context {

    private static ServicesService servicesService;

    public static void init() {
    }
}
