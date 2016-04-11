package test;

import java.util.Calendar;
import java.util.Date;

import util.DateUtil;
import util.StringUtil;

public class Test {

	public static final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;
	public static final int SECONDS_PER_MONTH = 60 * 60 * 24 * 30;
	
	public static void main(String[] args) {
		
		 Calendar c = Calendar.getInstance();
		 c.setTime(new Date(System.currentTimeMillis()));
		 c.add(Calendar.SECOND, 3*SECONDS_PER_MONTH);
		 String overTime = DateUtil.date2String(c.getTime(), "yyyy-MM-dd HH:mm:ss");
		
		System.out.println(overTime);
		
		//123123
		int i = StringUtil.CompareString("000123", "001220");
		System.out.println(i);
	}
	
}
