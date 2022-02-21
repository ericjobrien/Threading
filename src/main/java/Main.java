import threading.BankAccount;
import threading.ExtendThread;
import threading.ThreadImplementCallable;
import threading.ThreadImplementRunnable;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        BankAccount account = new BankAccount(500);

        ExtendThread t1 = new ExtendThread(1, 1000, account, 300);
        ExtendThread t2 = new ExtendThread(2, 1000, account, 200);

        ThreadImplementRunnable t3 = new ThreadImplementRunnable(3, 1000);
        ThreadImplementCallable t4 = new ThreadImplementCallable(4, 2500);

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> result; // a future is a container for an object that will exist in the future as a result of thread operation

        t1.start();// built-in method that is in core Java, hence the reason why we didn't write a method for this
        t2.start();
        es.submit(t3);
        result = es.submit(t4);
        System.out.println("Hello from main!");
        //Join - wait for the thread to finish execution
        t1.join();
        t2.join();
        System.out.println(result.get()); //get will also wait like join

        //shutdown waits for all threads in the pool to finish
        //shutdownNow forces the closing of all tasks, which can cause problems and exceptions to be thrown
        es.shutdown();
        es.awaitTermination(100, TimeUnit.MICROSECONDS);
        System.out.println("All threads finished.");
        System.out.println(account.getBalance());

    }
}
