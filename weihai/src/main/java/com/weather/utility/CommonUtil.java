package com.weather.utility;

public class CommonUtil {

	private static char[] codes = {'0','1','2','3','4','5','6','7','8','9',
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
			't','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M',
			'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	/**
	 * 生成一个16位的随机字符串
	 * @return
	 */
	public static String getCheckCode(){
		
		int p = (int)Math.floor(62*Math.random());
		int i=0;
		String code = "";	
		while(codes.length > p && i < 16){
			
			code += codes[p]+"";
			p = (int)Math.floor(62*Math.random());
			i++;
		}

		return code;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
//		System.out.println(CommonUtil.getCheckCode());
		System.out.println(System.currentTimeMillis());
		Thread.sleep(1000);
		System.out.println(System.currentTimeMillis());
		Thread.sleep(1000);
		System.out.println(System.currentTimeMillis());
		Thread.sleep(1000);
	}
}
