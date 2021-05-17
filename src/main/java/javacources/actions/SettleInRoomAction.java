package javacources.actions;

import javacources.controller.BookingController;
import javacources.controller.RoomController;
import javacources.entitiy.Booking;
import javacources.utils.MyScanner;

import java.util.*;

public class SettleInRoomAction implements Action {
    @Override
    public void execute() {
        System.out.print("Введите id номера: ");
        Scanner scanner = MyScanner.getInstance();
        int roomId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите количество гостей: ");
        int countGuest = scanner.nextInt();
        scanner.nextLine();
        List<Integer> guestId = new ArrayList<>();
        Map<Integer, List<Integer>> servicesGuest = new HashMap<>();
        for(int i = 0; i < countGuest; i++){
            System.out.print("Введите id для " + i + " гостя: ");
            guestId.add(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Введите количество услуг: ");
            int countServices = scanner.nextInt();
            scanner.nextLine();
            List<Integer> servicesId = new ArrayList<>();
            for(int j = 0; j < countServices; j++){
                System.out.print("Введите id для " + j + " услуги: ");
                servicesId.add(scanner.nextInt());
                scanner.nextLine();
            }
            servicesGuest.put(guestId.get(i), servicesId);
        }

        System.out.print("Введите дату заселения: ");
        String dateCheckIn = scanner.nextLine();
        System.out.print("Введите дату выселения номера: ");
        String dateCheckOut = scanner.nextLine();
        BookingController.getInstance().addBooking(roomId, guestId, servicesGuest, dateCheckIn, dateCheckOut);
    }
}
