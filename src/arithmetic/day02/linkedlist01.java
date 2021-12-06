package arithmetic.day02;

import java.util.Arrays;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-23 10:32
 * @FilePath: TextDemo  ==> linkedlist01
 * @Good Mood: Today is another beautiful day��
 * @Study Code: Did you study today��
 * ����һ���� �ǵݼ�˳�� ������������� nums������ ÿ�����ֵ�ƽ�� ��ɵ�������
 * Ҫ��Ҳ�� �ǵݼ�˳�� ����
 * �������ʱ�临�Ӷ�Ϊ O(n) ���㷨���������
 */
public class linkedlist01 {
    /*���ӣ�
    * ���룺nums = [-4,-1,0,3,10]
�����[0,1,9,16,100]
���ͣ�ƽ���������Ϊ [16,1,0,9,100]
����������Ϊ [0,1,9,16,100]
    *
    * ˼·��
    *1���ȿ�ƽ��
    *2��������
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
