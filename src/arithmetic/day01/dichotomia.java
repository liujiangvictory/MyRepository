package arithmetic.day01;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-22 19:18
 * @FilePath: TextDemo  ==> dichotomia
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 * 二分查找
 */
public class dichotomia {
    public static void main(String[] args) {
       int [] nums = {1,3,5,6};
        int target = 2;
        System.out.println(search(nums,target));
    }

    public  static   int search(int[] nums, int target) {
        //定义三个下标，前，中，后
        int fornt, centre, rear;
        fornt = 0;
        rear = nums.length - 1;
        centre = 0;
        while (rear >= fornt) {
            //中等于前后之和除以二
            centre = (rear + fornt) / 2;
            //当中间值比查找值小时，前标移动到中间标+1
            if (target > nums[centre]) {
                fornt = centre + 1;
            }
            //当中间值比查找值大时，红标移动到中间标-1
            else if (target < nums[centre]) {
                rear = centre - 1;
            } else {
                return centre;
            }
        }
        return -1;
    }
}
