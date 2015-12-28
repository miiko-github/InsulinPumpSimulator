package com.fh.his.gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;



public class Clock {
	private static Clock clock;
	private static long delay = 1000 ;
	private static long period = 1000 ;
	private static Date creationDate;
	public Clock(int i){
		System.out.println("sameer");
		
	}

	public Clock(){
		
		GregorianCalendar cal = new GregorianCalendar();
		creationDate = cal.getTime();	   
	    
			
	}
	
	public static void main(String[] args) {
		
	}
	
	public static void startClock(){
		
		Timer clock = new Timer();
		   
		
	    
		
		clock.schedule(new TimerTask(){

			@Override
			public synchronized void run() {
				int minutes= creationDate.getMinutes();
				creationDate.setMinutes(minutes+1);
				
				SimpleDateFormat date_format = new SimpleDateFormat("dd/M/yyyy HH:mm");
			//	   System.out.println( date_format.format(creationDate));
			    InsulinPumpGUIController.setClock(date_format.format(creationDate));
								
			}
			
		}, delay, period);
		
	}
	
public  static Clock getInstance(){
	if(clock == null){
		clock= new Clock();
	}
	return clock;
	
}
public  Date getCurrentDate(){
	return creationDate;
}
public static String getCurrentFormattedDate(){
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/M/yyyy HH:mm");
	return dateformat.format(creationDate);
}

public static double getcurrentTime() {
	Date currentdate = getInstance().getCurrentDate();
	int hour = currentdate.getHours();
	int min = currentdate.getMinutes();
	String time = hour+"."+min;
	return new Double(time);
}
}
