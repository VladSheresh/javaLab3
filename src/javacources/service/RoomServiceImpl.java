package javacources.service;

import javacources.entitiy.Room;
import javacources.entitiy.Status;
import javacources.repository.RoomRepository;
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

    public void addRoom(int price) {
        Room room = new Room();
        room.setStatus(Status.FREE);
        room.setPrice(price);
        roomRepository.addRoom(room);
    }

    @Override
    public void changePrice(int roomId, int price) {
        Room room = roomRepository.getRoom(roomId);
        room.setPrice(price);
    }

    @Override
    public void changeStatusToRepairs(int roomId) {
        Room room = roomRepository.getRoom(roomId);
        if (room.getStatus() != Status.BUSY) {
            room.setStatus(Status.REPAIRS);
        } else {
            System.out.println("Этот номер занят!!!");
        }
    }

    @Override
    public void changeStatusToServed(int roomId) {
        Room room = roomRepository.getRoom(roomId);
        if (room.getStatus() != Status.BUSY) {
            room.setStatus(Status.SERVED);
        } else {
            System.out.println("Этот номер занят!!!");
        }
    }

    @Override
    public void settleInRoom(int roomId) {
        Room room = roomRepository.getRoom(roomId);
        if (room.getStatus() == Status.FREE) {
            room.setStatus(Status.BUSY);
        } else {
            System.out.println("Поселить в этот номер невозможно!!!");
        }
    }

    @Override
    public void checkOutTheRoom(int roomId) {
        Room room = roomRepository.getRoom(roomId);
        if (room.getStatus() == Status.BUSY) {
            room.setStatus(Status.FREE);
        } else {
            System.out.println("Этот номер и так свобожен!!!");

        }
    }
}



