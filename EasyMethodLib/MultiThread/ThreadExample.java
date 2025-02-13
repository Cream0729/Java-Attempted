package EasyMethodLib.MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        if (false) {
            MyThread trd1 = new MyThread();
            MyThread trd2 = new MyThread();
            trd1.setName("Trd1: ");
            trd2.setName("Trd2: ");
            trd1.start();
            trd2.start();
        }

        if (false) {
            MyRunnable trd1 = new MyRunnable();
            MyRunnable trd2 = new MyRunnable();
            Thread t1 = new Thread(trd1);
            Thread t2 = new Thread(trd2);
            t1.setName("T1: ");
            t2.setName("T2: ");
            t1.start();
            t2.start();
        }

        if (true) {
            MyCallable mc = new MyCallable();
            FutureTask<Integer> ft = new FutureTask<Integer>(mc);
            Thread t1 = new Thread(ft);
            t1.start();
            System.out.println(ft.get());
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + i);
        }
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}