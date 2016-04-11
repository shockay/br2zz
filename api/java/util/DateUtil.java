package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String date2String(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateStr = sdf.format(date);
		return dateStr == null ? "" : dateStr;
	}
}
