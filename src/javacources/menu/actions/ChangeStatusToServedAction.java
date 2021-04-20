package javacources.menu.actions;

import javacources.controller.RoomController;
import javacources.counstructor.Context;
import javacources.entitiy.Room;
import javacources.entitiy.Status;
import javacources.menu.Action;
import javacources.menu.MyScanner;

import java.util.List;

public class ChangeStatusToServedAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите id номера: ");
        RoomController.getInstance().changeStatusToServed(MyScanner.getInstance().nextInt());
        MyScanner.getInstance().nextLine();
    }
}
