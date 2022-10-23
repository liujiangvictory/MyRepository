package jihe.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-10-23 20:46
 * @FilePath: TextDome  ==> testDome
 */
public class testDome {
    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("张三",13));
        stuList.add(new Student("李四",14));
        stuList.add(new Student("王五",15));
        stuList.add(new Student("李一",11));
        stuList.add(new Student("二麻子",12));
        stuList.add(new Student("赵六",16));
        Collections.replaceAll(stuList,new Student("赵六",16),new Student("赵六",100));
        System.out.println(stuList);
        /*Collections.sort(stuList);
        System.out.println(stuList);
        */
        for (Student s:stuList){
            System.out.println(s.getName()+","+s.getAge());
        }
    }

}
