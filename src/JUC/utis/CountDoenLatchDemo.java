package JUC.utis;

import java.util.concurrent.CountDownLatch;

public class CountDoenLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDoenLatch = new CountDownLatch(5);

        //创建6个线程
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 号同学离开教室");
                //计数器减一
                 countDoenLatch.countDown();

            }, String.valueOf(i)).start();
        }
        //等待大家都出教师班长再锁门离开
         countDoenLatch.await();
        System.out.println(Thread.currentThread().getName() + " 班长锁门走人了");
    }


}
