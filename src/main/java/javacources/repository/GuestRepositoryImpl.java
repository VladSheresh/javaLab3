package javacources.repository;

import javacources.api.ds.BookingDataStorage;
import javacources.api.ds.GuestDataStorage;
import javacources.api.repositories.GuestRepository;
import javacources.entitiy.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestRepositoryImpl extends AbstractRepositoryImpl<Guest> implements GuestRepository {

    @Autowired
    protected GuestRepositoryImpl(GuestDataStorage guestDataStorage) {
        super(guestDataStorage);
    }
}
