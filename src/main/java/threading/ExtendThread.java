package threading;

public class ExtendThread extends Thread{

    int threadlNum;
    int timeMillis;
    BankAccount acct;
    int amt;

    public ExtendThread(int threadlNum, int timeMillis, BankAccount acct, int amt) {
        //thread constructor here
        this.threadlNum = threadlNum;
        this.timeMillis = timeMillis;
        this.acct = acct;
        this.amt = amt;
    }

    public void run() {
        //thread execution here
        try {
            Thread.sleep(timeMillis);
            deposit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from thread " + threadlNum);
    }
            /*
                Synchronized methods will only allow a single thread of this class to perform them at once
                This means that one thread will enter the synchronized block or method and this will *block* the
                further operation of a ny thread that reaches the point of the synchronized block until the thread
                occupying the block released control of synchronized
            */
    public synchronized void printHello() {
        try {
            Thread.sleep(timeMillis);
            System.out.println("Hello from thread " + threadlNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit() {
        acct.deposit(amt);
    }
}
