package com.fh.his.insulincontroller;

import com.fh.his.reservoirassembly.BloodGlucoseSensor;

public class GlucoseLevelManager {
	//private int GlucoseLevel;
	private String message;

	public static double checkGlucoseLevel() {
	
		return com.fh.his.reservoirassembly.BloodGlucoseSensor.getInstance().checkBloodGlucose();
	}

	public static void changeBloodGlucoseOnActivity(Boolean isinsulin,double carbohydratevalue) {
		
		com.fh.his.reservoirassembly.BloodGlucoseSensor.getInstance().bloodGlucoseChangeOnActivity(isinsulin,carbohydratevalue);
	}
public static void changeBolusGlucose() {
		
		com.fh.his.reservoirassembly.BloodGlucoseSensor.getInstance().bloodchangeBolus();
	}

	public static void bloodGlucoseChangeOnBasalActivity(double insulindosemanual){
		com.fh.his.reservoirassembly.BloodGlucoseSensor.getInstance().bloodGlucoseChangeOnBasalActivity(insulindosemanual);
	}
	

}
