package IO;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Jason
 * @create 2021-03-17 12:03
 */
public class FileInputstream {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // a.打开输入流(实例化FileInputStream,并且指定路径)
        File f = new File("d://testFile.txt");

        FileInputStream fs = new FileInputStream(f);


        // b.读取数据(需要使用循环)
        byte[] b = new byte[fs.available()];
        int len = 0;
        StringBuffer str = new StringBuffer();

        //一次读取的长度为byte数组的长度
        while ((len = fs.read(b)) != -1) {
            System.out.println("进来循环...");
            String str1 = new String(b, 0, len);
            str.append(str1);
        }

        System.out.println("str=" + str);

        // c.关闭输入流
        fs.close();

    }
}
