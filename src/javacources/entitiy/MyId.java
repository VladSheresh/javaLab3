package javacources.entitiy;

public class MyId {
    private static int id;

    public static int generationId() {
        return id++;
    }
}
