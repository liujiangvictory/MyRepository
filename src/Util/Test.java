package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Jason
 * @create 2021-04-01 16:34
 */
public class Test {


    public static void main(String[] args) {
        /*Stream<String> stream = Arrays.stream(args);
            stream.forEach(System.out::println);*/
        List list = new ArrayList(0);
        /*list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");*/
        list.forEach(System.out::print);

    }
}
