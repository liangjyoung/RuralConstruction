package com.rural.tool;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期类型转换
 * string与TimeStape类型互转
 * @author Administrator
 * 
 */
public class DataHelper {
	private static final String DEFAULT_PATTERN = "yyyyMMddHHmmss";

	/**
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static String timestamp2str(Timestamp time, String pattern) {
		if (time == null) {
			throw new IllegalArgumentException("Timestamp is null");
		}
		if (pattern != null && !"".equals(pattern)) {
			if (!"yyyyMMddHHmmss".equals(pattern)
					&& !"yyyy-MM-dd HH:mm:ss".equals(pattern)
					&& !"yyyy-MM-dd".equals(pattern)
					&& !"MM/dd/yyyy".equals(pattern)) {
				throw new IllegalArgumentException("Date format [" + pattern
						+ "] is invalid");
			}
		} else {
			pattern = DEFAULT_PATTERN;
		}

		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.setTime(time);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(cal.getTime());
	}

	public static Timestamp str2Timestamp(String timeStr, String pattern) {
		Timestamp result = null;
		if (timeStr == null) {
			throw new IllegalArgumentException("Timestamp is null");
		}
		if (pattern != null && !"".equals(pattern)) {
			if (!"yyyyMMddHHmmss".equals(pattern)
					&& !"yyyy-MM-dd HH:mm:ss".equals(pattern)
					&& !"MM/dd/yyyy HH:mm:ss".equals(pattern)
					&& !"yyyy-MM-dd".equals(pattern)
					&& !"MM/dd/yyyy".equals(pattern)) {
				throw new IllegalArgumentException("Date format [" + pattern
						+ "] is invalid");
			}
		} else {
			pattern = DEFAULT_PATTERN;
		}

		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			d = sdf.parse(timeStr);
			result = new Timestamp(d.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
