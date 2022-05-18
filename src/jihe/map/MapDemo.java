package jihe.map;

import java.util.HashMap;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-11-26 11:03
 * @FilePath: TextDemo  ==> MapDemo
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class MapDemo {
    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 计算 Shirt 的值
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }


}
