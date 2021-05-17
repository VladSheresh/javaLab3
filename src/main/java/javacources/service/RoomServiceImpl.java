package javacources.service;

import javacources.MemoDataStorage.DataStorage;
import javacources.api.repositories.AbstractRepository;
import javacources.api.services.RoomService;
import javacources.entitiy.Room;
import javacources.entitiy.Status;
import javacources.api.repositories.RoomRepository;
import javacources.repository.RoomRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl extends AbstractServiceImpl<Room> implements RoomService {

    private final RoomRepository roomRepository;

    protected RoomServiceImpl(RoomRepository roomRepository) {
        super(roomRepository);
        this.roomRepository = roomRepository;
    }

    @Override
    public void changePrice(int roomId, int price) {
        Room room = roomRepository.get(roomId);
        room.setPrice(price);
        roomRepository.update(room);
    }

    @Override
    public int getFreeCount() {
        return roomRepository.getAllFree().size();
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

    @Override
    public List<Room> getAllSorted() {
        Comparator<Room> roomComparator = Comparator
                .comparingInt(Room::getPrice)
                .thenComparing(Room::getCapacity)
                .thenComparing(Room::getCountStars);
        return roomRepository.getAll().stream().sorted(roomComparator).collect(Collectors.toList());
    }

    @Override
    public List<Room> getFreeSorted() {
        Comparator<Room> roomComparator = Comparator
                .comparingInt(Room::getPrice)
                .thenComparing(Room::getCapacity)
                .thenComparing(Room::getCountStars);
        return roomRepository.getAllFree().stream().sorted(roomComparator).collect(Collectors.toList());
    }

    @Override
    public List<Room> getPriceSorted() {
        return roomRepository.getAll().stream().sorted(Comparator.comparingInt(Room::getPrice)).collect(Collectors.toList());
    }

    @Override
    public List<Room> getFreeLis() {
        return roomRepository.getAllFree();
    }
}



