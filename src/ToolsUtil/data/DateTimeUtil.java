package ToolsUtil.data;



import java.text.SimpleDateFormat;

import java.util.Date;
/**
 * <p>Title: Asiainfo Portal System</p>
 * <p>Description: </p>
 * <p>日期时间公共方法类</p>
 * <p>该类提供了日期格式,处理等功能。</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Asiainfo Technologies (China),Inc.HangZhou</p>
 *
 * @author Asiainfo PSO/yuanjq
 * @version 1.0
 */
public class DateTimeUtil {
    /**
     * 得到昨天日期，格式yyyy-MM-dd。
     *
     * @return String 格式化的日期字符串
     */
    public static String getYesterday() {
        Date cDate = new Date();
        cDate.setTime(cDate.getTime() - 24 * 3600 * 1000);
        SimpleDateFormat cSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return cSimpleDateFormat.format(cDate);
    }

    /**
     * 得到今天日期，格式yyyy-MM-dd。
     *
     * @return String 格式化的日期字符串
     */
    public static String getToday() {
        Date cDate = new Date();
        SimpleDateFormat cSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return cSimpleDateFormat.format(cDate);
    }
}
