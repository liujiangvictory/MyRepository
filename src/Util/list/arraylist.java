package Util.list;

import java.util.*;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-06-27 22:32
 * @FilePath: TextDemo  ==> ArrayList
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class arraylist  {
      private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public arraylist(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Object> linkedList = new LinkedList<>();
        /*arrayList.add(new arraylist("qwe"))  ;
        ArrayList <arraylist> arr  = (ArrayList) arrayList.clone();
        arr.set(0, new arraylist("abc"));
        arr.get(0).setName("ABC");

        System.out.println("arrayList = "+arrayList.get(0).getName());
        System.out.println("arr = "+arr.get(0).getName());*/

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        List subArrayList = arrayList.subList(1, 2);
        arrayList.set(1, 6666);
        System.out.println(subArrayList.get(0));
        System.out.println(subArrayList.size());

         List ll = (List) Collections.unmodifiableCollection(arrayList);

    }
}
