package Util.list;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-06-28 11:06
 * @FilePath: TextDemo  ==> arraylistRTest
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class arraylistTest {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(objects.size());
        System.out.println();
        CopyOnWriteArrayList<Object> onWriteArrayList = new CopyOnWriteArrayList<>();
    }
}
