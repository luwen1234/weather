package com.weather.utility;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	/**
	 * 获得年/月/日 时:分:秒格式的时间
	 * @return
	 */
	public static Date getLongDate(Date date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return DateUtils.parseDate(sdf.format(date));
	}

	/**
	 * 获得年/月/日 格式的时间
	 * @return
	 */
	public static Date getShortDate(Date date) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return DateUtils.parseDate(sdf.format(date));
	}
}
