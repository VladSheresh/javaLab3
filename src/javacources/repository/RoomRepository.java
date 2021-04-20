package javacources.repository;

import javacources.entitiy.Room;

public interface RoomRepository {

    void addRoom(Room room);
    Room getRoom(int roomId);
}
