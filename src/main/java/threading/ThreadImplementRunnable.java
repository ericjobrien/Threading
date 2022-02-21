package threading;

public class ThreadImplementRunnable implements Runnable{

    int threadlNum;
    int timeMillis;

    public ThreadImplementRunnable(int threadlNum, int timeMillis) {
        this.threadlNum = threadlNum;
        this.timeMillis = timeMillis;
    }

    public void run() {

        try {
            Thread.sleep(timeMillis);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from thread " + threadlNum);
    }
}
