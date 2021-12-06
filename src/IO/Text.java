package IO;

import java.io.File;

/**
 * @author Jason
 * @create 2021-03-20 23:01
 */
public class Text {

    public static void main(String[] args) {
        File file = new File("d:/毕业设计/");
        // 全路径fileList方法
        fileList(file);
        //非全路径fileList方法
        fileList(file, 0);
    }

    //全路径输出方法
    public static void fileList(File file) {
        File[] files = file.listFiles();//放回的是改目录下面一个文件集合
        //判断该文件集合不为空
        if (files != null) {
            //循环遍历集合输出集合中的所有文件路径
            for (File f : files) {
                System.out.println(f.getPath());
                fileList(f);
            }
        }
    }

    //非全路径输出方法（只输出文件名及后缀）
    public static void fileList(File file, int node) {
        node++;
        File[] files = file.listFiles();//放回的是改目录下面一个文件集合
        //判断该文件集合不为空
        if (files != null) {
            for (File f : files) {
                for (int i = 0; i < node; i++) {
                    if (i == node - 1) {
                        System.out.print("/");
                    } else {
                        System.out.print(" ");
                    }
                }
                //输出文件名
                System.out.println(f.getName());
                //调用自己循环输出文件
                fileList(f, node);
            }
        }
    }
}
