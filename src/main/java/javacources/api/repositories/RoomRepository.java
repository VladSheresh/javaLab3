package javacources.api.repositories;

import javacources.entitiy.Room;

import java.util.List;

public interface RoomRepository extends AbstractRepository<Room> {
    int getCount();
    List<Room> getAllFree();

}
