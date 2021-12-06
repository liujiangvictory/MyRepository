package Strategy;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-06 11:25
 * @FilePath: TextDemo  ==> Employee
 * @Good Mood: Today is another beautiful day£¡
 * @Study Code: Did you study today£¿
 */
public class Employee {

    private String name;
    private Integer age;
    private Integer salary;


    public Employee(String name, Integer age, Integer salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
