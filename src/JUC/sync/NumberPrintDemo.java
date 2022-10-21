package JUC.sync;

/**
 * @BelongsPackage: JUC.sync
 * @Author: liuJiang
 * @CreateTime: 2022-09-20  11:03
 * @Description: TODO
 * @Version: 2.0
 * 一个关于线程的经典面试题，要求用三个线程，按顺序打印1,2,3,4,5.... 71,72,73,74, 75.
 * 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推,
 * 直到线程3打印到75。
 */
public class NumberPrintDemo {
    public static void main(String[] args) {
        final Business business = new Business();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        business.print(Thread.currentThread().getName());
                    }
                }
            }, i + "").start();
        }
    }
}

class Business {

    private int number = 0;
    private int state = 1;

    public synchronized void print(String name) {
        int num = Integer.parseInt(name) + 1;
        while (state != num) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            number++;
            System.out.println("线程"+num + ":" + number);
        }
        state = state % 3 + 1;
        this.notifyAll();
    }
}
