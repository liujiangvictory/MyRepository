package JUC.utis;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//演示6个汽车，停到3个停车位中的情况
public class SemaphoreDemo {
    public static void main(String[] arg) {
        Semaphore semaphore = new Semaphore(3);
        //创建6个线程
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                //计数器减一
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 号车子抢到车位");
                    int s = new Random().nextInt(10);
                    TimeUnit.SECONDS.sleep(s);
                    System.out.println(Thread.currentThread().getName() + " 号车子停车" + s + "秒后出去了");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }



}

}
