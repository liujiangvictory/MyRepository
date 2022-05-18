package JUC.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threaddome2 {
        
    public static void main(String [] args ){
     Share share = new Share();
        //创建两个线程进行+1，-1操作
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();  // +1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();  //-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        //线程之间通信虚假唤醒问题   ，再创建两个线程CC进行+1,DD进行-1操作
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();  // +1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();  //-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }



}
class Share {
    int number = 0 ;

    //创建Lock
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //+1操作
    public void incr() throws InterruptedException {
        //上锁
        lock.lock();
        try{
        //判断
            while(number != 0){
                System.out.println(Thread.currentThread().getName() + "线程准备进行+1操作阻塞");
                condition.await();  //阻塞线程
            }
            //干活
            number ++;
            System.out.println(Thread.currentThread().getName() + "进行+1操作::" + number);
            condition.signalAll();  //唤醒所有线程
        }finally{
            lock.unlock();
        }
    }


    //-1操作
    public void decr() throws InterruptedException {
        //上锁
        lock.lock();
        try{
            //判断
            while(number != 1){
                System.out.println(Thread.currentThread().getName() + "线程准备进行-1操作阻塞");
                condition.await();  //阻塞线程
            }
            //干活
            number --;
            System.out.println(Thread.currentThread().getName() + "进行-1操作::" + number);
            condition.signalAll();  //唤醒所有线程
        }finally{
            lock.unlock();  //解锁
        }
    }

}