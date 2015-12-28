package com.fh.his.gui;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ScreenController extends StackPane {

HashMap<String, Node> screens = new HashMap<>();

public void addScreen(String name, Node screen){
	screens.put(name, screen);
}

public Node getScreen(String name){
	return screens.get(name);
}
public void loadScreen(String name, String resource){
	try {
	     FXMLLoader screenloader = new FXMLLoader(getClass().getResource(resource));
	
		 Parent loadscreen = (Parent) screenloader.load();
		 ControlledScreen controlledscreen = ((ControlledScreen)screenloader.getController());
		 controlledscreen.setParentScreen(this);
		 addScreen(name, loadscreen);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void setScreen(String name){
	
	if(screens.get(name)!= null){
		if (!getChildren().isEmpty()){
			
			getChildren().remove(0);
			getChildren().add(0,screens.get(name));
		}
		else{
			getChildren().add(screens.get(name));
		}
		
		
	}
	else{
		System.out.println("there are no FXML file laoded by this name");
	}
	
}
}
