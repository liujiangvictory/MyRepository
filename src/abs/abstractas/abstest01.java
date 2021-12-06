package abs.abstractas;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-08-02 15:02
 * @FilePath: TextDemo  ==> abstest01
 * @Good Mood: Today is another beautiful day£¡
 * @Study Code: Did you study today£¿
 */
public   class abstest01 {
    public static String  str = "Hello World  abstest01!";
    public   String  text01(long id) throws Exception {
        test01(id);
        return "abstest01-text01-" + id;
    }
   public   String test01(long id) throws Exception {

        return text01(id)+"abstest01-test01-" + id;
   }

     public static  void  qwes (){

     }

    public static void main(String[] args) throws Exception {



    }
}
