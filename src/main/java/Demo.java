public class Demo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Task 1");
        GoThread.workTime = 20;
        Thread t1 = new Thread(new GoThread.SecRunnable());
        Thread t2 = new Thread(new GoThread.FiveSecRunnable());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nTask 2");

        new Thread(new FizzBuzzNum(20)).start();

    }

}
