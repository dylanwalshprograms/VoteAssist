package co.grandcircus.VoteAssist.methods;

import java.time.LocalDateTime;

public class VoteAssistMethods {
	
	public static String localDateTimeInWords(LocalDateTime ldt) {
		
		String dayOfWeek = ldt.getDayOfWeek().toString();
		String month = ldt.getMonth().toString();
		int date = ldt.getDayOfMonth();
		int year = ldt.getYear();
		
		dayOfWeek = dayOfWeek.charAt(0) + dayOfWeek.substring(1).toLowerCase();
		month = month.charAt(0) + month.substring(1).toLowerCase();
		
		String timeInWords = dayOfWeek + " " + month + " " + date + ", " + year;
		
		return timeInWords;
		
	}

}
