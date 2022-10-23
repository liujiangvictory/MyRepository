package jihe.list;


import java.util.*;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-11-28 21:09
 * @FilePath: TextDemo  ==> arrayList
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class arrayList {

    public int i1 ;
    public int i2 ;





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
        int i1 = list.size();
        ArrayList list1 = (ArrayList) ((ArrayList<?>) list).clone();
        list1.add(0,"a");



        System.out.println("list"+list);
        System.out.println("list1"+list1);


    }






    public  void mainCopyOnWriteArrayList(String[] args) {
        // ArrayList arrayList = new ArrayList();
        int i2 = this.i1;
        List<String> arrayList =  Collections.synchronizedList(new ArrayList());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                //向集合添加数据
                arrayList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(arrayList);
            }, String.valueOf(i)).start();
        }
    }



}
