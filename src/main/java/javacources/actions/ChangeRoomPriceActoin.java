package javacources.actions;

import javacources.controller.RoomController;
import javacources.utils.MyScanner;

public class ChangeRoomPriceActoin implements Action {
    @Override
    public void execute() {
        System.out.print("Введите id номера: ");
        int id = MyScanner.getInstance().nextInt();
        MyScanner.getInstance().nextLine();
        System.out.print("Введите новую цену для номера: ");
        int price = MyScanner.getInstance().nextInt();
        MyScanner.getInstance().nextLine();
        RoomController.getInstance().changePrice(id, price);
    }
}
