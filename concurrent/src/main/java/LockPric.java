import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockPric {
    static ReentrantLock lock=new ReentrantLock();

    static ReentrantLock lock2=new ReentrantLock();
    public static void main(String[] args) {
        //重入式锁可重入操作
//       test1();

       //重入式锁响应中预防免死锁
//        test2();

        //LockSupport使用
//        test3();

        //Condition使用
        test4();
    }


    /**
     * Condition使用
     *
     */
    public static void test4(){
        final Lock lock=new ReentrantLock();
        final Condition condition = lock.newCondition();
        Runnable runnable = new Runnable() {
            public void run() {
                lock.lock();
                System.out.println("执行中");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("继续执行");
                lock.unlock();
            }
        };
        Thread t = new Thread(runnable);
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }

    /**
     * LockSupport使用
     */
    public static void test3(){
        Thread thread = new Thread(
                new Runnable() {
                    public void run() {
                        System.out.println("执行中");
                        System.out.println("wait");
                        LockSupport.park();
                        System.out.println("继续执行");
                    }
                }
        );
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.isInterrupted());
        LockSupport.unpark(thread);

    }

    /**
     * 重入式锁可重入操作
     */
    public static void test1(){
        Runnable runnable=new Runnable() {
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外部获取锁");
                reentrantFun();
                System.out.println(Thread.currentThread().getName()+"外部释放锁");
                lock.unlock();
            }
        };
        new Thread(runnable,"线程1").start();
        new Thread(runnable,"线程2").start();
    }

    /**
     * 重入式锁响应中预防免死锁
     */
    public static void test2(){
        Runnable runnable=new Runnable() {
            public void run() {
                try {
                    lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+"获取到lock");
                    Thread.sleep(500);
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+"获取到lock2");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+"中断");
                }finally {
                    if(lock.isHeldByCurrentThread()){
                        lock.unlock();
                        System.out.println(Thread.currentThread().getName()+"释放持有锁lock");
                    }
                    if(lock2.isHeldByCurrentThread()){
                        lock2.unlock();
                        System.out.println(Thread.currentThread().getName()+"释放持有锁lock2");
                    }
                }
            }
        };
        Runnable runnable2=new Runnable() {
            public void run() {
                try {
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+"获取到lock2");
                    Thread.sleep(500);
                    lock.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+"获取到lock");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+"中断");
                }finally {
                    if(lock.isHeldByCurrentThread()){
                        lock.unlock();
                        System.out.println(Thread.currentThread().getName()+"释放持有锁lock");
                    }
                    if(lock2.isHeldByCurrentThread()){
                        lock2.unlock();
                        System.out.println(Thread.currentThread().getName()+"释放持有锁lock2");
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable2);
        t1.start();t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //两线程各获取到一把锁，形成死锁，中断一个线程释放其中的一把锁即可
        t2.interrupt();
    }

    public static void reentrantFun(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"内部拿到重入锁,等待2s...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"内部释放锁");
        lock.unlock();
    }
}
