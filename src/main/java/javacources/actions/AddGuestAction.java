package javacources.actions;

import javacources.controller.GuestController;
import javacources.utils.MyScanner;

public class AddGuestAction implements Action{
    @Override
    public void execute() {
        System.out.print("Введите имя гостя: ");
        GuestController.getInstance().addGuest(MyScanner.getInstance().nextLine());
    }
}
