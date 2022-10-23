package jihe.map;

import java.util.*;

/**
 * @Title:  将map集合根据value进行倒序排序
 * @author: Liu jiang
 * @Date: 2022-06-30 22:15
 * @FilePath: TextDome  ==> story
 */
public class sort {
    public static void main(String[] args) {
        HashMap <String,Integer>map = new HashMap<String,Integer>();
        map.put("张三9",9);
        map.put("张三3",3);
        map.put("张三2",2);
        map.put("张三6",6);
        map.put("张三4",4);
        map.put("张三1",1);
        System.out.println("map = "+map);
        System.out.println("排序后的集合为："+sort.sorts(map));
    }
    public static HashMap<String, Integer> sorts(HashMap<String, Integer> map){
        List<Map.Entry<String, Integer>> mapValues = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        // 根据条件将list集合进行排序     s1-s2为升序，s2-s1为降序
        Collections.sort(mapValues, (s1, s2) -> s2.getValue() - s1.getValue());
        // 创建一个新的有序的HashMap子类的集合
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        // 将List中的数据存储到LinkedHashMap中
        for (Map.Entry<String, Integer> entry : mapValues) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        // 返回结果
        return linkedHashMap;
    }
}
