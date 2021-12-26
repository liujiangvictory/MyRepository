package jihe.list;

import shuzu.Person;
import shuzu.test;

import java.util.ArrayList;

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
        ArrayList<Person> arrayList = new ArrayList<Person>();

        arrayList.add(new Person("关羽", 18));
        arrayList.add(new Person("张飞", 18));
        arrayList.add(new Person("赵云", 18));
        arrayList.add(new Person("黄忠", 18));
        arrayList.add(new Person("马超", 18));
       //     tolist(arrayList);
        //test.tolist2(arrayList);
        System.out.println(arrayList);
        /*for (Person item : arrayList) {
            arrayList.remove(item);
            System.out.println(item);
        }*/
        arrayList.forEach(obj ->
                        arrayList.remove(obj)
        );



        ArrayList  arrayListint = new ArrayList();

        arrayListint.add(new Integer(1));
        arrayListint.add(new Integer(2));
        arrayListint.add(new Integer(3));
        arrayListint.add(new Integer(4));
        arrayListint.add(new Integer(5));
        tolist(arrayList);
        System.out.println(arrayListint);






    }

       public static void tolist (ArrayList<Person> list){
           list.remove(0);
           list.get(1).setAge(50);
           list.add(new Person("刘备", 18));


       }

    public static void tolist1 (ArrayList list){
        list.remove(0);
        list.add(new Person("刘备", 18));
        list.add(new Integer(6));

    }

}
