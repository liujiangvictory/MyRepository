package Strategy;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-06 15:08
 * @FilePath: TextDemo  ==> filterage
 * @Good Mood: Today is another beautiful day£¡
 * @Study Code: Did you study today£¿
 */
public class filterage implements  MyEmploye<Employee> {

    @Override
    public boolean filter(Employee employee) {
        return employee.getAge()>20;
    }
}
