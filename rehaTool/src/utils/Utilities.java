package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

	public static String dateToTextfield(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(date);
	}

}
