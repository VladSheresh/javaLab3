package javacources.repository;

import javacources.api.repositories.RoomRepository;
import javacources.entitiy.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {
    private List<Room> allRooms = new ArrayList<>();
    private static RoomRepository instance;
    private MyId myId;

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepositoryImpl();
        }
        return instance;

    }

    private RoomRepositoryImpl() {
        myId = new MyId();
    }

    @Override
    public void add(Room room) {
        room.setId(myId.generationId());
        allRooms.add(room);
    }

    @Override
    public Room get(int roomId) {
//        for (Room room : allRooms) {
//            if (room.getId() == roomId) {
//                return room;
//            }
//        }
//        return null;
        return allRooms.stream().filter(room -> room.getId() == roomId).findFirst().orElse(null);
    }

    @Override
    public void update(Room updRoom) {
        allRooms.replaceAll(room -> {
            return updRoom.equals(room) ? updRoom : room;
        });
    }
}
