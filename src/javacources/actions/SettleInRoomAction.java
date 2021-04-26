package javacources.actions;

import javacources.controller.RoomController;
import javacources.utils.MyScanner;

public class SettleInRoomAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите id номера: ");
        RoomController.getInstance().settleInRoom(MyScanner.getInstance().nextInt());
        MyScanner.getInstance().nextLine();
    }
}
