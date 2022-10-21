package JUC.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @BelongsPackage: JUC.atomic
 * @Author: liuJiang
 * @CreateTime: 2022-10-21  14:26
 * @Description: TODO
 * @Version: 2.0
 */

public class LongAdderCalcDemo {
    public static final int SIZE_THREAD = 50;
    public static final int _1w = 10000;

    public static void main(String[] args) throws InterruptedException {
        LongAdderTest clickNumber = new LongAdderTest();
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        CountDownLatch latch_synchronized = new CountDownLatch(SIZE_THREAD);
        CountDownLatch latch_AtomicInteger= new CountDownLatch(SIZE_THREAD);
        CountDownLatch latch_AtomicLong = new CountDownLatch(SIZE_THREAD);
        CountDownLatch latch_LongAdder = new CountDownLatch(SIZE_THREAD);
        CountDownLatch latch_LongAccumulator = new CountDownLatch(SIZE_THREAD);

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= SIZE_THREAD; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1w; j++) {
                        clickNumber.add_synchronized();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch_synchronized.countDown();
                }
            },String.valueOf(i)).start();
        }
        latch_synchronized.await();
        endTime = System.currentTimeMillis();
        System.out.println("synchronized花费时间："+ (endTime-startTime)+" 数值为："+clickNumber.number);


        startTime = System.currentTimeMillis();
        for (int i = 1; i <= SIZE_THREAD; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1w; j++) {
                        clickNumber.add_AtomicInteger();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch_AtomicInteger.countDown();
                }
            },String.valueOf(i)).start();
        }
        latch_AtomicInteger.await();
        endTime = System.currentTimeMillis();
        System.out.println("AtomicInteger花费时间："+ (endTime-startTime)+" 数值为："+clickNumber.atomicInteger.get());

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= SIZE_THREAD; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1w; j++) {
                        clickNumber.add_AtomicLong();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch_AtomicLong.countDown();
                }
            },String.valueOf(i)).start();
        }
        latch_AtomicLong.await();
        endTime = System.currentTimeMillis();
        System.out.println("AtomicLong花费时间："+ (endTime-startTime)+" 数值为："+clickNumber.atomicLong.get());

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= SIZE_THREAD; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1w; j++) {
                        clickNumber.add_LongAdder();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch_LongAdder.countDown();
                }
            },String.valueOf(i)).start();
        }
        latch_LongAdder.await();
        endTime = System.currentTimeMillis();
        System.out.println("LongAdder花费时间："+ (endTime-startTime)+" 数值为："+clickNumber.longAdder.longValue());

        startTime = System.currentTimeMillis();
        for (int i = 1; i <= SIZE_THREAD; i++) {
            new Thread(()->{
                try {
                    for (int j = 1; j <= 100*_1w; j++) {
                        clickNumber.add_longAccumulator();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch_LongAccumulator.countDown();
                }

            },String.valueOf(i)).start();
        }
        latch_LongAccumulator.await();
        endTime = System.currentTimeMillis();
        System.out.println("LongAccumulator花费时间："+ (endTime-startTime)+" 数值为："+clickNumber.longAccumulator.longValue());

    }



}


 class LongAdderTest {

        int number = 0;
        public synchronized void add_synchronized(){
            number++;
        }

        AtomicInteger atomicInteger = new AtomicInteger();
        public void add_AtomicInteger(){
            atomicInteger.incrementAndGet();
        }

        AtomicLong atomicLong = new AtomicLong();
        public void add_AtomicLong(){
            atomicLong.incrementAndGet();
        }

        LongAdder longAdder = new LongAdder();
        public void add_LongAdder(){
            longAdder.increment();
        }

        LongAccumulator longAccumulator = new LongAccumulator((x, y)->x+y,0);
        public void add_longAccumulator(){
            longAccumulator.accumulate(1);
        }
    }


