package com.fh.his.insulincontroller;

public class InsulinInjectionManager {

	private static InsulinInjectionManager insulin_injection_manager_instance = null;
	private Double current_insulin_level;

	 Double checkInsulinLevel(double isnewinsulin) {
		return com.fh.his.reservoirassembly.InsulinReservoir.getInstance().checkInsuliLevel(isnewinsulin);
		
	}

	public static synchronized InsulinInjectionManager getInstance() {
		if (insulin_injection_manager_instance == null) {
			insulin_injection_manager_instance = new InsulinInjectionManager();
		}
		return insulin_injection_manager_instance;

	}
}
