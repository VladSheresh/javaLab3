package javacources.menu.actions;

import javacources.controller.RoomController;
import javacources.counstructor.Context;
import javacources.entitiy.Room;
import javacources.entitiy.Service;
import javacources.menu.Action;
import javacources.menu.MyScanner;

import java.util.List;

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
