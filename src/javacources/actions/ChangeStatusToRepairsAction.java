package javacources.actions;

import javacources.controller.RoomController;
import javacources.entitiy.Status;
import javacources.utils.MyScanner;

public class ChangeStatusToRepairsAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите id номера: ");
        RoomController.getInstance().changeStatus(MyScanner.getInstance().nextInt(), Status.REPAIRS);
        MyScanner.getInstance().nextLine();
    }
}
