package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String getDateFormat(){
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
		return dateFormat.format(date);
	}
}
