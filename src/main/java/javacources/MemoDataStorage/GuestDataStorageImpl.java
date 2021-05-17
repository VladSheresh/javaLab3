package javacources.MemoDataStorage;

import javacources.api.ds.AbstractDataStorage;
import javacources.api.ds.GuestDataStorage;
import javacources.entitiy.Booking;
import javacources.entitiy.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestDataStorageImpl extends AbstractDataStorageImpl<Guest>
        implements GuestDataStorage {
}
