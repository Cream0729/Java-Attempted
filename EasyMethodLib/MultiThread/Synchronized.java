package EasyMethodLib.MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("ALL")
public class Synchronized {
    public static void main(String[] args) {
        if (false) {// 方法一
            block b1 = new block();
            block b2 = new block();
            block b3 = new block();
            b1.start();
            b2.start();
            b3.start();
        } else if (false){    // 方法二
            blockMethod bm = new blockMethod();
            Thread t1 = new Thread(bm);
            Thread t2 = new Thread(bm);
            Thread t3 = new Thread(bm);
            t1.start();
            t2.start();
            t3.start();
        } else {
            Locked locked = new Locked();
            Thread t1 = new Thread(locked);
            Thread t2 = new Thread(locked);
            Thread t3 = new Thread(locked);
            t1.start();
            t2.start();
            t3.start();
        }
    }
}

@SuppressWarnings("ALL")
class block extends Thread {
    static int counter = 0;
    static final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (block.class) { // 同步代码块（或替换为本类中的lock<obj>）
                if (counter < 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + ++counter);
                } else {
                    break;
                }
            }
        }
    }
}

class blockMethod implements Runnable {
    static int counter = 0;

    @Override
    public void run() {
        while (true) {
            if (method()) break;
        }
    }

    public synchronized boolean method() {
        if (counter < 100) {
            System.out.println(Thread.currentThread().getName() + ": " + ++counter);
            return false;
        } else {
            return true;
        }
    }
}

class Locked implements Runnable {
    static int counter = 0;
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (counter == 100) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + ++counter);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}