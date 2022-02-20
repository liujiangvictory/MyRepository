package arithmetic.day01;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-22 19:18
 * @FilePath: TextDemo  ==> dichotomia
 * @Good Mood: Today is another beautiful day��
 * @Study Code: Did you study today��
 * ���ֲ���
 */
public class dichotomia {
    public static void main(String[] args) {
       int [] nums = {1,3,5,6};
        int target = 2;
        System.out.println(search(nums,target));
    }

    public  static   int search(int[] nums, int target) {
        //���������±꣬ǰ���У���
        int fornt, centre, rear;
        fornt = 0;
        rear = nums.length - 1;
        centre = 0;
        while (rear >= fornt) {
            //�е���ǰ��֮�ͳ��Զ�
            centre = (rear + fornt) / 2;
            //���м�ֵ�Ȳ���ֵСʱ��ǰ���ƶ����м��+1
            if (target > nums[centre]) {
                fornt = centre + 1;
            }
            //���м�ֵ�Ȳ���ֵ��ʱ������ƶ����м��-1
            else if (target < nums[centre]) {
                rear = centre - 1;
            } else {
                return centre;
            }
        }
        return -1;
    }
}
