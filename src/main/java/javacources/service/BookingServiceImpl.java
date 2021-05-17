package javacources.service;

import javacources.api.ds.BookingDataStorage;
import javacources.api.repositories.BookingRepository;
import javacources.api.services.BookingService;
import javacources.api.services.RoomService;
import javacources.entitiy.*;
import javacources.repository.AbstractRepositoryImpl;
import javacources.repository.BookingRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl extends AbstractServiceImpl<Booking> implements BookingService {

    private final RoomService roomService;////////спроооооооооооооооооооооссиииииитттттьььььь

    @Autowired
    protected BookingServiceImpl(BookingRepository bookingRepository, RoomService roomService) {
        super(bookingRepository);
        this.roomService = roomService;
    }

    //private BookingServiceImpl() {
      //  bookingRepository = BookingRepositoryImpl.getInstance();
   // }




    @Override
    public List<GuestAndRoom> getSortGuestAndRoom() {
        List<GuestAndRoom> sortGuestsAndRooms = new ArrayList<>();

        for (Booking booking : repository.getAll()) {
            for (Guest guest : booking.getGuests()){
                GuestAndRoom guestAndRoom = new GuestAndRoom();
                guestAndRoom.setGuest(guest);
                guestAndRoom.setRoom(booking.getRoom());
                guestAndRoom.setDateCheckOut(booking.getDateCheckOut());
                sortGuestsAndRooms.add(guestAndRoom);
            }
        }
        Comparator<GuestAndRoom> nameComparator = Comparator.comparing(o -> o.getGuest().getName());
        Comparator<GuestAndRoom> dateComparator = (o1, o2) -> {
            return o1.getDateCheckOut().isAfter(o2.getDateCheckOut()) ? 1 : o1.getDateCheckOut().isEqual(o2.getDateCheckOut()) ? 0 : -1;
        };
        Comparator<GuestAndRoom> guestOrRoomComparator = nameComparator
                .thenComparing(dateComparator);
        return sortGuestsAndRooms.stream().sorted(guestOrRoomComparator).collect(Collectors.toList());
    }

    @Override
    public List<Services> getSortGuestServices(int guestId) {
        for (Booking booking : repository.getAll()) {
            for (Map.Entry<Guest, List<Services>> entry : booking.getServiceGuest().entrySet()) {
                if(entry.getKey().getId() == guestId){
                 return entry.getValue().stream().sorted(Comparator.comparingInt(Services::getPrice)).collect(Collectors.toList());//спросить
                }
            }
        }
        return null;
    }

    @Override
    public List<Room> getFreeListByDate(LocalDate date) {
        List<Room> bookings = repository.getAll().stream()//////////////////// date между checkin checkout
                .filter(x ->  x.getDateCheckIn().isBefore(date) || x.getDateCheckIn().isEqual(date) && x.getDateCheckOut().isAfter(date) || x.getDateCheckOut().isEqual(date))
                .map(Booking::getRoom)
                .collect(Collectors.toList());
        List<Room> freeRooms = roomService.getFreeLis();
        freeRooms.removeAll(bookings);// удаляем занятые комнаты
        return freeRooms;
    }

    @Override
    public int getPrice(int guestId) {
        for (Booking booking : repository.getAll()) {
            for (Guest guest : booking.getGuests()) {
                if (guest.getId() == guestId) {
                    return booking.getRoom().getPrice();
                }
            }
        }
        //bookingRepository.getAll().forEach(x -> x.getGuests().forEach(y -> y.getId() == guestId?  return ));
        return 0;
    }

    @Override
    public List<Booking> getGuestHistory(int roomId) {
        List<Booking> bookings = repository.getAll().stream().filter(x -> x.getRoom().getId() == roomId).collect(Collectors.toList());
        Comparator<Booking> dateComparator = (o1, o2) -> {
            return o1.getDateCheckOut().isAfter(o2.getDateCheckOut()) ? 1 : o1.getDateCheckOut().isEqual(o2.getDateCheckOut()) ? 0 : -1;
        };
        bookings = bookings.stream().sorted(dateComparator).collect(Collectors.toList());
        if (bookings.size() > 2) {
            bookings.subList(0, 2);
        }
        return bookings;
    }

    @Override
    public Booking getData(int roomId) {
        List<Booking> bookings = repository.getAll().stream().filter(x -> x.getRoom().getId() == roomId).collect(Collectors.toList());
        Comparator<Booking> dateComparator = (o1, o2) -> {
            return o1.getDateCheckOut().isAfter(o2.getDateCheckOut()) ? 1 : o1.getDateCheckOut().isEqual(o2.getDateCheckOut()) ? 0 : -1;
        };
        bookings = bookings.stream().sorted(dateComparator).collect(Collectors.toList());
        return bookings.get(0);///////////////////////////////////оооооооооаааааааааааааоаааааааааааоооооооооаааааа
    }

    @Override
    public void updateStatusRoom() {
        for (Booking booking : repository.getAll()) {
            if(booking.getDateCheckOut().isAfter(LocalDate.now())){
                booking.getRoom().setStatus(Status.FREE);
            }
        }
    }
}
