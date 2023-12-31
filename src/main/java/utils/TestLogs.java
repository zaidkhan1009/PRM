package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLogs {
	
	
	public static Logger log = Logger.getLogger(TestLogs.class.getName());

	public static void main(String[] args) {
		
		Date d = new Date();
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MMM_yy HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		formattedDateTime = formattedDateTime.toString().replace(":", "_").replace(" ", "-");
		
		System.setProperty("current.date",formattedDateTime);
		PropertyConfigurator.configure("./config/log4j.properties");
		
		log.info("This is the information log");
		
		log.error("Here the error logs will be printed");

	}

}
