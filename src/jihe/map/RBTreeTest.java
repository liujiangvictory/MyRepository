package jihe.map;

import java.util.Scanner;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-12-27 21:02
 * @FilePath: TextDemo  ==> RBTreeTest
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class RBTreeTest {
    public static void main(String[] args) {
        Scanner ceanner = new Scanner(System.in);

        RBTree<String, Object> rbt = new RBTree();

        while (true) {
            System.out.println("请输入key：");
            String key = ceanner.next();
            System.out.println();
            rbt.insert(key, null);
            TreeOperation.show(rbt.getRoot());
        }
    }
}
