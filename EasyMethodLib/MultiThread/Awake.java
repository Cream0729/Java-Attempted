package EasyMethodLib.MultiThread;

public class Awake {
    public static int counter = 0;
    public static int full = 10;
    public static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println(">>> Starting Awake Thread");
        Aa awake1 = new Aa();
        Ba awake2 = new Ba();
        awake1.start();
        awake2.start();
    }
}

class Aa extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Awake.lock) {
                    if (Awake.full == 0) {
                        System.out.println("\n>>> Finished Awake Thread, break Aa");
                        break;
                    } else {
                        if (Awake.counter == 0) {
                            Awake.lock.wait();
                        } else {
                            Awake.counter--;
                            Awake.full--;
                            System.out.println("\nAa awake " + " -1, full:" + Awake.full + ", now:" + Awake.counter);
                            Awake.lock.notifyAll();
                        }
                    }
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Ba extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Awake.lock) {
                    if (Awake.full == 0) {
                        System.out.println("\n>>> Finished Awake Thread, break Ba");
                        break;
                    } else {
                        if (Awake.counter == 0) {
                            Awake.counter++;
                            System.out.println("\nBa awake " + " +1, full:" + Awake.full + ", now:" + Awake.counter);
                            Awake.lock.notifyAll();
                        } else {
                            Awake.lock.wait();
                        }
                    }
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}