public class GoThread extends Thread{
    //Напишіть програму, яка кожну секунду відображає на екрані дані про час,
    // що минув від моменту запуску програми.
    //
    //Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Минуло 5 секунд.
    private static int time;
    public static int workTime;

    static class SecRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Time has passed");
            try {
                while (time<workTime) {
                    Thread.sleep(1000);
                    System.out.println((++time) + " sec");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Time is over");
        }

    }
    static class FiveSecRunnable implements Runnable{
        @Override
        public void run() {
            try {
                while (time < workTime-1) {
                    Thread.sleep(5000);
                    System.out.print("Five second have passed: ");
               }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
