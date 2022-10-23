package JUC.utis;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-05-18 17:05
 * @FilePath: TextDome  ==> SemaphoreDemo2
 */
public class SemaphoreDemo2 {
    public static void main(String[] args) {
        Semaphore  semaphoreLock2 = new Semaphore(2);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " in ");
                    semaphoreLock2.acquire(1);
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + " get Semaphore ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreLock2.release(1);
                }
                System.out.println(Thread.currentThread().getName() + " finshed.... ");
            }).start();
        }


        while (true){
            // 监控 block thread 数量 和  当前可用许可证
            System.out.println(" ql block  队列 中线程 数量: " + semaphoreLock2.getQueueLength());
            System.out.println(" ap 多少可用许可证 : " + semaphoreLock2.availablePermits()); //当前可用许可证
            System.out.println(" ----------------  ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    
}
