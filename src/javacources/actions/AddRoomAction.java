package javacources.actions;

import javacources.controller.RoomController;
import javacources.utils.MyScanner;

// добавить номер
public class AddRoomAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите цену номера: ");
        RoomController.getInstance().addRoom(MyScanner.getInstance().nextInt());
        MyScanner.getInstance().nextLine();
    }
}
