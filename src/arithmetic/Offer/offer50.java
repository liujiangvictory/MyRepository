package arithmetic.Offer;

import java.util.HashMap;

/**
 * @Title: 第一个只出现一次的字符
 * @author: Liu jiang
 * @Date: 2022-05-22 20:01
 * @FilePath: TextDome  ==> offer50
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 * 限制：
 * 0 <= s 的长度 <= 50000
 */
public class offer50 {


    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(firstUniqChar(str));
    }
    /*
        1. 新建 HashMap dic。
        2. 将字符串s转为字符数组。
        3. 遍历字符数组，判断dic中是否存在 c。
           1)存在添加键值对（c, false）
           2)不存在添加键值对（c, true）
        4. 找到第一个为true的字符。
    */
    public static char firstUniqChar(String s) {
        //此处一定要使用泛型，不然后面get的时候会报错转换错误
        HashMap<Character, Boolean> map = new HashMap();
        char[] cs = s.toCharArray();
        for(char c : cs){
            map.put(c,!map.containsKey(c));
        }
        for(char c : cs){
            if(map.get(c)) return c;
        }
        return ' ';
    }
}
