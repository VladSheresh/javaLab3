package javacources.controller;

import javacources.api.services.BookingService;
import javacources.api.services.GuestService;
import javacources.entitiy.Room;
import javacources.api.services.RoomService;
import javacources.entitiy.Status;
import javacources.service.BookingServiceImpl;
import javacources.service.GuestServiceImpl;
import javacources.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    public void addRoom(int price, int capacity, int countStars){
        Room room = new Room();
        room.setPrice(price);
        room.setCapacity(capacity);
        room.setCountStars(countStars);
        roomService.add(room);
    }

    public void changePrice(int roomId, int price){
        roomService.changePrice(roomId, price);
    }

    public void changeStatus(int roomId, Status status){
        roomService.changeStatus(roomId, status);
    }

    public void settleInRoom(int roomId){
        roomService.settleInRoom(roomId);
    }

    public void checkOutTheRoom(int roomId){
        roomService.checkOutTheRoom(roomId);
    }

    public int getCountFreeRooms(){
       return roomService.getFreeCount();
    }

    public List<Room> getSortRooms(){
        return roomService.getAllSorted();
    }

    public List<Room> getSortFreeRooms(){
        return roomService.getFreeSorted();
    }

    public List<Room> getSortPriceRooms(){
        return roomService.getPriceSorted();
    }
}
