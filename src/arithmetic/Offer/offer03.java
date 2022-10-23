package arithmetic.Offer;

import java.util.HashSet;

/**
 * @Title: 数组中重复的数字
 * @author: Liu jiang
 * @Date: 2022-05-22 19:04
 * @FilePath: TextDome  ==> offer03
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 * 2 <= n <= 100000
 */
public class offer03 {


    /*
        1. 新建 HashSet set。
        2. 遍历 nums。
           1) num在set中，说明重复则返回num。
           2)不在set中，将num添加到set中。
    */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i] ;
            }else{
                set.add(nums[i]);
            }
        }
        //没有重复的数据返回-1
        return -1;
    }

}
