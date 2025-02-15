package EasyMethodLib.MultiThread;

import java.util.concurrent.*;

import static EasyMethodLib.MultiThread.ThreadPool.count;

@SuppressWarnings("ALL")
public class ThreadPool {
    public static int count = 0;

    public static void main(String[] args) {
        if (true) {
            // 内置线程池
            ExecutorService executor = Executors.newFixedThreadPool(3);

            for (int i = 0; i < 10; i++) {
                executor.submit(new RunnableExample());
            }

            executor.shutdown();
        } else {
            // 自定义线程池
            ThreadPoolExecutor pool = new ThreadPoolExecutor(3, // 核心数量，>0
                    6,                                      // 最大线程数/最大并行数，>=核心数量
                    60,                                     // 空闲线程最大存活时间
                    TimeUnit.SECONDS,                       // 时间单位
                    new ArrayBlockingQueue<>(3),    // 任务队列
                    Executors.defaultThreadFactory(),       // 创建线程工厂
                    new ThreadPoolExecutor.AbortPolicy()    // 任务拒绝策略
            );

            for (int i = 0; i < 10; i++) {
                pool.submit(new RunnableExample());
            }

            pool.shutdown();
        }
    }
}

class RunnableExample implements Runnable {

    @Override
    public void run() {
        try {
            int fla = ++count;  // tips:这样做会线程不安全
            for (int i = 1; i <= 5 + fla * 3; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ", Finish:" + i + ", Thread num:" + fla);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}