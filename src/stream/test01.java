package stream;


import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: 刘江
 * @Date: 2021/6/8 9:33
 * @FilePath: TextDemo
 * @Good Mood: 今天又是美好的一天！
 * @Study Code: 今天你学习了吗？
 */
public class test01 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("武汉加油");
        list.add("中国加油");
        list.add("世界加油");
        list.add("世界加油");

        //过滤
       /* List<String> list1 = list.stream().filter(str -> str.contains("中")).collect(Collectors.toList());
          System.out.println(list1);*/

        // distinct() 去重    count()  获取stream流的元素个数
       /*long count = list.stream().distinct().count();
        System.out.println("count="+count);*/

        //去重方法
        /*final List<String> distinct = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);*/

        //limit  获取流中的指定个数数据
        /*List<String> limit = list.stream().limit(2).collect(Collectors.toList());
        System.out.println(limit);*/

        //skip   去掉流中的前指定个数据
       /* List<String> skip = list.stream().skip(2).collect(Collectors.toList());
        System.out.println(skip);*/

        //map() 对流中的元素进行统一操作   concat()在元素后面拼接字符串
        /*List<String> maped = list.stream().map(str -> str.concat("+厉害了我的国")).collect(Collectors.toList());
        System.out.println(maped);*/

           //faltmap()
       /* final Stream<Character> flamaper = list.stream().flatMap(str -> getCharacterByString(str));
         flamaper.forEach(System.out::print);

        System.out.println("\t");

        Stream<Stream<Character>> mapper = list.stream().map(str -> getCharacterByString(str));
         mapper.forEach(s-> s.forEach(c-> System.out.println(c)));
*/
        //字母排序   按照a-z进行排序
      /*
        List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        final List<String> zm = ZMlist.stream().sorted().collect(Collectors.toList());
        System.out.println(zm);

        //数字排序   按照小到大进行排序
        List<Integer> listnum = Arrays.asList(23,46,89,-0,1,8,55);
        final List<Integer> sor = listnum.stream().sorted().collect(Collectors.toList());
        System.out.println(sor);

        //汉字排序  根据汉字z-a进行排序
        List <String> stringList =  Arrays.asList("中国","美国","日本","新西兰","英国");
        final List<String> str = stringList.stream().sorted(Collections.reverseOrder(Collator.getInstance(Locale.CHINA))).collect(Collectors.toList());
        System.out.println(str);*/


       /*   判断流中是否包含指定元素，返回Boolean
       List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        boolean j = ZMlist.stream().anyMatch(s -> s == "j");
        System.out.println(j);*/

            //判断流中所有元素是否的满足条件
        /*List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        boolean j = ZMlist.stream().allMatch(s -> s.length()>0);
        System.out.println(j);*/

         //   判断流中所有元素是否都不满足条件
       /* List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        boolean j = ZMlist.stream().noneMatch(s -> s.length()>5);
        System.out.println(j);
*/

       /* List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        Optional<String> first = ZMlist.stream().findFirst();
        System.out.println(first.get());*/
        /*List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        for (int i=0 ; i<=100000 ;i++){
            Optional<String> first = ZMlist.parallelStream().findAny();
            System.out.println(first.get());
        } */

       /*
       List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        ZMlist.stream().forEach(System.out::print);
*/
   /* collect()   将流转换成其他形式  list   set   map
        List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        List<String> lists = ZMlist.stream().collect(Collectors.toList());
        Set<String> set = ZMlist.stream().collect(Collectors.toSet());
        Map<String, String> map = ZMlist.stream().collect(Collectors.toMap(v -> v, v -> v, (oldvalue, newvalue) -> newvalue));
        System.out.println("lists"+ lists);
        System.out.println("set"+ set);
        System.out.println("map"+map);*/

        //reduce()   将流中的元素反复结合起来得到一个结果
        /*List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        Optional<String> reduce = ZMlist.stream().reduce((acc, item) -> {
            return (acc + item).replace("a", "A");
        });
        System.out.println(reduce.get());*/

       /* List<String>  ZMlist = Arrays.asList("c","h","e","y","m","a","j","s");
        Optional<String> max = ZMlist.stream()
                .max((e1, e2) -> Double.compare(e1, e2.getSalary()));
        System.out.println(max.get());*/
    }

    /*@Title： 字符串转换成字符流
     * @Author Liu jiang
     * @Description //TODO
     * @Date 14:37 2021/6/12
     * @Param
     * @return
     *  加油马上可以回家了
     **/
    public static Stream<Character> getCharacterByString(String str) {
        ArrayList<Character> list = new ArrayList();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();

    }


    //创建stream类的几种方法
    public static void stam() {
        String[] arr = new String[]{"武汉1加油", "中国1加油", "世界1加油"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("武汉2加油", "中国2加油", "世界2加油");
        List<String> list = new ArrayList<>();
        list.add("武汉3加油");
        list.add("中国3加油");
        list.add("世界3加油");
        stream = list.stream();
        stream = stream.filter(element -> element.contains("中"));
        stream.forEach(System.out::println);
    }
}
