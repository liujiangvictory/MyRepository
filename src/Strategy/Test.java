package Strategy;


import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-06 11:32
 * @FilePath: TextDemo  ==> Test
 * @Good Mood: Today is another beautiful day��
 * @Study Code: Did you study today��
 */
public class Test {


    public static void main(String[] args) {
        //����Ա������
        List<Employee> employe = new ArrayList<Employee>();
        employe.add(new Employee("����", 20, 7002));
        employe.add(new Employee("����", 50, 9002));
        employe.add(new Employee("����", 80, 8002));
        employe.add(new Employee("�ŷ�", 60, 6002));
        employe.add(new Employee("��", 70, 5000));
        //���Ա���������20��Ա��
        //filterage(employe).forEach(emp->System.out.println(emp));
        //filterage(employe).forEach(System.out::print);
        //���Ա��нˮ����5000��Ա��
        //filtersalary(employe).forEach(System.out::println);

      //�������ģʽ
        filterages(employe, new filterage()).forEach(System.out::println);
        System.out.println("============================");
        filterages(employe, new filtersalary()).forEach(System.out::println);
    }

    //��ȡԱ���������20��Ա��
    public static List<Employee> filterage(List<Employee> list) {
        ArrayList<Employee> employee = new ArrayList<Employee>();
        for (Employee emp : list) {
            if (emp.getAge() > 20) {
                employee.add(emp);
            }
        }
        return employee;
    }

    //��ȡнˮ����5000��Ա��
    public static List<Employee> filtersalary(List<Employee> list) {
        ArrayList<Employee> employee = new ArrayList<Employee>();
        for (Employee emp : list) {
            if (emp.getSalary() > 5000) {
                employee.add(emp);
            }
        }
        return employee;
    }
     //�Ż�  ��ȡԱ���������20��Ա��
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
