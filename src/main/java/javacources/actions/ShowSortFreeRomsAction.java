package javacources.actions;

import javacources.controller.RoomController;

public class ShowSortFreeRomsAction implements Action {
    @Override
    public void execute() {
        RoomController.getInstance().getSortFreeRooms().forEach(x -> System.out.println(x.toString()));
    }
}
