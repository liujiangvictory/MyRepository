package error;

/**
 * @author Jason
 * @create 2021-03-16 22:29
 */
public class finallys {
    static int a = 0;

    public static void main(String[] args) {

        try {

            int s = test(a);
            System.out.println(s);
            System.out.println("a的值=" + a);
        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public static int test(int b) throws Exception {

        try {

            return b;

        } catch (RuntimeException e) {

            e.printStackTrace();

        } finally {

            System.out.println("finally");
            a = 5;
        }
        return b;
    }


}
