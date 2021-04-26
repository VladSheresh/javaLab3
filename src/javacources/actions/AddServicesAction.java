package javacources.actions;

import javacources.controller.ServicesController;
import javacources.utils.MyScanner;

public class AddServicesAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите цену номера: ");
        ServicesController.getInstance().addServices(MyScanner.getInstance().nextInt());
        MyScanner.getInstance().nextLine();
    }
}
