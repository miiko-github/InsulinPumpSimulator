package com.fh.his.gui;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Timer;

import com.fh.his.dao.BasalProfile;
import com.fh.his.dao.BloodGlucoseReadings;
import com.fh.his.dao.HibernateChecker;
import com.fh.his.dao.InsulinDosageReadings;
import com.fh.his.insulincontroller.DisplayToControllerMediator;
import com.fh.his.insulincontroller.GlucoseLevelManager;
import com.fh.his.insulincontroller.PrimeController;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.AnchorPaneBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Shear;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javafx.scene.control.ListCell;
import javafx.util.Callback;
/**
 * 
 * @author Sameer Sheikh
 */
public class InsulinPumpGUIController implements Initializable,
		ControlledScreen {
	@FXML 
	private Rectangle rectanglefxid;
	@FXML
	private ListView errormessagepopuplist;
	private static ObservableList<String> errormessageobservablelist = FXCollections
			.observableArrayList();
	@FXML
	private AnchorPane errormessageanchorpane;
	@FXML
	private static Text insulinleveltext;
	@FXML
	private static Text batteryleveltext;
	@FXML
	private AnchorPane modeselectionanchorpane;
	@FXML
	private static Text currentdate;
	@FXML
	private ToggleButton switchbutton;
	@FXML
	private Button activityprocessbutton;
	@FXML
	private ListView activitylistview;
	private static HashMap carbohydratecontaint = new HashMap();
	private static ObservableList<Object> activitylist = FXCollections
			.observableArrayList();
	private static BasalProfile basalprofile;
	@FXML
	private Label updatelabeltext;
	private static HashMap<String, ArrayList<BasalProfile>> basalprofiledata = new HashMap<String, ArrayList<BasalProfile>>();
	
	@FXML
	private ListView basalprofiletimingsandinsulin;
	final ObservableList<String> basalprofiletimingslist = FXCollections
			.observableArrayList();

	@FXML
	private ListView basalprofiledatafxid;
	private static ObservableList<Object> basalprofilesdatalist = FXCollections
			.observableArrayList();
	TextField tea1 = new TextField();
	// tea1.setText("0000");
	TextField tea2 = new TextField();
	// tea2.setText("0000");
	TextField tea3 = new TextField();
	// tea3.setText("0.0");

	@FXML
	private TabPane basalprofiletabsfxid;

	@FXML
	private ListView basalprofilenamesfxid;

	private static ObservableList<String> basalprofileslist = FXCollections
			.observableArrayList();

	@FXML
	private AnchorPane menuoptionanchorpanefxid;
	@FXML
	private ListView menuoptionlistviewfxid;

	ScreenController screencontroller;
	final ObservableList<BloodGlucoseReadings> bloodglucoseleveldata = FXCollections
			.observableArrayList();
	final ObservableList<InsulinDosageReadings> insulinhistorydata = FXCollections
			.observableArrayList();
	@FXML
	private TableColumn timecolumn;

	@FXML
	private TableColumn readingcolumn;

	@FXML
	private TableView bloodglucosehistorytable;
	@FXML
	private Label bolusinjectionconfirmationfxid;
	@FXML
	private Button search;
	@FXML
	private AnchorPane homepageanchorpane;
	@FXML
	private AnchorPane bolusinjectionanchorpane;
	@FXML
	private AnchorPane bloodglucosereadingsfxid;
	@FXML
	private TextField carbohydrateamount;
	
	@FXML
	AnchorPane AnchorPane;
	@FXML
	AnchorPane hboxid;
	@FXML
	private static ProgressBar batterylevel;
	@FXML
	private static ProgressBar insulinlevel;

	
	@FXML
	private Button upbutton;
	@FXML
	private Button downbutton;
	@FXML
	private static TextArea sugarlevel;
	

	/*@FXML
	private final ObservableList<String> items = FXCollections
			.observableArrayList();
	@FXML
	private static ObservableList<String> warningitems = FXCollections
			.observableArrayList();*/
	private static ObservableList<String> menuoptions = FXCollections
			.observableArrayList();

	private static ArrayList<Double> currentprevioussugarlevel;

	// Checkboxes

	@FXML
	private CheckBox bgsensor;
	@FXML
	private CheckBox needle;
	@FXML
	private CheckBox reservoir;

	private double glucoselevel;

	private Map<String, Double> accesorystatus = null;
	

	
	@FXML
	public static LineChart<Number, Number> linechart ;//=new LineChart<Number, Number>(xaxis, yaxis);
	@FXML
	public static  NumberAxis xaxis ;
	@FXML
	public static  NumberAxis yaxis ;
	
	private volatile static Timer timer;

	private static Series<Number, Number> series = new XYChart.Series<Number, Number>();
	private static Series<Number, Number> series2 = new XYChart.Series<Number, Number>();

//	@FXML
//	private ListView<String> warningmessages;
//	@FXML
//	private ListView<String> accesorystatuses;
	private int starttime;
	private int endtime;
	private Double insulindose = 0.0;
	private static Double i = 0.0;

	@FXML
	private void switchOnOffSystem(ActionEvent event) {
		

		/*if (AreAnyWarnings) {
		 * 

		} else {*/
		if(switchbutton.isSelected()){
			rectanglefxid.setVisible(false);
			startPumpScheduling();
			Boolean AreAnyWarnings = preCheck();
		}
		else
			{
			stopPumpScheduling();
			rectanglefxid.setVisible(true);
			setAlarm(false);
			}
		
		
	
		//}

	}
private void startPumpScheduling(){
	timer = new Timer();
	synchronized (timer) {
		
		DisplayToControllerMediator.getInstance().startScheduling(timer);
	}
	
	System.out.println("Scheduling started");
}
private static Boolean isschedulingwaiting = false;
private void stopPumpScheduling(){
	setHideVisible(6);
	isschedulingwaiting =true;
	System.out.println(" scheduling paused");
	System.out.println(" Is scheduling: "+isschedulingwaiting);
	Platform.runLater(new Runnable() {
		
		@Override
		public  void run() {
			if(timer!=null){
			synchronized (timer) {
				
				DisplayToControllerMediator.getInstance().cancelTask();
				timer.cancel();
				
			}
			
		} }
	});
}

private void resumePumpScheduling(){
	setHideVisible(2);
	isschedulingwaiting= false;
	System.out.println(" scheduling resumed");
	/*Platform.runLater(new Runnable() {
		
		@Override
		public void run() {
			synchronized (timer) {
				timer.notify();
			}
			
			
		}
	});*/
	startPumpScheduling();
}

	public static void setParameters(final HashMap accesorystatuses) {
		// start from this line
		if((double) accesorystatuses
						.get("glucoselevel") > 120.0|| (double) accesorystatuses
						.get("glucoselevel")< 90.0){
			setAlarm(true);
			
		}
		else
			setAlarm(false);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				currentprevioussugarlevel.add((Double) accesorystatuses
						.get("glucoselevel"));
			//	if ((double) accesorystatuses.get("insulinlevel") < 0.2) {
					/*warningitems
							.add(" Insulin Level has been decrease below level !!");*/

			//	} else 
				{

					insulinlevel.setProgress((double) accesorystatuses
							.get("insulinlevel"));
					insulinleveltext.setText(String.format("%.2f", (double)accesorystatuses
							.get("insulinlevel")*100));
					int sizeofarr = currentprevioussugarlevel.size();
					sugarlevel.setText("current BG : \n"
							+ String.format("%.2f",currentprevioussugarlevel.get(sizeofarr - 1)));

					if (sizeofarr != 1)
						sugarlevel.appendText("\n\n previous BG: \n "
								+ String.format("%.2f",currentprevioussugarlevel.get(sizeofarr - 2)));

					batterylevel.setProgress((double) accesorystatuses
							.get("batterylevel"));
					batteryleveltext.setText(String.format("%.2f", (double) accesorystatuses
							.get("batterylevel")*100));

					
					
				//	linechart
					//		.setStyle(".default-color0.chart-series-line { -fx-stroke: #f0fffc; }");
				//	series2.getNode().setStyle("-fx-stroke: #f0f7fc;");
					series.getData().add(
							new XYChart.Data<Number, Number>(i/*Clock.getcurrentTime()*/,
									(Double) accesorystatuses
											.get("glucoselevel")));
					
					
				
					i += 1.0;
					if(i>13){
						series.getData().remove(0);
					}
					if(i>12){
						System.out.println("lower bound "+xaxis.getLowerBound());
						xaxis.setLowerBound(xaxis.getLowerBound()+1);
						System.out.println("lower bound "+xaxis.getLowerBound());
						xaxis.setUpperBound(xaxis.getUpperBound()+1);
						
						
					}

				}

			}

		});

	}

	@FXML
	private void DiscoverDevice(ActionEvent event) {

		// called by home button

	}

	private boolean preCheck() {

		assemblybgSensorCheck(null);
		assemblyNeedleCheck(null);
		assemblyReservoirCheck(null);
		
		return false;
	}

	@FXML
	private void assemblyNeedleCheck(ActionEvent event) {
		setHideVisible(6);
		//Text errortext = new Text(InsulinConstants.needleerror);
	//	errortext.setStroke(Color.RED);
		String errortext = InsulinConstants.needleerror;
		System.out.println("is scheduling flag in needle check: "+ isschedulingwaiting);
		if (needle.isSelected()){
			
			if(errormessageobservablelist.contains(errortext.toString()))
			errormessageobservablelist.remove(errortext);
		}
		else
			errormessageobservablelist.add(errortext);
		
		if(errormessageobservablelist.isEmpty()){
			
			resumePumpScheduling();
		}
		else{
			if(!isschedulingwaiting){
				stopPumpScheduling();
			}
			
		}
		
	}

	@FXML
	private void assemblybgSensorCheck(ActionEvent event) {
		System.out.println("is scheduling flag in bgsensor check: "+ isschedulingwaiting);
		setHideVisible(6);
		
		Text errortext = new Text(InsulinConstants.bgsendorerror);
		String error = InsulinConstants.bgsendorerror;
		errortext.setStroke(Color.RED);
		if (bgsensor.isSelected()){
			if(errormessageobservablelist.contains(error))
			errormessageobservablelist.remove(error);
		}
		else
			errormessageobservablelist.add(error);
		
if(errormessageobservablelist.isEmpty()){
			
			resumePumpScheduling();
		}
		else{
			if(!isschedulingwaiting){
				stopPumpScheduling();
			}
			
		}
		/*if (!bgsensor.isSelected()) {
			items.add(1, "sensor is nt working");
		} else if (bgsensor.isSelected() && items.get(1) != null)
			items.remove(1);*/
	}

	@FXML
	private void assemblyReservoirCheck(ActionEvent event) {
		System.out.println("is scheduling flag in reservoir check: "+ isschedulingwaiting);
		
		Text errortext = new Text(InsulinConstants.reservoirerror);
		errortext.setStroke(Color.RED);
		String error = InsulinConstants.reservoirerror;
		if (reservoir.isSelected()){
			if(errormessageobservablelist.contains(error))
			errormessageobservablelist.remove(error);
		}
		else
			errormessageobservablelist.add(error);
		
if(errormessageobservablelist.isEmpty()){
			
			resumePumpScheduling();
		}
		else{
			if(!isschedulingwaiting){
				stopPumpScheduling();
			}
			
		}
/*
		if (!reservoir.isSelected()) {
			items.add(2, "Reservoir is nt properly fitted");
		} else if (reservoir.isSelected() && items.get(2) != null)
			items.remove(2);
*/
	}


	public void run1() {
Thread th = new Thread(new Runnable() {
	
	@Override
	public void run() {
		System.out.println("running a thread");
		initializeBasalProfileTimings();	
	}
});
th.start();
	}
			
		
		/*	public void run() {
				System.out.println("sameer sameer");
				run1();
			}*/
		
	public static String dosagemode ="Auto";
	@FXML
	private RadioButton modeselection;
		@FXML
		private void setDosageMode(ActionEvent event){
			if(modeselection.isSelected()){
				System.out.println("manual");
				dosagemode = "Manual";
			}
			else{
				System.out.println("auto");
				dosagemode="Auto";
			}
		}
		
	public static String getDosageMode(){
		return dosagemode;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		rectanglefxid.setVisible(true);
		//timer = new Timer();
		series.setName("BG Level");
		Clock.getInstance().startClock();
	//	linechart.setAnimated(true);
	//	linechart.setStyle("list-cell:filled:selected:focused .list-cell:filled:selected {   -fx-background-color: linear-gradient(#333 0%, #777 25%, #aaa 75%, #eee 100%);    -fx-text-fill: white;} ");

	//	run1();// to load the database files
	initializeBasalProfileTimings();				
/*	Callback<ListView,ListCell> cl = new Callback<ListView, ListCell>(){

		@Override
		public ListCell call(ListView arg0) {
			ListCell<> lc=  new ListCell<>(){
				
			}
		}
		
	}
	*/	errormessagepopuplist.setItems(errormessageobservablelist);
		menuoptionlistviewfxid.setItems(menuoptions);
		ContextMenu ct = new ContextMenu();
		//menuoptionlistviewfxid.setCellFactory(ContextMe)
		addOptionsToList(1);
		basalprofilenamesfxid.setItems(basalprofileslist);
	
		addOptionsToList(2);

		linechart.getData().add(series);
		linechart.getData().add(series2);
		//series2.getData().add(e)
	//	linechart.
	
		currentprevioussugarlevel = new ArrayList<Double>();
	//	carbohydratevalue = 0;
	//	carbohydrateamount.setText(carbohydratevalue + " gram");
		basalprofiletabsfxid.getSelectionModel().selectFirst();
		basalprofiledatafxid.setItems(basalprofilesdatalist);
		basalprofiledatafxid.getSelectionModel().select(1);
		// basalprofilenamesfxid.setItems(arg0)
		addOptionsToList(3);
		activitylistview.setItems(activitylist);
		addOptionsToActivity();
		
		
		try {
			openUpPopup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		errorimageview.setImage(img);
		setHideVisible(2);
	}

	private void addOptionsToActivity() {
		activitylist.add(0, "Coke- 1 serving");
		activitylist.add(1, "Bread (2 slices)");
		activitylist.add(2, "Rice (1 cup cooked)");
		activitylist.add(3, "Honey (1 teaspoon)");
		activitylist.add(4, "Chocolate (15g carbs)");
	//	activitylist.add(6, "C");
		carbohydratecontaint.put(0, 14.0);
		carbohydratecontaint.put(1, 8.0);
		carbohydratecontaint.put(2, 25.0);
		carbohydratecontaint.put(3, 12.0);
		carbohydratecontaint.put(4, 15.0);
		
	}
	
	@FXML
	private void closeWindow(ActionEvent event){
		Stage primarystage = (Stage) homepageanchorpane.getScene().getWindow();
		stopPumpScheduling();		
		primarystage.close();
		dialog.close();
		setAlarm(false);
		
	}
private Stage dialog;
	private void openUpPopup() throws IOException {
		
             final Stage myDialog = new Stage();
             dialog = myDialog;
      //       final Stage primarystage = (Stage) myDialog.getScene().getWindow();//(Stage) sugarlevel.getScene().getWindow();
             myDialog.initModality(Modality.WINDOW_MODAL);
        //     myDialog.initOwner(primarystage);
             //myDialog.initModality(Modality.NONE);
           //  myDialog.initModality(Modality.APPLICATION_MODAL);
        //     Parent popup1 = FXMLLoader.load(getClass().getResource("popup.fxml"));
             myDialog.setX(50);
             myDialog.setY(50);
            AnchorPane popupanchorpane = new AnchorPane();
            popupanchorpane.prefHeight(70);
            popupanchorpane.prefWidth(70);
            popupanchorpane.setPadding(new Insets(100));
            
             Button okButton = new Button("CLOSE");
             popupanchorpane.getChildren().addAll(reservoir,bgsensor,needle,activitylistview,activityprocessbutton);
             
             okButton.setOnAction(new EventHandler<ActionEvent>(){

                 @Override
                 public void handle(ActionEvent arg0) {
                     //myDialog.close();
                	System.out.println(arg0.getSource().toString());
                	 sugarlevel.setText("Sameer");
                 }
                
             });
            
             Scene myDialogScene = new Scene(popupanchorpane/*VBoxBuilder.create()
                     .children(new Text("Hello! it's My Dialog."), okButton)
                     .alignment(Pos.CENTER)
                     .padding(new Insets(100))
                     .build()*/);
            
           
             myDialog.setScene(myDialogScene);
             
             myDialog.show();
         }
    


	@Override
	public void setParentScreen(ScreenController screencontroller) {
		this.screencontroller = screencontroller;

	}

	@FXML
	private void bolusInjection(ActionEvent event) {
		setHideVisible(1);
	}

	@FXML
	private void increaseCarbohydrateOrInsulinDose(ActionEvent event) {
		if (basalprofiletabsfxid.isVisible()) {
			if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 3) {
				if(basalprofilenamesfxid.getSelectionModel().getSelectedIndex() == 0)
					basalprofilenamesfxid.getSelectionModel().selectLast();
				else
				basalprofilenamesfxid.getSelectionModel().selectPrevious();
				
			}
			else if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 2) {
				if(basalprofiletimingsandinsulin.getSelectionModel().getSelectedIndex() == 0)
					basalprofiletimingsandinsulin.getSelectionModel().selectLast();
				else
					basalprofiletimingsandinsulin.getSelectionModel().selectPrevious();
				
				
			}
			
			if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 1) {
				// System.out.println("increase index: "+
				// basalprofiledatafxid.getSelectionModel().getSelectedIndex());
				if (basalprofiledatafxid.getSelectionModel().getSelectedIndex() == 1) {
					if (starttime == 23)
						starttime = 00;
					else
						starttime += 1;
					tea1.setText(starttime + "");

				}
				if (basalprofiledatafxid.getSelectionModel().getSelectedIndex() == 3) {
					if (endtime == 23)
						endtime = 00;
					endtime += 1;
					tea2.setText(endtime + "");

				}
				if (basalprofiledatafxid.getSelectionModel().getSelectedIndex() == 5) {
					insulindose += 0.1;
					tea3.setText(insulindose + " Units/Hour");

				}

			}

		}
		/*if (!bolusinjectionconfirmationfxid.isVisible()) {
			carbohydratevalue += 1;
			carbohydrateamount.setText(carbohydratevalue + " gram");
		}*/
		if (menuoptionanchorpanefxid.isVisible()) {
			if (menuoptionlistviewfxid.getSelectionModel().getSelectedIndex() == 0) {
				menuoptionlistviewfxid.getSelectionModel().selectLast();
			} else {

				menuoptionlistviewfxid.getSelectionModel().selectPrevious();
			}
		}

	}

	@FXML
	private void decreaseCarbohydrateOrInsulinDose(ActionEvent event) {
		/*if (!bolusinjectionconfirmationfxid.isVisible()) {
			carbohydratevalue -= 1;
			carbohydrateamount.setText(carbohydratevalue + " gram");
		}*/
		if (menuoptionanchorpanefxid.isVisible()) {
			if (menuoptionlistviewfxid.getSelectionModel().getSelectedIndex() == menuoptionlistviewfxid
					.getItems().size() - 1) {
				menuoptionlistviewfxid.getSelectionModel().selectFirst();
			} else {

				menuoptionlistviewfxid.getSelectionModel().selectNext();
			}
		}

		if (basalprofiletabsfxid.isVisible()) {
			if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 3) {
				if(basalprofilenamesfxid.getSelectionModel().getSelectedIndex() == basalprofileslist.size()-1)
					basalprofilenamesfxid.getSelectionModel().selectFirst();
				else
				basalprofilenamesfxid.getSelectionModel().selectNext();
				
			}
			else if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 2) {
				if(basalprofiletimingsandinsulin.getSelectionModel().getSelectedIndex() == basalprofiletimingslist.size()-1)
					basalprofiletimingsandinsulin.getSelectionModel().selectFirst();
				else
					basalprofiletimingsandinsulin.getSelectionModel().selectNext();
				
				
			}

			else if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 1) {				
				
				System.out.println("decrease index: "
						+ basalprofiledatafxid.getSelectionModel()
								.getSelectedIndex());
				if (basalprofiledatafxid.getSelectionModel().getSelectedIndex() == 1) {
					if (starttime == 00)
						starttime = 23;
					else
						starttime -= 1;
					tea1.setText(starttime + "");

				}
				if (basalprofiledatafxid.getSelectionModel().getSelectedIndex() == 3) {
					if (endtime == 0)
						endtime = 23;
					else
					endtime -= 1;
					tea2.setText(endtime + "");

				}
				if (basalprofiledatafxid.getSelectionModel().getSelectedIndex() == 5) {
					if (insulindose == 0.0)
						insulindose = 0.0;
					else
						insulindose -= 0.1;
					tea3.setText(insulindose + " Units/Hour");

				}

			}

		}

	}

	@FXML
	private void getHelpOnAction(ActionEvent event) {

	}

	@FXML
	private void goToHomePage(ActionEvent event) {
		setHideVisible(2);
		//setAlertMessage(null);

	}

	@FXML
	private void cancelButtonPressed(ActionEvent event) {
		/*
		 * // need to implement later when error messages are resolved..
		 * Platform.runLater(new Runnable(){
		 * 
		 * @Override public void run() { { timer.notify();
		 * 
		 * }
		 * 
		 * } } );
		 */
		if (bolusinjectionconfirmationfxid.isVisible()) {
			setHideVisible(1);

		} else if (bolusinjectionanchorpane.isVisible()
				|| bloodglucosehistorytable.isVisible()) {

			setHideVisible(2);
		}

		bolusinjectionconfirmationfxid.setVisible(false);

	}
	@FXML
	private Text calculatedbolusdosefxid;
	
 
	@FXML
	private void okayButtonPressed(ActionEvent event) {
		
		/*
		 * // need to implement later when any warning messages occur
		 * Platform.runLater(new Runnable(){
		 * 
		 * @Override public void run() { try { synchronized (timer) {
		 * timer.wait();
		 * 
		 * }
		 * 
		 * } catch (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * } } );
		 */

		if (bolusinjectionconfirmationfxid.isVisible()) {
			bolusinjectionconfirmationfxid.setVisible(false);
			calculatedbolusdosefxid.setVisible(false);
			setHideVisible(2);
		//	injectBolus();
		//	carbohydratevalue= 0;
		} else if (bolusinjectionanchorpane.isVisible()) {
			calculatedbolusdosefxid.setVisible(true);
			if(new Double(PrimeController.getCurrentbolus()).doubleValue() >0.0)
			PrimeController.injectBolus();
		//	calculatedbolusdosefxid.setText(PrimeController.getCurrentbolus()+ " Units");
			setHideVisible(1);
			bolusinjectionconfirmationfxid.setVisible(true);
		}

		else if (basalprofiletabsfxid.isVisible()) {

			if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 3) {
				// List profile
				// =HibernateChecker.getTimingsAndInsulin(basalprofilenamesfxid.getSelectionModel().getSelectedItem().toString());
				// Set<String> profile =basalprofiledata.keySet();
				
				
				basalprofiletabsfxid.getSelectionModel().selectNext();
				setDataIntoBasalProfileTimingsandInsulin();
				basalprofiletimingsandinsulin.getSelectionModel().selectFirst();
				// setHideVisible(3);

			}
			else if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 2) {
				basalprofiletabsfxid.getSelectionModel().selectNext();
				List profiledata = basalprofiledata.get(basalprofilenamesfxid.getSelectionModel().getSelectedItem().toString());
				basalprofile  = (BasalProfile) profiledata.get(basalprofiletimingsandinsulin.getSelectionModel().getSelectedIndex());
				starttime = new Integer(basalprofile.getBasalStartTime()).intValue();
				endtime = new Integer(basalprofile.getBasalEndTime()).intValue();
				insulindose = new Double(basalprofile.getBasalInsulinDose()).doubleValue();
				addOptionsToList(3);				
				basalprofiledatafxid.getSelectionModel().select(1);
				
			}
			
			
			
		else if (basalprofiletabsfxid.getSelectionModel().getSelectedIndex() == basalprofiletabsfxid
					.getTabs().size() - 1) {
				
				updatelabeltext.setVisible(true);
				if (basalprofiledatafxid.getSelectionModel().getSelectedIndex() == basalprofiledatafxid
						.getItems().size() - 1) {
					basalprofiledatafxid.getSelectionModel().select(1);

				} else {
					basalprofiledatafxid.getSelectionModel().selectNext();
					basalprofiledatafxid.getSelectionModel().selectNext();
				}
				// System.out.println("the selected item is: "+basalprofiledatafxid.getSelectionModel().getSelectedIndex());
			}

			
			
		}

		
		
		
	
		
		// we ended here, wid basal profile
		// todo: saving basal profile, getting basal profile from db
		// todo:
		else if (menuoptionanchorpanefxid.isVisible()) {

			String menuoption = (String) menuoptionlistviewfxid
					.getSelectionModel().getSelectedItem();
			if (menuoption.equals("Inject Bolus")) {
				injectBolus();
				bolusInjection(null);
			} 
			else if (menuoption.equals("Select Mode")) {
				bolusInjection(event);
			}
			else if (menuoption.equals("Insulin Dose History")) {
				showInsulinDoseHistory(null);
			} else if (menuoption.equals("Show Blood Glucose History")) {
				showBloodGlucoseReadings(null);
			} else if (menuoption.equals("Basal Profile")) {
				showBasalProfile();
				basalprofilenamesfxid.getSelectionModel().selectFirst();		

			} else if (menuoption.equals("Suspend ")) {
				bolusInjection(null);
			}
			else if (menuoption.equals("Generate Report")) {
				PrimeController.generateReport();
				
			}
		}

	}

	private void injectBolus() {
		
		String bolusvalue= PrimeController.getBolusInjected();
		System.out.println("injecting bolus");		
		calculatedbolusdosefxid.setText(bolusvalue+ " Units");
		
	}
	private void setDataIntoBasalProfileTimingsandInsulin() {
		basalprofiletimingslist.clear();
		List<BasalProfile> profiledata = basalprofiledata
				.get(basalprofilenamesfxid.getSelectionModel()
						.getSelectedItem().toString());
		// basalprofiledata.get(profname
		Iterator<BasalProfile> iterator1 = profiledata.iterator();
		while (iterator1.hasNext()) {
			BasalProfile bp = iterator1.next();
			basalprofiletimingslist.add(getFormattedString(bp.getBasalStartTime())
					+ "    to    " + getFormattedString(bp.getBasalEndTime()) + "    :    "
					+ bp.getBasalInsulinDose());
		}
		
	}

	@FXML
	private void goToScreen2(ActionEvent event) {
		ScreenNextController.goToNextScreen(hboxid);
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void showBloodGlucoseReadings(ActionEvent event) {
	//	bloodglucosehistorytable.setItems(bloodglucoseleveldata);
		bloodglucosehistorytable.setItems(bloodglucoseleveldata);
		timecolumn.setText(" Time ");
		readingcolumn.setText("Blood Glucose Reading");
		timecolumn
				.setCellValueFactory(new PropertyValueFactory<BloodGlucoseReadings, String>(
						"time"));
		readingcolumn
				.setCellValueFactory(new PropertyValueFactory<BloodGlucoseReadings, String>(
						"readings"));
		setHideVisible(3);
		
List<BloodGlucoseReadings> li = HibernateChecker.getBloodGlucoseHistory();
Iterator<BloodGlucoseReadings>	iterator = li.iterator();
while(iterator.hasNext()){
	BloodGlucoseReadings idr = iterator.next();
	bloodglucoseleveldata.add(idr);
}

		// bloodglucoseleveldata.add(new BloodGlucoseReadings(new
		// String("123.4"), new Date(System.currentTimeMillis())));
	}

	@FXML
	private void showInsulinDoseHistory(ActionEvent event) {
		bloodglucosehistorytable.setItems(insulinhistorydata);
		timecolumn.setText(" Time ");
		readingcolumn.setText("Insulin dose amount");
		timecolumn
				.setCellValueFactory(new PropertyValueFactory<InsulinDosageReadings, String>(
						"insulindosetime"));
		readingcolumn
				.setCellValueFactory(new PropertyValueFactory<InsulinDosageReadings, String>(
						"insulindose"));

		setHideVisible(3);
List<InsulinDosageReadings> li = HibernateChecker.getInsulinDosageHistory();
Iterator<InsulinDosageReadings>	iterator = li.iterator();
while(iterator.hasNext()){
	InsulinDosageReadings idr = iterator.next();
	insulinhistorydata.add(idr);
}


	}

	@FXML
	private void showMenuOptions(ActionEvent event) {
		if(updatelabeltext.isVisible()){
			basalprofile.setBasalStartTime(starttime+"");
			basalprofile.setBasalEndTime(endtime+"");
			basalprofile.setBasalInsulinDose(insulindose+"");
		HibernateChecker.updateBasalProfileData(basalprofile);	
		updatelabeltext.setVisible(false);
		basalprofiletabsfxid.getSelectionModel().selectPrevious();
		basalprofiletimingsandinsulin.getSelectionModel().selectFirst();
		setDataIntoBasalProfileTimingsandInsulin();
		
		}
		else
		setHideVisible(4);
	}

	private void addOptionsToList(int j) {
		if (j == 1) {
			menuoptions.add("Inject Bolus");
			menuoptions.add("Select Mode");
			menuoptions.add("Insulin Dose History");
			menuoptions.add("Show Blood Glucose History");
			menuoptions.add("Basal Profile");
			menuoptions.add("Suspend ");
			menuoptions.add("Generate Report");
			menuoptionlistviewfxid.setEditable(true);
			menuoptionlistviewfxid.getSelectionModel().selectFirst();
		}
		if (j == 2) {
			// List profile =HibernateChecker.getBasalProfiles();
			Set<String> profile = basalprofiledata.keySet();
			// if(profile!=null)
			Iterator<String> it = profile.iterator();
			while (it.hasNext()) {
				String profilename = (String) it.next();
				basalprofileslist.add(profilename);
				// basalprofile.put(user2.getBasalProfileName(),
				// user2.getBasalprofilecreationdate());

				// System.out.println("profilename is: "+
				// user2.getBasalProfileName()+
				// "timing is: "+user2.getBasalStartTime()+"to "+user2.getBasalEndTime()+
				// "and insulin level "+ user2.getBasalInsulinDose());
			}
		}
		if (j == 3) {
			basalprofilesdatalist.clear();
			// TextField tea1 = new TextField();
			tea1.setText(starttime + ".00");
			// TextField tea2 = new TextField();
			tea2.setText(endtime + ".00");
			// TextField tea3 = new TextField();
			tea3.setText(insulindose + "");
			basalprofilesdatalist.addAll("Start time", tea1);
			basalprofilesdatalist.addAll("End Time", tea2);
			basalprofilesdatalist.addAll("Insulin dose ", tea3);

		}

	}
	final static AudioClip alert = 

            new AudioClip(InsulinPumpGUIController.class.getResource("alertvibrate.mp3").toString());
	@FXML
	private static ImageView errorimageview;
	private static Image img = new Image(InsulinPumpGUIController.class.getResource("ErrorMessage.jpg").toString());
	
	private void setAlertMessage(String message){
		
		setHideVisible(6);	
		Text errortext = new Text(message);
		errortext.setStroke(Color.RED);
		errormessageobservablelist.add(message);		
		
	}
	
	private static void setAlarm(boolean isplay){
		if(isplay){
		if(!alert.isPlaying())
			alert.play();
		}
		else
		{
			if(alert.isPlaying())
				alert.stop();
		}
		
	}

	
	@FXML
	private void processActivity(ActionEvent event){
		double carbohydratevalue = (double) carbohydratecontaint.get(activitylistview.getSelectionModel().getSelectedIndex());
		GlucoseLevelManager.changeBloodGlucoseOnActivity(false,carbohydratevalue);
		
	}

	private void showBasalProfile() {
		setHideVisible(5);

		basalprofiletabsfxid.getSelectionModel().selectFirst();
	}

	private void initializeBasalProfileTimings() {
		List pofilenames = HibernateChecker.getBasalProfiles();
		Iterator<String> iterator1 = pofilenames.iterator();

		while (iterator1.hasNext()) {
			String profilename = iterator1.next().toString();
			basalprofiledata.put(profilename,
					(ArrayList<BasalProfile>) HibernateChecker
							.getTimingsAndInsulin(profilename));
			// System.out.println(basalprofiledata.get(profilename));
		}

		basalprofiletimingsandinsulin.setItems(basalprofiletimingslist);
		/*
		 * basalprofilestarttime.setCellValueFactory( new
		 * PropertyValueFactory<BasalProfile,String>("basalStartTime"));
		 * basalprofileendtime.setCellValueFactory( new
		 * PropertyValueFactory<BasalProfile,String>("basalEndTime"));
		 * basalprofileinsulindose.setCellValueFactory( new
		 * PropertyValueFactory<BasalProfile,String>("basalInsulinDose"));
		 */
	}
	
	private  String getFormattedString(String basalprofiletimingsdose){
		
		if(!basalprofiletimingsdose.isEmpty() ){
			
				basalprofiletimingsdose= basalprofiletimingsdose.concat("0000").substring(0,4);
				basalprofiletimingsdose= basalprofiletimingsdose.substring(0,2).concat(":").concat(basalprofiletimingsdose.substring(2));
				
				
			}
		
		return basalprofiletimingsdose;
		
	}

	private void setHideVisible(int option) {
		switch (option) {

		case 1: {
			homepageanchorpane.setVisible(false);
			bloodglucosereadingsfxid.setVisible(false);
			bolusinjectionanchorpane.setVisible(true);
			menuoptionanchorpanefxid.setVisible(false);
			basalprofiletabsfxid.setVisible(false);
			errormessageanchorpane.setVisible(false);

			break;
		}
		case 2: {
			homepageanchorpane.setVisible(true);
			bloodglucosereadingsfxid.setVisible(false);
			bolusinjectionanchorpane.setVisible(false);
			menuoptionanchorpanefxid.setVisible(false);
			basalprofiletabsfxid.setVisible(false);
			errormessageanchorpane.setVisible(false);
			break;
		}
		case 3: {
			bloodglucosereadingsfxid.setVisible(true);
			bolusinjectionanchorpane.setVisible(false);
			homepageanchorpane.setVisible(false);
			menuoptionanchorpanefxid.setVisible(false);
			basalprofiletabsfxid.setVisible(false);
			errormessageanchorpane.setVisible(false);
			break;
		}
		case 4: {
			bloodglucosereadingsfxid.setVisible(false);
			bolusinjectionanchorpane.setVisible(false);
			homepageanchorpane.setVisible(false);
			menuoptionanchorpanefxid.setVisible(true);
			basalprofiletabsfxid.setVisible(false);
			errormessageanchorpane.setVisible(false);
			break;
		}
		case 5: {
			bloodglucosereadingsfxid.setVisible(false);
			bolusinjectionanchorpane.setVisible(false);
			homepageanchorpane.setVisible(false);
			menuoptionanchorpanefxid.setVisible(false);
			basalprofiletabsfxid.setVisible(true);
			errormessageanchorpane.setVisible(false);

			break;
		}
		case 6: {
			bloodglucosereadingsfxid.setVisible(false);
			bolusinjectionanchorpane.setVisible(false);
			homepageanchorpane.setVisible(false);
			menuoptionanchorpanefxid.setVisible(false);
			basalprofiletabsfxid.setVisible(false);
			errormessageanchorpane.setVisible(true);

			break;
		}
		}

	}

	public static void setClock(String format) {
		currentdate.setText(format);
		
	}

}
