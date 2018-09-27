package blockingQueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        Productor prod1 = new Productor(queue);
        Productor prod2 = new Productor(queue);
        Productor prod3 = new Productor(queue);
        Consumer consumer = new Consumer(queue);

        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();

        // 启动线程
        service.execute(prod1);
        service.execute(prod2);
        service.execute(prod3);
        service.execute(consumer);

        // 执行10s
        Thread.sleep(10 * 1000);
        prod1.stop();
        prod2.stop();
        prod3.stop();

        Thread.sleep(2000);
        // 退出Executor
        service.shutdown();
    }
}
