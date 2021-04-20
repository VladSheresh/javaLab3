package javacources.menu.actions;

import javacources.controller.ServicesController;
import javacources.counstructor.Context;
import javacources.entitiy.Service;
import javacources.menu.Action;
import javacources.menu.MyScanner;

import java.util.List;

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
