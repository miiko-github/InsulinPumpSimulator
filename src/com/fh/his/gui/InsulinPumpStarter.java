package com.fh.his.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class InsulinPumpStarter extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		ScreenController screencontroller = new ScreenController();
		screencontroller.loadScreen("screen1","InsulinPumpGUI.fxml" );		
		screencontroller.setScreen("screen1");
		Group root = new Group();
		root.getChildren().addAll(screencontroller);
		

	
	//Parent root= FXMLLoader.load(getClass().getResource("InsulinPumpGUI.fxml"));
	Scene scene = new Scene(root);
	stage.setResizable(false);	
	stage.setTitle("Insulin Pump");
	stage.centerOnScreen();
	 stage.initStyle(StageStyle.TRANSPARENT);       
     scene.getStylesheets().add(InsulinPumpGUIController.class.getResource("button.css").toString()); 
	
	stage.setScene(scene);
	stage.show();
		
	}
public static void main(String[] args) {
	launch(args);
}
}
