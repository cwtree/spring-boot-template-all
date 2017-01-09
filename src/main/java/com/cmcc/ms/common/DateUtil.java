package com.cmcc.ms.common;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;

/**
 * 
 * ClassName: DateUtil <br/>
 * Description: TODO ADD FUNCTION.; date: 2016年4月29日 上午9:52:46 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 */
public class DateUtil {

	public final static String MMDDHHMMSS = "MMddhhmmss";

	public final static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

	public final static String YYYYMMDDHHMMSSSSSWITHSYMBOL = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 
	 * s2d:(); Description:TODO
	 * 
	 * @author chiwei
	 * @param strTime
	 * @param pattern
	 * @return
	 * @since JDK 1.6
	 */
	public static Date s2d(String strTime, String pattern) {
		DateTime d = DateTimeFormat.forPattern(pattern).parseDateTime(strTime);
		return d.toDate();
	}

	/**
	 * 
	 * d2s:(); Description:TODO
	 * 
	 * @author chiwei
	 * @param date
	 * @param pattern
	 * @return
	 * @since JDK 1.6
	 */
	public static String d2s(Date date, String pattern) {
		DateTime time = new DateTime(date);
		return time.toString(pattern);
	}

	/**
	 * 
	 * getCurrentDate:(); Description:TODO
	 * 
	 * @author chiwei
	 * @return
	 * @since JDK 1.6
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 
	 * addXSeconds:(); Description:TODO
	 * 
	 * @author chiwei
	 * @param date
	 * @param X
	 * @return
	 * @since JDK 1.6
	 */
	public static Date addXSeconds(Date date, int x) {
		return new DateTime(date).plus(Period.seconds(x)).toDate();
	}

	/**
	 * 
	 * isExpire:(); Description:TODO
	 * 
	 * @author chiwei
	 * @param now
	 * @param old
	 * @param interval
	 * @return
	 * @since JDK 1.6
	 */
	public static boolean isExpire(Date now, Date old, int interval) {
		return addXSeconds(old, interval).before(now);
	}

	/**
	 * 
	 * getSecondsInterval:(); Description:TODO
	 * 
	 * @author chiwei
	 * @param begin
	 * @param end
	 * @return
	 * @since JDK 1.6
	 */
	public static long getSecondsInterval(Date begin, Date end) {
		return (end.getTime() - begin.getTime()) / 1000;
	}

	/**
	 * 
	 * getTimesNight:(); Description:TODO
	 * 
	 * @author chiwei
	 * @return
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
