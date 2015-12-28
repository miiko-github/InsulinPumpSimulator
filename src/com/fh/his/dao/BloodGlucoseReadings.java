package com.fh.his.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javafx.beans.property.SimpleStringProperty;

@Entity
@Table(name="GLUCOSE_LEVEL")
public class BloodGlucoseReadings {
	
	
	private int bloodglucoseid;
	private String readings;
	private String time;
	
	public BloodGlucoseReadings(String bgreading, String bgreadingtime){
		this.readings = bgreading;
		this.time =bgreadingtime;
	}
	public BloodGlucoseReadings(){
		
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name="glucose_level_id")
	

	public int getBloodglucoseid() {
		return bloodglucoseid;
	}
	public void setBloodglucoseid(int bloodglucoseid) {
		this.bloodglucoseid = bloodglucoseid;
	}
	
	@Column(name="glucose_level_reading")
	public String getReadings() {
		return readings;
	}
	
	public void setReadings(String readings) {
		this.readings=readings;
	}
	
	@Column(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	


}
