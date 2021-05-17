package javacources.MemoDataStorage;

import javacources.api.ds.AbstractDataStorage;
import javacources.api.ds.BookingDataStorage;
import javacources.entitiy.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingDataStorageImpl extends AbstractDataStorageImpl<Booking>
        implements BookingDataStorage {
}
