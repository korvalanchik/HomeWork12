public class Demo {
    public static void main(String[] args) {
        new Thread(new GoThread.SecRunnable()).start();
        new Thread(new GoThread.FiveSecRunnable()).start();
    }

}
