package com.cmcc.ms.common;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * ClassName: DateUtil <br/>
 * Description: TODO ADD FUNCTION.; date: 2016年4月29日 上午9:52:46 <br/>
 *
 * @author chiwei
 * @since JDK 1.6
 */
public class DateUtil {

    public final static String YYYYMMWITHSYMBOL = "yyyy-MM";

    public final static String YYYYMMDDWITHSYMBOL = "yyyy-MM-dd";

    public final static String MMDDHHMMSS = "MMddhhmmss";

    public final static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public final static String YYYYMMDDHHMMSSSSSWITHSYMBOL = "yyyy-MM-dd HH:mm:ss";

    public final static String YYYYMMDDHHMMWITHSYMBOL = "yyyy-MM-dd HH:mm";
    private static Calendar calendar = Calendar.getInstance();

    /**
     * s2d:(); Description:TODO
     *
     * @param strTime
     * @param pattern
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static Date s2d(String strTime, String pattern) {
        DateTime d = DateTimeFormat.forPattern(pattern).parseDateTime(strTime);
        return d.toDate();
    }

    /**
     * d2s:(); Description:TODO
     *
     * @param date
     * @param pattern
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static String d2s(Date date, String pattern) {
        DateTime time = new DateTime(date);
        return time.toString(pattern);
    }

    /**
     * @return
     */
    public static Date getCurrentTime() {
        return new Date();
    }

    /**
     * getCurrentDate:(). <br/>
     *
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static Date getCurrentDate() {
        calendar.setTime(getCurrentTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * @param date
     * @param x
     * @return
     */
    public static Date addXDay(Date date, int x) {
        return new DateTime(date).plus(Period.days(x)).toDate();
    }

    /**
     * addXHour:(). <br/>
     *
     * @param date
     * @param x
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static Date addXHour(Date date, int x) {
        return new DateTime(date).plus(Period.hours(x)).toDate();
    }

    /**
     * addXMin:(). <br/>
     *
     * @param date
     * @param x
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static Date addXMin(Date date, int x) {
        return new DateTime(date).plus(Period.minutes(x)).toDate();
    }

    /**
     * addXSeconds:(); Description:TODO
     *
     * @param date
     * @param X
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static Date addXSeconds(Date date, int x) {
        return new DateTime(date).plus(Period.seconds(x)).toDate();
    }

    /**
     * isExpire:(); Description:TODO
     *
     * @param now
     * @param old
     * @param interval
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static boolean isExpire(Date now, Date old, int interval) {
        return addXSeconds(old, interval).before(now);
    }

    /**
     * getSecondsInterval:(); Description:TODO
     *
     * @param begin
     * @param end
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static long getSecondsInterval(Date begin, Date end) {
        return (end.getTime() - begin.getTime()) / 1000;
    }

    /**
     * getTimesNight:(); Description:TODO
     *
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    public static Date getTimesNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
