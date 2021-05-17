package javacources.api.services;

import javacources.entitiy.Room;
import javacources.entitiy.Status;

import java.util.List;

public interface RoomService extends AbstractService<Room> {

    void changeStatus(int roomId, Status status);

    void settleInRoom(int roomId);

    void checkOutTheRoom(int roomId);

    void changePrice(int roomId, int price);

    int getFreeCount();

    List<Room> getAllSorted();

    List<Room> getFreeSorted();

    List<Room> getPriceSorted();

    List<Room> getFreeLis();
}
