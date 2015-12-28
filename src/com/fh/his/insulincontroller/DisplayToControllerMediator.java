package com.fh.his.insulincontroller;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.fh.his.gui.InsulinPumpGUIController;


public class DisplayToControllerMediator extends TimerTask {

	private static DisplayToControllerMediator displaytocontrollermediatorinstance = null;
	private static int delay = 1000;
	private static int period = 5000;
 private int i=0;
 private static Boolean iscancel= false;
	public void run() {
		i=i+1;
				System.out.println("current execution: " + i);
				HashMap accesorystatus=(HashMap) PrimeController.getInstance().startDevice();
				InsulinPumpGUIController.setParameters(accesorystatus);
		
		
	}
	
	public void startScheduling(Timer timer){
		timer.scheduleAtFixedRate(
				com.fh.his.insulincontroller.DisplayToControllerMediator
						.getInstance(), delay, period);
		
	}
	public void cancelTask(){
		getInstance().cancel();
		displaytocontrollermediatorinstance = null;
	}
	
	
	
	public static DisplayToControllerMediator getInstance(){
		
		if (displaytocontrollermediatorinstance == null){
			displaytocontrollermediatorinstance = new DisplayToControllerMediator();
		}
		return displaytocontrollermediatorinstance;
		
	}

}
