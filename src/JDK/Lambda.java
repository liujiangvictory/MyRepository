package JDK;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Jason
 * @create 2020-12-18 16:15
 */
public class Lambda {
    public static void main(String[] args) {
       /* System.out.println(args);
        System.out.println(args.length);
        System.out.println("fsakldhfjksan");

       Runnable b =  ()-> System.out.println("刘江");
        System.out.println(b.toString());*/
/*      List list =new ArrayList();
         list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("==========list=" + list.size());
        list.forEach(n-> System.out.println(n));*/

             /*   List <String>  lists = Arrays.asList("a","b","c","d");
        System.out.println("==========lists="+ lists.size());
       // lists.forEach(n-> System.out.println(n));
      for(String a :lists){
          System.out.println(a);
      }*/
       /* int []arr = new int[5];
        Arrays.fill(arr, 2);
        for(int i :arr){
            System.out.print(i);
        }*/

      /*  int []arr = {3,2,1,5,4};
        Arrays.sort(arr,0,arr.length);
        for(int i :arr){
            System.out.print(i);
        }*/

     /*   int []arr1 = {1,2,3};
        int []arr2 = {1,2,3};
        System.out.println(Arrays.equals(arr1,arr2));*/
/*

        int []arr = {10,100,500,20,1000,20,30,40,50};
        System.out.println(Arrays.binarySearch(arr, 20));
*/
  /*      String  str = "fdhdjkhf ,fhddjkfh ,jffhddjkdhf ,jfdhidf ,fudj ,";
        System.out.println("str="+str.replaceAll(",", ""));*/
        for (int i = 1; i < 10; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println("第" + i + "个id=" + uuid);
            System.out.println(uuid.length());
            char[] c = uuid.toCharArray();
            System.out.println("长度为" + c.length);
            System.out.println("长度为" + uuid.length());
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(formatter.format(date));
        String str = formatter.format(date);
        System.out.println(str);
    }
}
