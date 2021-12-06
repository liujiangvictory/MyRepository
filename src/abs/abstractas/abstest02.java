package abs.abstractas;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-08-02 15:03
 * @FilePath: TextDemo  ==> abstest02
 * @Good Mood: Today is another beautiful day£¡
 * @Study Code: Did you study today£¿
 */
public class abstest02  {
    public  static String  str = "Hello World  abstest02!";

    public String text01(long id) throws Exception {
        abstest01.qwes();
        return "abstest02-test01-"+id;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(str);

        abstest02 abs02 = new abstest03();
        System.out.println(abs02.str);

    }
}
