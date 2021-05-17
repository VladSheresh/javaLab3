package javacources.actions;

import javacources.controller.RoomController;
import javacources.utils.MyScanner;

// добавить номер
public class AddRoomAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите цену номера: ");
        int price = MyScanner.getInstance().nextInt();
        MyScanner.getInstance().nextLine();
        System.out.print("Введите вместимость номера: ");
        int capacity = MyScanner.getInstance().nextInt();
        MyScanner.getInstance().nextLine();
        System.out.print("Введите количество звёзд номера: ");
        int countStars = MyScanner.getInstance().nextInt();
        MyScanner.getInstance().nextLine();
        RoomController.getInstance().addRoom(price, capacity, countStars);
    }
}
