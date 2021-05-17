package javacources.actions;

public class ExitAction implements Action {

    @Override
    public void execute() {
        System.out.println("Шчасця-здароўя");
        System.exit(0);
    }
}
