package javacources.actions;

import javacources.controller.RoomController;
import javacources.utils.MyScanner;

public class ChangeStatusToRepairsAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите id номера: ");
        RoomController.getInstance().changeStatusToRepairs(MyScanner.getInstance().nextInt());
        MyScanner.getInstance().nextLine();
    }
}
