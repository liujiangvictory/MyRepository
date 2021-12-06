package arithmetic.day01;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-22 20:43
 * @FilePath: TextDemo  ==> dichotomia02
 * @Good Mood: Today is another beautiful day��
 * @Study Code: Did you study today��
 */

      /*  ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
        ���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�

        �����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��*/
/*    ����˼·��
     �����
1������ֵ����������ֵ����Сֵ֮��
      ����ֵ��������
      ����ֵ����������
2������ֵ������������ֵ����Сֵ֮��
      ����ֵС��������Сֵ
      ����ֵ�����������ֵ*/
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
        //���������±�
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            //�����м��±�
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
//        ǰ��һ�����������ֵ����������ֵ����Сֵ֮��
            boolean boo = false;  //����һ��ֵ�ж��Ƿ����������ҵ�������Ҫ����ֵ
            //����ͷ��β���нڵ�
            int sIndex = 0, eIndex = nums.length - 1, mIndex = 0;
            //���ֲ���,�������в��Ҹ�����
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
            //�ж��Ƿ��������в鵽��ֵ���ҵ������м�ֵ��û���ҵ�����ͷ�±�
            if (boo) {
                return mIndex;
            } else {
                return sIndex;
            }
        }else{
            //�ڶ������������ֵ������������ֵ����Сֵ֮��
            if(target<nums[0]){
                return 0;
            }else{
                return nums.length;
            }
        }
    }
}

