package JUC.Readwrite;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.lang.String;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-05-19 8:17
 * @FilePath: TextDome  ==> ReadWirteDemo
 */
public class ReadWirteDemo {
    public static void main(String[] args) {
        myCatche mycatche = new myCatche();
        //创建线程存放数据操作
        for (int i = 1; i < 6; i++) {
            final int num = i;

            new Thread(() -> {
                mycatche.put(String.valueOf(num), String.valueOf(num));

            }, String.valueOf(i)).start();
        }

        //创建线程取出数据操作
        for (int i = 1; i < 6; i++) {
            final int num = i;

            new Thread(() -> {
                mycatche.get(String.valueOf(num));

            }, String.valueOf(i)).start();
        }


    }


    public static class myCatche {
        //存放数据的集合
        private volatile Map<String, Object> map = new HashMap<String, Object>();
        ReentrantReadWriteLock lwLock = new ReentrantReadWriteLock();
        //放数据
        public void put(String key, Object value) {
            lwLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "正在写操作" + key);
                //暂停一会
                TimeUnit.SECONDS.sleep(5);
                //写数据
                map.put(key, value);
                System.out.println(Thread.currentThread().getName() + "写完了" + key);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lwLock.writeLock().unlock();
            }
        }

        //取数据
        public void get(String key) {
            lwLock.readLock().lock();
            try {
                Object result = null;
                System.out.println(Thread.currentThread().getName() + "正在读取操作" + key);
                //暂停一会
                TimeUnit.SECONDS.sleep(5);
                result = map.get(key);
                System.out.println(Thread.currentThread().getName() + "读取完成" + key);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                lwLock.readLock().unlock();
            }

        }

    }
}




