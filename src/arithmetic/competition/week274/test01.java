package arithmetic.competition.week274;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-01-07 19:10
 * @FilePath: TextDemo  ==> test01
 * 给你一个 仅 由字符 'a' 和 'b' 组成的字符串  s 。如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：s = "aaabbb"
 * 输出：true
 * 解释：
 * 'a' 位于下标 0、1 和 2 ；而 'b' 位于下标 3、4 和 5 。
 * 因此，每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：s = "abab"
 * 输出：false
 * 解释：
 * 存在一个 'a' 位于下标 2 ，而一个 'b' 位于下标 1 。
 * 因此，不能满足每个 'a' 都出现在每个 'b' 之前，所以返回 false 。
 * 示例 3：
 * <p>
 * 输入：s = "bbb"
 * 输出：true
 * 解释：
 * 不存在 'a' ，因此可以视作每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s[i] 为 'a' 或 'b'
 */
public class test01 {

    public static void main(String[] args) {
        test01 test01 = new test01();


        System.out.println(test01.checkString("aaabbb"));
        System.out.println(test01.checkString("abab"));
        System.out.println(test01.checkString("bbb"));


    }

    public boolean checkString(String s) {
        char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == 'b') {
                for (int j = i + 1; j < strs.length; j++) {
                    if (strs[j] == 'a') {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
