package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author Jason
 * @create 2021-03-17 17:33
 */
public class BufferReader {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // =================
        // 获得开始时间
        long start_time = System.currentTimeMillis();

        // 1、打开输入流
        Reader file = new FileReader("D://testFile.txt");
        BufferedReader bread = new BufferedReader(file);

        // 2、读取数据
        String str;
        while ((str = bread.readLine()) != null) {
            System.out.println(str);
        }

        // 3、关闭流
        bread.close();
        file.close();

        // ===============
        // 获得结束时间
        long end_time = System.currentTimeMillis();

        System.out.println("花费时间：" + (end_time - start_time) + "ms");
    }
}
