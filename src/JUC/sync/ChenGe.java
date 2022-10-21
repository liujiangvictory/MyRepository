package JUC.sync;

public class ChenGe implements  Runnable {


    @Override
    public  void run() {
       synchronized (ChenGe.class){
           for (int i =0 ; i<10 ; i++){
               System.out.println("线程名："+Thread.currentThread().getName()+"    输出结果："+i);
           }
       }
    }



    public static void main(String[] args) {

        ChenGe chenGe1 = new ChenGe();
        ChenGe chenGe2 = new ChenGe();
        ChenGe chenGe3 = new ChenGe();
        new Thread(chenGe1).start();
        new Thread(chenGe2).start();
        new Thread(chenGe3).start();

    }
}
