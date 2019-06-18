package com.zzg.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @ClassName:  DateUtil   
 * @Description: 日期工具类
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 上午11:22:50   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public class DateUtil {
	
	 private DateUtil(){

	    }

	    private static String getDateFormat(Date date, String dateFormatType) {
	        SimpleDateFormat simformat = new SimpleDateFormat(dateFormatType);
	        return simformat.format(date);
	    }

	    public static String formatCSTTime(String date, String format) throws ParseException {
	        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
	        Date d = sdf.parse(date);
	        return DateUtil.getDateFormat(d, format);
	    }

}
