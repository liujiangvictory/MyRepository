package IO;

import javax.naming.SizeLimitExceededException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;


/**
 * @author Jason
 * @create 2021-03-15 11:00
 */
public class file {
    public static void main(String[] args) {
        File file = new File("D:\\学习");
        String strurl = file.getPath();
        System.out.println(strurl);  //获得绝对路径
        String[] filelist = file.list();
        System.out.println(Arrays.toString(filelist));


        // 类路径  C:\Users\刘江\IdeaProjects\TextDemo\out\production\TextDemo\IO\file.class
       /* File f = new File(file.getClass().getResource("/").getPath());
        System.out.println(f);
        //C:\Users\%e5%88%98%e6%b1%9f\IdeaProjects\TextDemo\out\production\TextDemo
        */

       /* File directory = new File("");//参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(courseFile);
        //C:\Users\刘江\IdeaProjects\TextDemo
*/


        //  System.out.println(System.getProperty("user.dir"));
        //C:\Users\刘江\IdeaProjects\TextDemo


    }
}
