package jihe.list;

import java.util.UUID;
import java.util.Vector;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-11-28 21:09
 * @FilePath: TextDemo  ==> vector
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class vector {
    public static void main(String[] args) {
        Vector<Object> objects = new Vector<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                //向集合添加数据
                objects.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(objects);
            }, String.valueOf(i)).start();


        }

    }

}
