package by.tarif.web.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	public static Date convertDateFromString(String DD_MM_YYY) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		try {
			date = sdf.parse(DD_MM_YYY);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}

	public static String convertDateTo(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String newdate = sdf.format(d);

		return newdate;

	}

}
