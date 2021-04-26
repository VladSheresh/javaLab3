package javacources.controller;

import javacources.entitiy.Room;
import javacources.api.services.RoomService;
import javacources.service.RoomServiceImpl;

public class RoomController {
    private RoomService roomService;
    private static RoomController instance;

    private RoomController(){
     roomService = RoomServiceImpl.getInstance();
    }

    public static RoomController getInstance() {
        if(instance == null){
            instance = new RoomController();
        }
        return instance;
    }

    public void addRoom(int price){
        Room room = new Room();
        room.setPrice(price);
        roomService.add(room);
    }

    public void changePrice(int roomId, int price){
        roomService.changePrice(roomId, price);
    }

    public void changeStatusToRepairs(int roomId){
        roomService.changeStatusToRepairs(roomId);
    }

    public void changeStatusToServed(int roomId){
        roomService.changeStatusToServed(roomId);
    }

    public void settleInRoom(int roomId){
        roomService.settleInRoom(roomId);
    }

    public void checkOutTheRoom(int roomId){
        roomService.checkOutTheRoom(roomId);
    }
}
