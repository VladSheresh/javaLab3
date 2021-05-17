package javacources.controller;

import javacources.api.services.GuestService;
import javacources.entitiy.Booking;
import javacources.entitiy.Guest;
import javacources.service.GuestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

    public void addGuest(String name){
        Guest guest = new Guest();
        guest.setName(name);
        guestService.add(guest);
    }
    public int getCountGuest(){
        return guestService.getCount();
    }
}
