package arithmetic.competition.week275;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title:最少交换次数来组合所有的 1 II
 * @author: Liu jiang
 * @Date: 2022-01-10 19:57
 * @FilePath: TextDemo  ==> test02
 *交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
 *
 * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
 *
 * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
 * 示例 1：
 *
 * 输入：nums = [0,1,0,1,1,0,0]
 * 输出：1
 * 解释：这里列出一些能够将所有 1 聚集在一起的方案：
 * [0,0,1,1,1,0,0] 交换 1 次。
 * [0,1,1,1,0,0,0] 交换 1 次。
 * [1,1,0,0,0,0,1] 交换 2 次（利用数组的环形特性）。
 * 无法在交换 0 次的情况下将数组中的所有 1 聚集在一起。
 * 因此，需要的最少交换次数为 1 。
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,0,1,1,0]
 * 输出：2
 * 解释：这里列出一些能够将所有 1 聚集在一起的方案：
 * [1,1,1,0,0,0,0,1,1] 交换 2 次（利用数组的环形特性）。
 * [1,1,1,1,1,0,0,0,0] 交换 2 次。
 * 无法在交换 0 次或 1 次的情况下将数组中的所有 1 聚集在一起。
 * 因此，需要的最少交换次数为 2 。
 * 示例 3：
 *
 * 输入：nums = [1,1,0,0,1]
 * 输出：0
 * 解释：得益于数组的环形特性，所有的 1 已经聚集在一起。
 * 因此，需要的最少交换次数为 0 。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 为 0 或者 1
 */
public class test02 {
    public static void main(String[] args) {
        test02 test = new test02();
        int [] i = {1,0,0,1,0,0};
        System.out.println(test.minSwaps(i));

    }

    /* 思路：1
     * 我们先遍历一遍这个nums数组，找到有几个1的值，然后我们把这个值作为滑动窗口的大小。
     * 我们用一个双向队列来维护这个滑动窗口，先把数组前n个放入窗口并且记录当前里面1的个数。
     * 当窗口滑动时维护count的值，当count增长的时候与最大值比较取最大值。
     * 当窗口滑到尽头的时候，我们开始从nums[0]开始往窗口放入值，值得注意的是：
     * 我们的窗口一共滑动了Length-1次，边界问题一定要注意。
     * 当窗口滑动完之后我们取max最大值作为开始 一共需要替换n-max次就可以得到答案了。*/

    public int minSwaps(int[] nums) {
        int l=nums.length;
        int n=0; //记录数组有多少个1
        //第一次遍历找到有多少个1的值
        for(int i:nums){
            if(i==1) n++;
        }
        //特殊情况，数组全为0或者全为0
        if(n==0 || n==l) return 0;
        int max=0;
        int count=0;
        Deque<Integer> queue =new LinkedList<>();
        //先初始化我们的窗口，即数组的前n个值
        for(int i=0;i<n;i++){
            queue.offerLast(nums[i]);
            if(nums[i]==1) count++;
        }
        max=count;
        int temp=0;

        for(int i=n;i<l+n-1;i++){
            if(i<l){
                temp=queue.pollFirst();
                if(temp==1) count--;
                queue.offerLast(nums[i]);
                if(nums[i]==1){
                    count++;
                    max=Math.max(max,count);
                }
                //当窗口到头时，开始从前面                                                                                                          滑动。
            }else{
                temp=queue.pollFirst();
                if(temp==1) count--;
                queue.offerLast(nums[i-l]);
                if(nums[i-l]==1){
                    count++;
                    max=Math.max(max,count);
                }
            }
        }
        return n-max;
    }

    /*思路2、
    * 统计1的数量ones，这个就是窗口长度
    可以维护一个长度为ones的队列，目的是为了知道队首和队尾的元素，后来发现，其实双指针就可以，一个指向队首，一个指向队尾
    因为数字只有0和1，那么求和即可，入队为“+” 出队为“-”
    最终返回ones - 和最大的窗口
    * */
    public int minSwaps1(int[] nums) {
        int ones = 0;
        int[] dp = new int[nums.length];
        int max = 0;
        // 统计1的数量
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
            }
        }
        // 如果没有1， 或者全是1，则不需要移动，直接返回即可
        if (ones == nums.length || ones == 0) {
            return 0;
        }
        // 计算dp[0]
        for (int i = 0; i < ones; i++) {
            dp[0] += nums[i];
        }
        max = dp[0];
        // 计算dp[i]
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] - nums[i - 1] + nums[(i + ones - 1) % nums.length];
            max = Math.max(dp[i], max);
        }
        return ones - max;
    }

}
