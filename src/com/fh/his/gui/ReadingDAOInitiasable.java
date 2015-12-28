package com.fh.his.gui;

import java.util.Date;

public interface ReadingDAOInitiasable {
	 public void getBloodGlucoseReading(Date date);
	 public void getInsulinDosageReading(Date date);
	 public void getCarbohydrateIntakeReading(Date date);
	 public void getBasalProfile(Date date);
	 

}
