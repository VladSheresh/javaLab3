package javacources.service;

import javacources.api.services.RoomService;
import javacources.entitiy.Room;
import javacources.entitiy.Status;
import javacources.api.repositories.RoomRepository;
import javacources.repository.RoomRepositoryImpl;

public class RoomServiceImpl implements RoomService {

    public RoomRepository roomRepository;
    private static RoomService instance;
    private RoomServiceImpl(){
        this.roomRepository = RoomRepositoryImpl.getInstance();
    }

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomServiceImpl();
        }
        return instance;
    }

    @Override
    public void add(Room room) {
        room.setStatus(Status.FREE);
        roomRepository.add(room);
    }

    @Override
    public void changePrice(int roomId, int price) {
        Room room = roomRepository.get(roomId);
        room.setPrice(price);
        roomRepository.update(room);
    }

    @Override
    public void changeStatus(int roomId, Status status) {
        Room room = roomRepository.get(roomId);
        if (room.getStatus() != Status.BUSY) {
            room.setStatus(status);
        } else {
            System.out.println("Этот номер занят!!!");
        }
    }

    @Override
    public void settleInRoom(int roomId) {
        Room room = roomRepository.get(roomId);
        if (room.getStatus() == Status.FREE) {
            room.setStatus(Status.BUSY);
        } else {
            System.out.println("Поселить в этот номер невозможно!!!");
        }
    }

    @Override
    public void checkOutTheRoom(int roomId) {
        Room room = roomRepository.get(roomId);
        if (room.getStatus() == Status.BUSY) {
            room.setStatus(Status.FREE);
        } else {
            System.out.println("Этот номер и так свобожен!!!");

        }
    }
}



