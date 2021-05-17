package javacources.actions;

import javacources.controller.ServicesController;
import javacources.utils.MyScanner;

public class ChangeServicesPriceAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите id услуги: ");
        int id = MyScanner.getInstance().nextInt();
        MyScanner.getInstance().nextLine();
        System.out.print("Введите новую цену для услуги: ");
        int price = MyScanner.getInstance().nextInt();
        MyScanner.getInstance().nextLine();
        ServicesController.getInstance().changePrice(id, price);
    }
}
