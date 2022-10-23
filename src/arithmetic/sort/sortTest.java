package arithmetic.sort;

import java.util.Arrays;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-05-22 20:13
 * @FilePath: TextDome  ==> sortTest
 */
public class sortTest {
    public static void main(String[] args) {

    }

/*直接插入排序:
* 将一个记录插入到已排序的有序表中，使插入后的表仍然有序*/
    public static void bubbleSort1(int[] arr) {
        if(arr==null)
            return;
        int len=arr.length;
        //i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for(int i=0;i<len-1;i++) {
            //j控制比较次数，第i次循环内需要比较len-i次
            //但是由于是由arr[j]跟arr[j+1]进行比较，所以为了保证arr[j+1]不越界，j<len-i-1
            for(int j=0;j<len-i-1;j++) {
                //如果前一个数比后一个数大，则交换位置将大的数往后放。
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    /*冒泡排序：
    即对n个数进行排序，每次都是由前一个数跟后一个数比较，每循环一轮， 就可以将最大的数移到数组的最后， 总共循环n-1轮，完成对数组排序。
    * */
    public static void bubbleSort2(int[] arr) {
        if(arr==null)
            return;
        int len=arr.length;
        //i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for(int i=0;i<len-1;i++) {
            //j控制比较次数，第i次循环内需要比较len-i次
            //但是由于是由arr[j]跟arr[j+1]进行比较，所以为了保证arr[j+1]不越界，j<len-i-1
            for(int j=0;j<len-i-1;j++) {
                //如果前一个数比后一个数大，则交换位置将大的数往后放。
                if(arr[j]>arr[j+1]) {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    /*选择排序：
    * 在每一次循环内都由一个数去跟 所有的数都比较一次，每次比较都选取相对较小的那个数来进行下一次的比较，并不断更新较小数的下标
    * 这样在一次循环结束时就能得到最小数的下标，再通过一次交换将最小的数放在最前面，通过n-1次循环之后完成排序。 */
    public static void selectSort(int[] arr) {
        if(arr==null)
            return;
        int len=arr.length;
        //i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
        for(int i=0;i<len-1;i++) {
            //minIndex 用来保存每次比较后较小数的下标。
            int minIndex=i;
            //j控制比较次数，因为每次循环结束之后最小的数都已经放在了最前面，
            //所以下一次循环的时候就可以跳过这个数，所以j的初始值为i+1而不需要每次循环都从0开始，并且j<len即可
            for(int j=i+1;j<len;j++) {
                //每比较一次都需要将较小数的下标记录下来
                if(arr[minIndex]>arr[j]) {
                    minIndex=j;
                }
            }
            //当完成一次循环时，就需要将本次循环选取的最小数移动到本次循环开始的位置。
            if(minIndex!=i) {
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
            //打印每次循环结束之后数组的排序状态（方便理解）
            System.out.println("第"+(i+1)+"次循环之后效果："+ Arrays.toString(arr));
        }
    }


}
