package Util.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-06-30 13:13
 * @FilePath: TextDemo  ==> arraysTest
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class arraysTest {

    public static void main(String[] args) {
        String aa[] =  {"a","b","c","d"};
        List list = Arrays.asList(aa);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());

        long bb[] =  {1,2,3,4};
        List listbb = Arrays.asList(bb);
        System.out.println(listbb);
        System.out.println(listbb.get(0));
        System.out.println(listbb.size());

        List listc = Collections.emptyList();
        listc.add("C");

    }
}
