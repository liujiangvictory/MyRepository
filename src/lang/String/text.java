package lang.String;

/**
 * @author Jason
 * @create 2021-03-29 14:36
 */
public class text {
    public static void main(String[] args) {
        String str = "firstsecond";
        String s4 = "first" + "second";
        System.out.println(str==s4);
        System.out.println(str.equals(s4));

        stringPool();

        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);
    }


    public static  void stringPool(){
        String str = "firstsecond";
        String s3 = "first" + "second";
        String s1 = "first" ;
        String s2 = "second";
        String s4 = s1 + s2;
        s4.intern();
        System.out.println(str==s4);
        System.out.println(str==s3);
    }



}
