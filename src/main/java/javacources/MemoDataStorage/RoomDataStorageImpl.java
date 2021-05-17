package javacources.MemoDataStorage;

import javacources.api.ds.AbstractDataStorage;
import javacources.api.ds.RoomDataStorage;
import javacources.entitiy.Booking;
import javacources.entitiy.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomDataStorageImpl extends AbstractDataStorageImpl<Room>
        implements RoomDataStorage {
}
