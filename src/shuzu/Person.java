package shuzu;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-12-09 20:35
 * @FilePath: TextDemo  ==> Person
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public class Person {

    private String name ;
    private int age  ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    

}



