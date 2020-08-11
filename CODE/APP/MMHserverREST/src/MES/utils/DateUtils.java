package MES.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String getExpirationDate(){
		String expirationDate = "";
		
		Date fecha = new Date();
		
		Calendar Cal = Calendar.getInstance();
		Cal.setTime(fecha);
		Cal.add(Calendar.DAY_OF_MONTH, 1);
		
		fecha=Cal.getTime();
		expirationDate = new SimpleDateFormat("dd-MM-yyyy;hh:mm:ss z").format(fecha);

		
		return expirationDate;
	}
	
	
	
}
