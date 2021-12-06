package Strategy;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-07-06 15:07
 * @FilePath: TextDemo
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */
public interface MyEmploye <Employee>{
    //定义根据条件过滤方法
    public boolean filter(Employee employee);
}
