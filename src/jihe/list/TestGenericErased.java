package jihe.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-06-02 23:59
 * @FilePath: TextDome  ==> TestGenericErased
 */
public class TestGenericErased {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("solo");

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(999);

        System.out.println("-------------------");
        System.out.println("输出字符串：" + list1);
        System.out.println("输出整数：" + list2);

        System.out.println("-------------------");
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());

        System.out.println("-------------------");
        System.out.println("判断list1和list2两个列表的类是否相同：" + (list1.getClass() == list2.getClass()));
    }
}
