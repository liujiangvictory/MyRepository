package JUC.sync;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-02-17 12:46
 * @FilePath: TextDemo  ==> Threaddome1
 * 创建两个线程，一个线程做+1，一个线程做-1，两个线程相互交替执行（使用synchronized实现）
 */
public class Threaddome1 {
    public static void main(String[] args) {
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

//创建资源类，定义属性跟操作方法
class Share {
    //初始值
    private  int number = 0;

    //+1的方法
    public synchronized void incr() throws InterruptedException {
        //判断，干活，通知
        if (number != 0) {
            System.out.println(Thread.currentThread().getName() + "线程准备进行+1操作阻塞");
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "进行+1操作::" + number);
        this.notifyAll();  //唤醒所有线程
    }

    //-1的方法
    public synchronized void decr() throws InterruptedException {
        //判断，干活，通知
        if (number != 1) {
            System.out.println(Thread.currentThread().getName() + "线程准备进行-1操作阻塞");
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "进行-1操作::" + number);
        this.notifyAll();  //唤醒所有线程
    }
}

