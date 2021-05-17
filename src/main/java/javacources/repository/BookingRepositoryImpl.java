package javacources.repository;

import javacources.api.ds.AbstractDataStorage;
import javacources.api.ds.BookingDataStorage;
import javacources.api.repositories.BookingRepository;
import javacources.entitiy.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//сделать обстрактный класс и наследовать от него
@Repository
public class BookingRepositoryImpl extends AbstractRepositoryImpl<Booking> implements BookingRepository {

    @Autowired
    protected BookingRepositoryImpl(BookingDataStorage bookingDataStorage) {
        super(bookingDataStorage);
    }
}
