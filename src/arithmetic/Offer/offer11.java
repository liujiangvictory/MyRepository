package arithmetic.Offer;

/**
 * @Title:旋转数组的最小数字
 * @author: Liu jiang
 * @Date: 2022-05-22 19:54
 * @FilePath: TextDome  ==> offer11
 */
public class offer11 {
/*
	1. 旋转排序数组是局部有序的，从旋转点分开可分成左排序数组和右排序数组。
	2. 用二分法寻找旋转点。
	3. i,j 指向数组的两端，m = (i+j)/2
	4. if(nums[m] > nums[j]) 旋转点在[m+1, j]闭区间中
	   if(nums[m] < nums[j]) 旋转点在[i, m]闭区间中
	   if(nums[m] == nums[j]) 无法判断在哪个区间中，缩小j值，继续循环
*/
    public int minArray(int[] numbers) {
        // 初始化
        int i=0, j=numbers.length-1;
        while(i < j){
            int m = (i+j)/2;
            if(numbers[m] > numbers[j]) i = m+1;
            else if(numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
