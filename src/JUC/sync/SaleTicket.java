package JUC.sync;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-02-12 14:38
 * @FilePath: TextDemo  ==> SaleTicket
 * 创建三个线程进行售票，购买系统中的30张票，购票方法使用synchronized字段修饰使线程同步执行，防止票数错乱
 */
public class SaleTicket {

    public static void main(String[] args) {
        taicket taicket = new taicket();
        //创建三个线程进行售票
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    taicket.sale();
                }
            }
        }, "AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    taicket.sale();
                }
            }
        }, "BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    taicket.sale();
                }

            }
        }, "CC").start();

    }
}

class taicket {
    //票数
    private int number = 30;

    // 购票方法
    public synchronized void sale() {
        //判断是否还有票
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + ": 卖出" + number-- + "剩下：" + number);
        } else {
            System.out.println("=========》》》》》》》》》》系统票数不足" + Thread.currentThread().getName() + "请选择其他系统进行购票！");
        }
    }

}

