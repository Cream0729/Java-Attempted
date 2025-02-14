package EasyMethodLib.MultiThread;

import java.util.concurrent.ArrayBlockingQueue;

@SuppressWarnings("ALL")
public class BlockingQueue {
    public static int count = 0;
    public static int empty = 0;
    public static int last = 40;

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        System.out.println(">>> Starting Blocking Queue");
        Aq a = new Aq(queue);
        Bq b = new Bq(queue);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }
}

@SuppressWarnings("ALL")
class Aq extends Thread {
    ArrayBlockingQueue<String> queue;

    public Aq(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (BlockingQueue.last == 0) {
                    System.out.println("\n>>> Aq thread finished");
                    break;
                } else {
                    BlockingQueue.last--;
                    queue.put(++BlockingQueue.empty + "");
                    System.out.println("\nAq had put, now has:" + queue.size()  + ", last:" + BlockingQueue.last);
                    //Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@SuppressWarnings("ALL")
class Bq extends Thread {
    ArrayBlockingQueue<String> queue;

    public Bq(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (BlockingQueue.last == 0 && queue.size() == 0) {
                    System.out.println("\n>>> Bq thread finished");
                    break;
                } else {
                    System.out.println("\nBq had take : " + queue.take());
                    //Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}