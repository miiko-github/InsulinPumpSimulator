package com.fh.his.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="INSULIN_DELIVERED")
public class InsulinDosageReadings {
	
	public InsulinDosageReadings(){
		
	}
		private double insulindose;
		private String insulindosetime;
		private int insulindoseid;
		private String insulintype;
		
	
		public InsulinDosageReadings(double insulindose, String insulindosetime,String insulintype) {
			
			this.insulindose = insulindose;
			this.insulindosetime = insulindosetime;
			this.insulintype = insulintype;
		}

		@Id
		@GeneratedValue(generator="increment")
		@GenericGenerator(name="increment", strategy="increment")
		@Column(name="insulin_delivered_id")
		public int getInsulindoseid() {
			return insulindoseid;
		}

		public void setInsulindoseid(int insulindoseid) {
			this.insulindoseid = insulindoseid;
		}
		@Column(name="dosage_type")
		public String getInsulintype() {
			return insulintype;
		}

		public void setInsulintype(String insulintype) {
			this.insulintype = insulintype;
		}

		@Column(name="insulin_amount")
		public double getInsulindose() {
			return insulindose;
		}

		public void setInsulindose(double insulindose) {
			this.insulindose = insulindose;
		}
		@Column(name="time")
		public String getInsulindosetime() {
			return insulindosetime;
		}

		public void setInsulindosetime(String insulindosetime) {
			this.insulindosetime = insulindosetime;
		}

		





}

