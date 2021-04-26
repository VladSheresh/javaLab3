package javacources.api.services;

import javacources.entitiy.Room;
import javacources.entitiy.Status;

public interface RoomService extends AbstractService<Room> {

    void changeStatus(int roomId, Status status);

    void settleInRoom(int roomId);

    void checkOutTheRoom(int roomId);
}
