package ToolsUtil.data;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-08-02 10:35
 * @FilePath: TextDemo  ==> test01
 * @Good Mood: Today is another beautiful day£¡
 * @Study Code: Did you study today£¿
 */
public class test01 {
    public static void main(String[] args) {
        String crruDate= DateTimeUtil.getToday();
        String bakpath=crruDate.substring(0,4)+"/"+crruDate.substring(5, 7)+"/"+crruDate.substring(8,10);
        System.out.println(crruDate+"========"+bakpath);
    }

    public String  test (long id){
         return id+"qwe";
    }
}
