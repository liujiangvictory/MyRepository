package Util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-12-31 9:21
 * @FilePath: TextDemo  ==> DateTest
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 * y：year-of-era；正正经经的年，即元旦过后；Y：week-based-year；只要本周跨年，那么这周就算入下一年；
 * 就比如说今年(2019-2020) 12.31 这一周是跨年的一周，而 12.31 是周二，那使用 YYYY 的话会显示 2020，
 * 使用 yyyy 则会从 1.1 才开始算是 2020。
 */
public class DateTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.DECEMBER, 31);
            Date strDate = calendar.getTime();
        DateFormat formatUpperCase = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("2021-12-31 to yyyy-MM-dd: " + formatUpperCase.format(strDate));
        formatUpperCase = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("2021-12-31 to YYYY/MM/dd: " + formatUpperCase.format(strDate));
    }

}
