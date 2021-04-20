package javacources.main;

import javacources.counstructor.Context;
import javacources.counstructor.MainInitializer;
import javacources.menu.actions.AddRoomAction;
import javacources.menu.actions.ChangeRoomPriceActoin;
import javacources.service.RoomService;

public class TestClass {

    public static void main(String[] args){

        MainInitializer initializer = new MainInitializer();
        //initializer.init();
        Context.init();

        testAddRoomAction();
    }

    private static void testAddRoomAction() {
        new AddRoomAction().execute();
        new ChangeRoomPriceActoin().execute();
        //System.out.println(room.getId() + "  " + room.getPrice() + " " + room.getStatus());
    }
}
