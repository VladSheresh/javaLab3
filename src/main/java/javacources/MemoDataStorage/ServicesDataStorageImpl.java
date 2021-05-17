package javacources.MemoDataStorage;

import javacources.api.ds.AbstractDataStorage;
import javacources.api.ds.ServicesDataStorage;
import javacources.entitiy.Booking;
import javacources.entitiy.Services;
import org.springframework.stereotype.Component;

@Component
public class ServicesDataStorageImpl extends AbstractDataStorageImpl<Services>
        implements ServicesDataStorage {
}
