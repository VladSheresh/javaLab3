package javacources.actions;

import javacources.controller.RoomController;

public class ShowCountGuestAction implements Action{
    @Override
    public void execute() {
        System.out.println("Количество гстей: " + RoomController.getInstance().getCountFreeRooms());
    }
}
