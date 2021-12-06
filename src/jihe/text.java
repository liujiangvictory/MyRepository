package jihe;


import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jason
 * @create 2021-03-17 22:21
 */
class Text {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(0);
        list.add("qwe");
        list.add("qwe");
        list.add("qwe");
           /* list.forEach(System.out::println);
            list.forEach(obj -> System.out.println(obj));*/
       /* for (String ojb:list) {
               list.remove(0);
            System.out.println(ojb);
        }*/
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            list.remove(0);
            System.out.println(iterator.next());
        }


        Object obj = new Object();
        try {
            PrintStream printStream = new PrintStream("D:/text.txt");
             System.setOut(printStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /**
         * 整形数据可以使用>>进行除2的倍数进行运算 <<也可以 但特别需要注意数据溢出问题
         * 但是这能算是算数结果吗？ 最终结论 偶数可以放心使用
         */
        /*Integer i = 12345;

        System.out.println(9 >> 1);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE << 1);
        System.out.println(8 >>> 2);*/
       /* int i1 = 4;
        int j1 = 5;
        int i2 = 3;
        int j2 = 6;

        i1 |= j1;

        System.out.println("按位或结果： "+i1);

        i2 &= j2;

        System.out.println("按位与结果： "+i2);
*/

    }


}
