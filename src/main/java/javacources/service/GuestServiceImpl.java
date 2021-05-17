package javacources.service;

import javacources.api.repositories.BookingRepository;
import javacources.api.repositories.GuestRepository;
import javacources.api.services.BookingService;
import javacources.api.services.GuestService;
import javacources.entitiy.Guest;
import javacources.repository.GuestRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl extends AbstractServiceImpl<Guest> implements GuestService {

    @Autowired
    protected GuestServiceImpl(GuestRepository guestRepository) {
        super(guestRepository);
    }

   // private GuestServiceImpl(){
    //    guestRepository = GuestRepositoryImpl.getInstance();
   // }

    @Override
    public int getCount() {
        return repository.getAll().size();
    }
}
