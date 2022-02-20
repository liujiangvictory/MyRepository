package arithmetic.day02;

import java.util.Arrays;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-23 10:32
 * @FilePath: TextDemo  ==> linkedlist01
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组
 * 要求也按 非递减顺序 排序。
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class linkedlist01 {
    /*例子：
    * 输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
    *
    * 思路：
    *1、先开平方
    *2、再排序
    * */
    public static void main(String[] args) {
     int [] num =  {-4,-1,0,3,10};
       for (int i :sortedSquares(num)){
           System.out.println(i);
       }

    }

    public static int[] sortedSquares(int[] nums) {
        for (int i =0 ;i <nums.length ; i++){
            nums[i] = nums[i]*nums[i];
        }

        Arrays.sort(nums);
        return nums;

    }
}
