package javacources.entitiy;

import java.util.List;
import java.util.Queue;

public class Room extends BaseEntity{
   private Status status;
   private int price;
   private int capacity;
   private List<String> visitors;
   private Queue<String> visitorsHistory;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
