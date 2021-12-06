package abs;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-06-19 16:22
 * @FilePath: TextDemo  ==> Emp
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 */

public class Emp {
  private Integer id;
  private String empNumber;
  private String empName;

    public String getEmpName() {
        return empName;
    }

    public Integer getId() {
        return id;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Emp(String empNumber, String empName) {
        this.empNumber = empNumber;
        this.empName = empName;
    }
}
