package ToolsUtil.data;



import java.text.SimpleDateFormat;

import java.util.Date;
/**
 * <p>Title: Asiainfo Portal System</p>
 * <p>Description: </p>
 * <p>����ʱ�乫��������</p>
 * <p>�����ṩ�����ڸ�ʽ,����ȹ��ܡ�</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Asiainfo Technologies (China),Inc.HangZhou</p>
 *
 * @author Asiainfo PSO/yuanjq
 * @version 1.0
 */
public class DateTimeUtil {
    /**
     * �õ��������ڣ���ʽyyyy-MM-dd��
     *
     * @return String ��ʽ���������ַ���
     */
    public static String getYesterday() {
        Date cDate = new Date();
        cDate.setTime(cDate.getTime() - 24 * 3600 * 1000);
        SimpleDateFormat cSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return cSimpleDateFormat.format(cDate);
    }

    /**
     * �õ��������ڣ���ʽyyyy-MM-dd��
     *
     * @return String ��ʽ���������ַ���
     */
    public static String getToday() {
        Date cDate = new Date();
        SimpleDateFormat cSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return cSimpleDateFormat.format(cDate);
    }
}
