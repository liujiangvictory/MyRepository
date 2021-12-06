package Strategy;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-06 15:20
 * @FilePath: TextDemo  ==> filtersalary
 * @Good Mood: Today is another beautiful day£¡
 * @Study Code: Did you study today£¿
 */
public class filtersalary  implements MyEmploye<Employee>{
    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary()>5000;
    }
}
