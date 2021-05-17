package javacources.entitiy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Booking extends BaseEntity{

    private List<Guest> guests;
    private Room room;
    private Map<Guest, List<Services>> serviceGuest;
    private LocalDate dateCheckIn;
    private LocalDate dateCheckOut;

    public List<Guest> getGuests() {
        if (guests == null) {
            guests = new ArrayList<>();
        }
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(LocalDate dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public LocalDate getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(LocalDate dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public Map<Guest, List<Services>> getServiceGuest() {
        return serviceGuest;
    }

    public void setServiceGuest(Map<Guest, List<Services>> serviceGuest) {
        this.serviceGuest = serviceGuest;
    }
}
