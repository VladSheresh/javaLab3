package javacources.api.services;

import javacources.entitiy.Room;

public interface RoomService extends AbstractService<Room> {

    void changeStatusToRepairs(int roomId);

    void changeStatusToServed(int roomId);

    void settleInRoom(int roomId);

    void checkOutTheRoom(int roomId);
}
