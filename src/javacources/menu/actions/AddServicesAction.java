package javacources.menu.actions;

import javacources.controller.ServicesController;
import javacources.counstructor.Context;
import javacources.entitiy.MyId;
import javacources.entitiy.Room;
import javacources.entitiy.Service;
import javacources.menu.Action;
import javacources.menu.MyScanner;

public class AddServicesAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите цену номера: ");
        ServicesController.getInstance().addServices(MyScanner.getInstance().nextInt());
        MyScanner.getInstance().nextLine();
    }
}
