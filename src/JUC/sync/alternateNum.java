package JUC.sync;

/**
 * @BelongsPackage: JUC.sync
 * @Author: liuJiang
 * @CreateTime: 2022-09-20  14:22
 * @Description: TODO
 * @Version: 2.0
 * 实现两个线程交替打印1-100数字
 *
 *
 */
public class alternateNum {


   /* 方法一：
   public static void main(String[] args){
        Number number1 = new Number();
        Thread thread1 = new Thread(number1);
        Thread thread2 = new Thread(number1);
        thread1.setName("线程【1】");
        thread2.setName("线程【2】");
        thread1.start();
        thread2.start();
    }*/



    static volatile int flag =1;
    static volatile int num = 1;

    public static void main(String[] args) {
        mutilThreadPrintNumOdd m1 = new mutilThreadPrintNumOdd();
        mutilThreadPrintNumEven m2 = new mutilThreadPrintNumEven();
        mutilThreadPrintNumThree m3 = new mutilThreadPrintNumThree();
        Thread thread1 = new Thread(m1);
        Thread thread2 = new Thread(m2);
        Thread thread3 = new Thread(m3);
        thread1.setName("线程【1】");
        thread2.setName("线程【2】");
        thread3.setName("线程【3】");
        thread1.start();
        thread2.start();
        thread3.start();
    }
    /**
     * @Description
     * @author liuJiang
     * @date 2022/9/20 14:40
     * @param 方法二： 使用valatile标志位实现
     */
    public static class mutilThreadPrintNumOdd implements Runnable {
        @Override
        public void run() {
            while (num <= 100) {
                if (flag ==1) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    flag = 2;
                }
            }
        }
    }

    public static class mutilThreadPrintNumEven implements Runnable {
        @Override
        public void run() {
            while (num <= 100) {
                if (flag == 2) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    flag = 3;
                }
            }
        }
    }

    public static class mutilThreadPrintNumThree implements Runnable {
        @Override
        public void run() {
            while (num <= 100) {
                if (flag==3) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    flag = 1;
                }
            }
        }
    }

}

  /**
   * @Description
   * @author liuJiang
   * @date 2022/9/20 14:35
   * @para 方法一：通过synchronized 加锁和notify()、wait()机制可以实现两个线程的交替执行
   */
class Number implements Runnable{
    private int number = 1;

    @Override
    public void run(){
        while(true){
            /*锁当前对象  只有两个线程一个执行，一个等待，不存在锁竞争*/
            synchronized(this){
                this.notify();  //唤醒在等待中的所有线程
                if(number<=100){
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("线程名称"+Thread.currentThread().getName()+",number="+number);
                    number++;
                    try{
                        this.wait();  //将当前线程等待状态
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


