package javacources.service;

public interface RoomService {
    void addRoom(int price);

    void changePrice(int roomId, int price);

    void changeStatusToRepairs(int roomId);

    void changeStatusToServed(int roomId);

    void settleInRoom(int roomId);

    void checkOutTheRoom(int roomId);
}
