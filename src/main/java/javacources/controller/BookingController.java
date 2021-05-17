package javacources.controller;

import javacources.api.services.BookingService;
import javacources.api.services.GuestService;
import javacources.api.services.RoomService;
import javacources.api.services.ServicesService;
import javacources.entitiy.Booking;
import javacources.entitiy.Guest;
import javacources.entitiy.GuestAndRoom;
import javacources.entitiy.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private ServicesService servicesService;

    public void addBooking(int roomId, List<Integer> guestsId, Map<Integer, List<Integer>> servicesGuest, String dateCheckIn, String dateCheckOut){
        roomService.settleInRoom(roomId);
        Booking booking =  new Booking();
        booking.setRoom(roomService.get(roomId));
        guestsId.forEach(x -> booking.getGuests().add(guestService.get(x)));
        booking.setServiceGuest(getServicesGuest(servicesGuest, guestsId));
        booking.setDateCheckIn(getDate(dateCheckIn));
        booking.setDateCheckOut(getDate(dateCheckOut));
        bookingService.add(booking);
    }

    public void getFreeRoomsByDate(String date){
        bookingService.getFreeListByDate(getDate(date));
    }

    public int getPriceRoomForGuest(int guestId){
        return bookingService.getPrice(guestId);
    }

    public List<Booking> getRoomGuestHistory(int roomId){
        return bookingService.getGuestHistory(roomId);
    }
    public Booking getRoomData(int roomId){
        return bookingService.getData(roomId);
    }

    public List<GuestAndRoom> getSortGuestAndRoom(){
        return bookingService.getSortGuestAndRoom();
    }

    public List<Services> getSortGuestServices(int guestId){
       return bookingService.getSortGuestServices(guestId);// спросить
    }

    public void updateStatusRoom(){
        bookingService.updateStatusRoom();
    }

    private LocalDate getDate(String s){
        String[] date = s.split(".");
        return LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
    }


    private Map<Guest, List<Services>> getServicesGuest(Map<Integer, List<Integer>> listMap, List<Integer> guestsId){
        Map<Guest, List<Services>> servicesGuest = new HashMap<>();
        for(int i = 0; i < listMap.size(); i++){
            List<Services> services = new ArrayList<>();
            for(int id : listMap.get(guestsId.get(i))){
                services.add(servicesService.get(id));
            }
            servicesGuest.put(guestService.get(guestsId.get(i)), services);
        }
        return servicesGuest;
    }
}
