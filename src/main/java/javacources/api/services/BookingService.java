package javacources.api.services;

import javacources.entitiy.Booking;
import javacources.entitiy.GuestAndRoom;
import javacources.entitiy.Room;
import javacources.entitiy.Services;

import java.time.LocalDate;
import java.util.List;

public interface BookingService extends AbstractService<Booking>{
    List<GuestAndRoom> getSortGuestAndRoom();
    List<Services> getSortGuestServices(int guestId);
    List<Room> getFreeListByDate(LocalDate date);
    int getPrice(int guestId);
    List<Booking> getGuestHistory(int roomId);
    Booking getData(int roomId);
    void updateStatusRoom();
}
