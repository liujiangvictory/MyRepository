package shuzu;

import jihe.list.arrayList;
import sun.applet.Main;

import java.util.ArrayList;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-12-08 20:05
 * @FilePath: TextDemo  ==> test
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class test {

    public static void main(String[] args) {

      Person per [] =  {new Person("关羽", 18),
              new Person("张飞", 18),
              new Person("赵云", 18),
              new Person("黄忠", 18),
              new Person("马超", 18)} ;

      for (int i=0 ; i < per.length ; i++){
          System.out.print(per[i]);
      }

      int number [] = {1,2,3,4,5,6,7,8,9};

        for (int b=0 ; b < number.length ; b++){
            System.out.print(number[b]);
        }



    }

    public static void tolist (  Person per []){

            per[0] = null;
            per[1].setAge(50);

    }

    public static void tolist1 ( int per []){
        per[0] = 0;

        per[3] = 10;
    }

    public static void tolist2 (ArrayList<Person> list){
        list.remove(0);
        list.get(1).setAge(50);
        list.add(new Person("刘备", 18));


    }



}
