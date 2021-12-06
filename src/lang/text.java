package lang;

/**
 * @author Jason
 * @create 2021-03-14 17:35
 */
public class text {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();

        run.gc();

        System.out.println("最大的内存空间：" + run.maxMemory());

        System.out.println("总共可以使用的空间：" + run.totalMemory());

        System.out.println("当前的空余空间：" + run.freeMemory());

        String str = "";

        for (int i = 0; i < 10000; i++) {//产生垃圾

            str += i;

        }

        System.out.println("===========产生垃圾后==========");

        System.out.println("最大的内存空间：" + run.maxMemory());

        System.out.println("总共可以使用的空间：" + run.totalMemory());

        System.out.println("当前的空余空间：" + run.freeMemory());
        run.gc();
        System.out.println("======================================");
        System.out.println("最大的内存空间：" + run.maxMemory());

        System.out.println("总共可以使用的空间：" + run.totalMemory());

        System.out.println("当前的空余空间：" + run.freeMemory());
    }
}
