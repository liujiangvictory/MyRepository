package jihe.list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-11-28 21:09
 * @FilePath: TextDemo  ==> arrayList
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class arrayList {

    public static void main(String[] args) {


        List list = new ArrayList<>(0);
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");

        System.out.println(list);


    }




/*

    public static void mainCopyOnWriteArrayList(String[] args) {
        // ArrayList arrayList = new ArrayList();
        List<String> arrayList =  Collections.synchronizedList(new ArrayList());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                //向集合添加数据
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(arrayList);
            }, String.valueOf(i)).start();
        }
    }
*/


}
