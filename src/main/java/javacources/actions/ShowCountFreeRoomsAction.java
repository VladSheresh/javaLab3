package javacources.actions;

import javacources.controller.RoomController;

public class ShowCountFreeRoomsAction implements Action {

    @Override
    public void execute() {
        System.out.println("Количество свободных комнат: " + RoomController.getInstance().getCountFreeRooms());
    }
}
