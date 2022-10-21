package JUC.sync;

/**
 * @BelongsPackage: JUC.sync
 * @Author: liuJiang
 * @CreateTime: 2022-09-20  10:16
 * @Description: TODO
 * @Version: 2.0
 *  * 一个关于线程的经典面试题，要求用三个线程，按顺序打印1,2,3,4,5.... 71,72,73,74, 75.
 *  * 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推,
 *  * 直到线程3打印到75。
 */
public class ThreadNum {
    public static void main(String[] args) {
        Num num = new Num();
         new Thread( ()->{
             try {
                 while (true){
                     num.printlnNum1();
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"AA").start();
        new Thread( ()->{
            try {
                while (true){
                    num.printlnNum2();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
        new Thread( ()->{
            try {
                while (true){
                    num.printlnNum3();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"CC").start();
    }
}


class Num {
    /*1代表第一个线程执行，2代表第二个线程执行，3代表第三个线程执行   */
    private volatile int  state  = 1;

    private volatile int number = 0;

    public  void printlnNum1() throws InterruptedException{
        if(number>=75){
            System.exit(0);
        }
            if (state == 1) {
                for (int i=1; i<=5 ; i++){
                    number++;
                    System.out.println(Thread.currentThread().getName() + "线程准备进行打印操作： " +number);
                }
                state = 2;
            }
    }
    public    void printlnNum2() throws InterruptedException{
        if(number>=75){
            System.exit(0);
        }
        if (state == 2) {
            for (int i=1; i<=5 ; i++){
                number++;
                System.out.println(Thread.currentThread().getName() + "线程准备进行打印操作： " +number);
            }
            state = 3;
        }
    }
    public    void printlnNum3() throws InterruptedException{
        if(number>=75){
            System.exit(0);
        }
        if (state == 3) {
            for (int i=1; i<=5 ; i++){
                number++;
                System.out.println(Thread.currentThread().getName() + "线程准备进行打印操作： " +number);
            }
            state = 1;
        }
    }
}

