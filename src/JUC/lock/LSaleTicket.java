package JUC.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-02-13 21:15
 * @FilePath: TextDemo  ==> LSaleTicket
 */
public class LSaleTicket {
    public static void main(String[] args) {
        taicket taicket = new taicket();
        //创建三个线程进行售票
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                taicket.sale();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                taicket.sale();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                taicket.sale();
            }
        }, "CC").start();

    }

}


class taicket {
    //票数
    private int number = 30;

    //创建lock锁
    private final ReentrantLock lock = new ReentrantLock(true);

    // 购票方法
    public void sale() {
        lock.lock();
        //判断是否还有票
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + ": 卖出" + number-- + "剩下：" + number);
        } else {
            System.out.println("=========》》》》》》》》》》系统票数不足" + Thread.currentThread().getName() + "请选择其他系统进行购票！");
        }
        lock.unlock();
    }
}

