public class FizzBuzzNum implements Runnable {
    int counter=1;
    int maxCount;

    public FizzBuzzNum(int maxCount) {
        this.maxCount = maxCount;
    }
    @Override
    public void run() {
        Thread n = new Thread(()->{
            try {
                num();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread f = new Thread(()->{
            try {
                fizz();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread b = new Thread(()->{
            try {
                buzz();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread fb = new Thread(()->{
            try {
                fizzbuzz();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        n.start();
        f.start();
        b.start();
        fb.start();
    }
    public synchronized void fizz() throws InterruptedException {
        while(counter<=maxCount) {
            if((counter % 3 == 0)&&(counter % 5 != 0)) {
                System.out.print(", fizz");
                notifyAll();
                counter++;
            } else {
                wait();
            }
        }
    }
    public synchronized void buzz() throws InterruptedException {
        while(counter<=maxCount) {
            if((counter % 5 == 0)&&(counter % 3 != 0)) {
                System.out.print(", buzz");
                notifyAll();
                counter++;
            } else {
                wait();
            }
        }
    }
    public synchronized void fizzbuzz() throws InterruptedException {
        while(counter<=maxCount) {
            if((counter % 5 == 0)&&(counter % 3 == 0)) {
                System.out.print(", fizzbuzz");
                notifyAll();
                counter++;
            } else {
                wait();
            }
        }
    }

    public synchronized void num() throws InterruptedException {
        while(counter<=maxCount) {
            if((counter % 5 != 0)&&(counter % 3 != 0)) {
                if(counter == 1) System.out.print(counter);
                else System.out.print(", " + counter);
                notifyAll();
                counter++;
            } else {
                wait();
            }
        }
    }
}
