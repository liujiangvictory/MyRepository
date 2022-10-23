package arithmetic.lookup;

/**
 * @Title: 查找算法实现
 * @author: Liu jiang
 * @Date: 2022-05-22 10:00
 * @FilePath: TextDome  ==> SentrySearch
 */
public class SentrySearch {

    public static void main(String[] args) {
        int  a  [] =  {0,1,2,3,4,5,6,7,8,9,10,32,56,78};


        System.out.println(search4(a,56,a.length));


    }






    /*@Title：哨兵查找代码实现
     * @Author Liu jiang
     * @Date 14:35 2022/5/22
     * @Param
     * @return
     **/
    public static int search1(int[] a, int key) {
        int i;
        a[0] = key; // 设置a[0]存储要查找的值，称之为“哨兵”
        i = a.length - 1; // 循环从数组尾部开始
        while (a[i] != key) {
            i--;
        }
        return i;
    }

    /*@Title： 二分查找算法实现
     * @Author Liu jiang
     * @Date 14:36 2022/5/22
     * @Param
     * @return
     **/
    public static int  search2(int[] a, int key){
        //数组为空，为空直接返回-1
        if (null == a || a.length == 0) { return -1; }
        int right = a.length-1; //右下标
        int left = 0; //左下标
        int mid ; //中间下标
        /*先进行判断，如果左边索引>右边索引，直接返回-1。当key小于数组arr的最小值或者大于数组arr的最
        大值,则查找不到该数，直接返回-1*/
        while(left<right && (key>=a[0] || key<=a[a.length-1])){
            mid = left  + (right-left) /2 ;//右移操作除以二
            if(key < a[mid]){  //向左查找
                right = mid;
            }else if(key > a[mid]){ //向右查找
                left = mid + 1;
            }else{
                return mid; //查找到返回下标
            }
        }
        return -1 ;  //没有查找到返回-1
    }


    /*@Title： 插值查找
     * @Author Liu jiang
     * @Date 15:08 2022/5/22
     * @Param
     * @return
     **/
    public static int search3(int[] a, int key){
        //数组为空，为空直接返回-1
        if (null == a || a.length == 0) { return -1; }
        int right = a.length-1; //右下标
        int left = 0; //左下标
        int mid ; //中间下标
         /*先进行判断，如果左边索引>右边索引，直接返回-1。当key小于数组arr的最小值或者大于数组arr的最
        大值,则查找不到该数，直接返回-1*/
        while(left<right && (key>=a[0] || key<=a[a.length-1])){
             mid=left+(right-left)*(key-a[left])/(a[right]-a[left]);
            if(key < a[mid]){  //向左查找
                right = mid-1;
            }else if(key > a[mid]){ //向右查找
                left = mid + 1;
            }else{
                return mid; //查找到返回下标
            }
        }
        // 没有找到返回-1
        return -1;
    }


    /**
     * 返回x和y最小的数
     *
     * @param x
     * @param y
     * @return
     */
    public static int min(int x, int y) {
        return (x <= y) ? x : y;
    }


    /**
     * 斐波那契搜索x的索引，找到就返回索引位置，否则返回-1
     * <p>
     * 算法说明：
     * 令arr[0..n-1]为输入数组，要搜索的元素为x。
     * 1.找到大于或等于n的最小斐波那契数。将此数字设为fibM [第m个斐波纳契数],
     * 设其前面的两个斐波那契数为fibMm1 [第（m-1）个斐波那契数]和fibMm2 [第（m-2）个斐波那契数]。
     * 2.当数组中有要检查的元素时：
     *  a.将x与fibMm2覆盖范围的最后一个元素进行比较,如果x匹配，则返回索引;
     *  b.如果x小于元素，则将三个Fibonacci变量向前移动两个Fibonacci，表示消除了剩余数组的大约后三分之二；
     *  c.如果x大于元素，则将三个斐波那契变量向后移动一个斐波那契。将偏移量重置为索引。这些加在一起表明消除了其余阵列的大约三分之一；
     * 3.由于可能还有一个元素需要比较，因此请检查fibMm1是否为1。如果是，则将x与该剩余元素进行比较。如果匹配，则返回索引。
     *
     * @param arr 数组
     * @param x   查找的值
     * @param n   数组的长度
     * @return x索引位置或者-1
     */
    public static int search4(int arr[], int x, int n) {
        // 初始化斐波那契数
        //第（m-2）个斐波那契编号
        int fibMMm2 = 0;
        //第（m-1）个斐波那契编号
        int fibMMm1 = 1;
        //第 m个斐波那契数
        int fibM = fibMMm2 + fibMMm1;

        /* fibM将存储最小的斐波那契数大于或等于n*/
        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        // 从前面标记消除的范围
        int offset = -1;

        /* 循环检查元素,注意，我们将arr[fibMm2]与x进行了比较,当fibM变为1时，fibMm2变为0 */
        while (fibM > 1) {
            // 检查fibMm2是否为有效位置
            int i = min(offset + fibMMm2, n - 1);

            /* 如果x大于索引fibMm2处的值，则将从offset到i切割为子数组 */
            if (arr[i] < x) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            } else if (arr[i] > x) {
                /*如果小于索引fibMm2处的值，则将从i+1到arr.length-1进行切割数组*/
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else {
                /*找到了，就返回索引*/
                return i;
            }
        }

        /* 将最后一个元素与x比较 */
        if (fibMMm1 == 1 && arr[offset + 1] == x) {
            return offset + 1;
        }

        /*没有找打，返回-1 */
        return -1;
    }







}
