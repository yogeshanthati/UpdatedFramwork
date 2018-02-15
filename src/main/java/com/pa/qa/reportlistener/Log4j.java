package com.pa.qa.reportlistener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;




import com.pa.qa.util.Constants;


public class Log4j {
	 public static void createLog() throws Exception{
		 
	
		// DOMConfigurator.configure("log4j.xml");
		 Date date = new Date() ;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ; ;
			String time = dateFormat.format(date);
			File dir = new File("./TestResults/LogReport/"+time);
			String propsFileName ="./src/main/resources/log4j.properties";
			Properties props = new Properties();
			java.io.FileInputStream configStream = new java.io.FileInputStream(propsFileName);
			props.load(configStream);
			String myStr = "./TestResults/LogReport/"+time+"/LogFile.log";
			Constants.TestResult_Path=time;
			props.setProperty("log4j.appender.FA.File", myStr);
			java.io.FileOutputStream output = new java.io.FileOutputStream(propsFileName);
			props.store(output, "Output Directory updated : " );
			output.close();
			configStream.close();
			
		
	 }
	 
	

}
