package com.abeliot.framework.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {

	static final SimpleDateFormat sdf = new SimpleDateFormat(Const.DATETIME_FORMAT_YYYY_MM_DD_HH_MM_SS);
			
	public static String format(Date date){
		if(date != null){
			return sdf.format(date);
		}else{
			return null;
		}
	}
	
	public static String format(Date date, String pattern){
		if(date != null){
			return new SimpleDateFormat(pattern).format(date);
		}else{
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(DateUtils.format(Calendar.getInstance().getTime()));
		
	}
}
