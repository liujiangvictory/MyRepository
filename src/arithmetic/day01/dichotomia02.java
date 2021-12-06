package arithmetic.day01;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-22 20:43
 * @FilePath: TextDemo  ==> dichotomia02
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */

      /*  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
        如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

        请必须使用时间复杂度为 O(log n) 的算法。*/
/*    解题思路：
     情况：
1、查找值在数组的最大值与最小值之间
      查找值在数组中
      查找值不在数组中
2、查找值不在数组的最大值与最小值之间
      查找值小于数组最小值
      查找值大于数组最大值*/
public class dichotomia02 {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 2;
        /*int [] nums = {1};
        int target = 1;*/

      /*  int [] nums = {1,3};
        int target = 2;*/
        System.out.println(searchInsert(nums,target));
    }

   /* public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        //定义左，右下标
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            //定义中间下标
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }*/

    public static int searchInsert(int[] nums, int target) {
        if(target>=nums[0]&&target<=nums[nums.length-1]) {
//        前面一种情况：查找值在数组的最大值与最小值之间
            boolean boo = false;  //定义一个值判断是否在数组中找到数据需要查找值
            //定义头，尾，中节点
            int sIndex = 0, eIndex = nums.length - 1, mIndex = 0;
            //二分查找,在数组中查找改数据
            while (sIndex <= eIndex) {
                mIndex = (sIndex + eIndex) / 2;
                if (nums[mIndex] < target) {
                    sIndex = mIndex+1;
                } else if (nums[mIndex] > target) {
                    eIndex = mIndex -1;
                } else {
                    boo = true;
                    break;
                }
            }
            //判断是否在数组中查到该值，找到返回中间值，没有找到返回头下标
            if (boo) {
                return mIndex;
            } else {
                return sIndex;
            }
        }else{
            //第二种情况：查找值不在数组的最大值与最小值之间
            if(target<nums[0]){
                return 0;
            }else{
                return nums.length;
            }
        }
    }
}

