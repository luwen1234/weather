package com.weather.utility;

public class Dictionary {

	/**
	 * 账号类型 开始
	 */
	//普通用户
	public static String CUSTOMER = "1";
	public static String CUSTOMER_NAME = "普通用户";
	//管理员
	public static String MANAGER = "2";
	public static String MANAGER_NAME = "管理员";
	//超级管理员
	public static String ADMIN = "3";
	public static String ADMIN_NAME = "超级管理员";
	/** 账号类型 结束 */
	
	/**
	 * 数据字典参数 开始
	 */
	//数据字典类型
	public static String WEATHER_REPORT = "1";
	/** 数据字典 结束*/
	
	/**
	 * 账号缴费状态 开始
	 */
	//已缴费
	public static String USED = "1";
	//未交费
	public static String UNUSED = "2";
	/** 账号缴费状态 结束 */
	/**
	 * 性别 开始
	 */
	//男
	public static String MALE = "1";
	public static String MALE_NAME = "男";
	//女
	public static String FEMALE = "2";
	public static String FEMALE_NAME = "女";
	/** 性别 结束 */
	
	/**
	 * 记录状态 开始
	 */
	public static String NORMAL = "1";
	
	public static String UNNORMAL = "2";
	/** 记录状态 结束 */
	
	/**
	 * 登陆key
	 * 
	 */
	public static String LOGIN_KEY = "user";
	

	/**
	 * 雷达数据地址
	 */
	public static String leida = "https://qlfy.sdmsc.net/api/radar/radar1/?radarCodes=631&key=6fde3f68eef29039827027264c08f5db";
	
	/**
	 * 卫星数据地址
	 */
	public static String weixin = "https://qlfy.sdmsc.net/api/sate/?key=6fde3f68eef29039827027264c08f5db";
}
