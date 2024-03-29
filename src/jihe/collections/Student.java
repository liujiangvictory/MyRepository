package jihe.collections;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2022-10-23 20:44
 * @FilePath: TextDome  ==> Student
 */
public class Student   implements Comparable<Student>{
    private String name;
    private int age;

    public  Student(){

    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    /*@Title： 按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序
     * @Author Liu jiang
     * @Date 20:51 2022/10/23
     * @Param 
     * @return 
     **/
    @Override
    public int compareTo(Student s) {
        int num = this.name.compareTo(s.name);
        int num2 = num==0?this.age-s.age:num;
        return num2;
    }
}
