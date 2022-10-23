package arithmetic.Offer;

/**
 * @Title: 二维数组中的查找
 * @author: Liu jiang
 * @Date: 2022-05-22 19:16
 * @FilePath: TextDome  ==> offer04
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */
public class offer04 {

    public static void main(String[] args) {
        int a [][] = {
                {1,4,7,11,15},
                {2, 5, 8,12,19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray2(a,19));

    }



    //直接遍历查找（效率地下）
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length-1; i++) {
            for(int j =0; j < matrix[i].length; j++){
                if(target == matrix[i][j]){
                    return true;

                }
            }
        }
        return false;
    }
    /*
	1. 一个这样的二维数组，看右上角的元素，它右下的数字比它小，左上的数字比它大。
	   【或左下角的元素，左上的数字比它小，右下的数字比它大】
	2. 基于此，可以进行二分查找。
	3. 从左下角元素开始遍历，即matrix[matrix.length-1][0]
	   【用右上角元素遍历的话，求matrix[0][matrix[0].length-1]可能会报错】
	4. target目标值大于此元素 j++，小于此元素 i--。
*/
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        //定位左下角的元素
        int i = matrix.length-1,j = 0;
        while(i >=0 && j < matrix[0].length){
            int flag = matrix[i][j];
            if(target < flag) i--;
            if(target > flag) j++;
            if(target == flag) return true;
        }
        return false;
    }


}
