package arithmetic.competition.week275;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-01-09 10:35
 * @FilePath: TextDemo  ==> test01
 * 检查是否每一行每一列都包含全部整数 显示英文描述
 * User Accepted:0
 * User Tried:0
 * Total Accepted:0
 * Total Submissions:0
 * Difficulty:Easy
 * 对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），则认为该矩阵是一个 有效 矩阵。
 *
 * 给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：如果是，返回 true ；否则，返回 false 。
 *输入：matrix = [[1,2,3],[3,1,2],[2,3,1]]
 * 输出：true
 *
 * 输入：matrix = [[1,1,1],[1,2,3],[1,2,3]]
 * 输出：false
 *
 * 提示：
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * 1 <= matrix[i][j] <= n
 *
 * 这里注意：是每一行每一列都包含从 1 到 n 的 全部 整数
 * 解题技巧：
 * 每一行每一列都满足下面两个条件就可以了
 * 1、每一行每一列的数字都小于数组的长度
 * 2、每一行每一列的数字都不重复
 */
public class test01 {

    public static void main(String[] args) {
      int [][]  matrix =  {{1,3,1},{3,1,3},{1,3,1}};
        System.out.println(checkValid(matrix));
    }



    public static boolean checkValid(int[][] matrix) {
        int var = matrix.length;
        for (int i = 0; i < matrix.length; i++) {  //喜欢二维数组
            for (int j = 0; j < matrix[i].length; j++) {   //喜欢二维数组中
                if (matrix[i][j] > var || matrix[j][i] > var) {      //判断每一行每一列的数据都小于数组的长度
                    return false;
                }

                for(int a = j+1 ; a<matrix[i].length ; a++){
                    if (matrix[i][j] == matrix[i][a] ||  matrix[j][i] == matrix[a][i]){   // 判断每一行每一列的数据都不重复
                        return false;
                    }

                }
            }
        }
            return true;
    }


}
