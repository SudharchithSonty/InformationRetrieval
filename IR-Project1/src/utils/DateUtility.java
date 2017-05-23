package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtility {
	
	public static String getCurrentTimeStamp() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmms");
		return sdf.format(cal.getTime());
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentTimeStamp());
	}
}
