package com.fh.his.gui;


import javafx.scene.layout.AnchorPane;

public class ScreenNextController implements ControlledScreen{
	ScreenController screencontroller;

public static  void goToNextScreen(AnchorPane hboxid){
hboxid.setVisible(false);	
}

	

	@Override
	public void setParentScreen(ScreenController screencontroller) {
		this.screencontroller =screencontroller;
		
	}
	
	

}
