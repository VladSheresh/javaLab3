package javacources.menu.actions;

import javacources.controller.RoomController;
import javacources.counstructor.Context;
import javacources.menu.Action;
import javacources.menu.MyScanner;
import javacources.service.RoomServiceImpl;

// добавить номер
public class AddRoomAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите цену номера: ");
        RoomController.getInstance().addRoom(MyScanner.getInstance().nextInt());
        MyScanner.getInstance().nextLine();
    }
}
