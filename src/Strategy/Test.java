package Strategy;


import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-06 11:32
 * @FilePath: TextDemo  ==> Test
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class Test {


    public static void main(String[] args) {
        //创建员工集合
        List<Employee> employe = new ArrayList<Employee>();
        employe.add(new Employee("赵云", 20, 7002));
        employe.add(new Employee("黄忠", 50, 9002));
        employe.add(new Employee("关于", 80, 8002));
        employe.add(new Employee("张飞", 60, 6002));
        employe.add(new Employee("马超", 70, 5000));
        //输出员工年龄大于20的员工
        //filterage(employe).forEach(emp->System.out.println(emp));
        //filterage(employe).forEach(System.out::print);
        //输出员工薪水大于5000的员工
        //filtersalary(employe).forEach(System.out::println);

      //策略设计模式
        filterages(employe, new filterage()).forEach(System.out::println);
        System.out.println("============================");
        filterages(employe, new filtersalary()).forEach(System.out::println);
    }

    //获取员工年龄大于20的员工
    public static List<Employee> filterage(List<Employee> list) {
        ArrayList<Employee> employee = new ArrayList<Employee>();
        for (Employee emp : list) {
            if (emp.getAge() > 20) {
                employee.add(emp);
            }
        }
        return employee;
    }

    //获取薪水大于5000的员工
    public static List<Employee> filtersalary(List<Employee> list) {
        ArrayList<Employee> employee = new ArrayList<Employee>();
        for (Employee emp : list) {
            if (emp.getSalary() > 5000) {
                employee.add(emp);
            }
        }
        return employee;
    }
     //优化  获取员工年龄大于20的员工
      public static  List<Employee> filterages(List<Employee> list,MyEmploye<Employee> mp){
          List<Employee> objects = new ArrayList<>();
          for(Employee emp : list){
              if(mp.filter(emp)){
                  objects.add(emp);
              }
          }
          return objects;
      }
}
