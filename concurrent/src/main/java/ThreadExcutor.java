import java.util.concurrent.*;

/**
 * 线程池的练习
 */
public class ThreadExcutor {
    public static void main(String[] args) {
        /**
         * 单列线程池
         */
//        ExecutorService single= Executors.newSingleThreadExecutor();
//        test(single);

        /**
         * 固定大小的线程池
         */
//        ExecutorService fixed=Executors.newFixedThreadPool(5);
//        test(fixed);
//        fixed.shutdown();

        /**
         * 可缓存线程池
         */
//        ExecutorService cache =Executors.newCachedThreadPool();
//        test(cache);



        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        /**
         * 调度线程池定时执行任务
         */
        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                System.out.println("又一次调度执行");
            }
        },2, TimeUnit.SECONDS);

        /**
         * 调度线程池循环调度 initialDelay初始调度时间 period调度间隔差
         */
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("又一次调度执行");
            }
        },0,2, TimeUnit.SECONDS);

    }

    public static void test(ExecutorService executorService){
        for(int i=0;i<10;i++){
            final int index=i;
            executorService.submit(new Runnable() {
                public void run() {
                    System.out.println(index+1+"个线程正在执行...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
