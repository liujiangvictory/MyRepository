package Util;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Jason
 * @create 2021-04-01 16:34
 */
public class Test {


    public static void main(String[] args) {
        Stream<String> stream = Arrays.stream(args);
            stream.forEach(System.out::println);
    }
}
