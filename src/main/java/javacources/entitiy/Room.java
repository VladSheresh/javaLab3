package javacources.entitiy;

import java.util.List;
import java.util.Queue;

public class Room extends BaseEntity{
   private Status status;
   private int price;
   private int capacity;
   private int countStars;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        this.countStars = countStars;
    }

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

    @Override
    public String toString() {
        return String.format("цена: %d \tвместимость: %d \tколичество звёзд: %d\n ",
                price, capacity, countStars);// почкму id не могу использовать???
    }

}
