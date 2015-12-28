package com.fh.his.insulincontroller;

public class BatteryManager {
	private static BatteryManager batterymanager;
	private  Double batterylevel;
	private Double MaxBatteryLevel = 100.0;
	
	public BatteryManager(){
		batterylevel = MaxBatteryLevel;
	}
	
	public Double getBatteryLevel(){
		batterylevel -= 0.5;
		return (batterylevel)/100;
	}

	public static BatteryManager getInstance() {
		
		if (batterymanager == null){
			batterymanager = new BatteryManager();
			
		}
		return batterymanager;
	}

}
