package javacources.repository;

import javacources.counstructor.Context;
import javacources.entitiy.MyId;
import javacources.entitiy.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    private List<Room> allRooms = new ArrayList<>();
    private static RoomRepository instance;

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepositoryImpl();
        }
        return instance;

    }

    private RoomRepositoryImpl() {

    }

    @Override
    public void addRoom(Room room) {
        room.setId(MyId.generationId());
        allRooms.add(room);
    }

    @Override
    public Room getRoom(int roomId) {
        for (int i = 0; i < allRooms.size(); i++) {
            Room room = allRooms.get(i);
            if (room.getId() == roomId) {
                return room;
            }
        }
        return null;
    }
}
