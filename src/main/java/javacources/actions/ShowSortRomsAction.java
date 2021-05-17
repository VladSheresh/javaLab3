package javacources.actions;

import javacources.controller.RoomController;

public class ShowSortRomsAction implements Action{
    @Override
    public void execute() {
        RoomController.getInstance().getSortRooms().forEach(x -> System.out.println(x.toString()));
    }
}
