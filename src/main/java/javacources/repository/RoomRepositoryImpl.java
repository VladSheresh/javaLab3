package javacources.repository;

import javacources.MemoDataStorage.DataStorage;
import javacources.api.ds.RoomDataStorage;
import javacources.api.repositories.RoomRepository;
import javacources.entitiy.Room;
import javacources.entitiy.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoomRepositoryImpl extends AbstractRepositoryImpl<Room> implements RoomRepository {

    @Autowired
    public RoomRepositoryImpl(RoomDataStorage roomDataStorage) {
        super(roomDataStorage);
    }

    @Override
    public int getCount() {
        return storage.getAll().size();
    }

    @Override
    public List<Room> getAllFree() {
        return  storage.getAll().stream().filter(room -> room.getStatus() == Status.FREE).collect(Collectors.toList());///странно)))
    }
}
