package com.fh.his.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BASAL_PROFILE")
public class BasalProfile {
	
	private int basalProfileId;
	private String basalStartTime;
	private String basalEndTime;
	private String basalInsulinDose;
	private String basalProfilestatus;
	private String basalProfileName;
	private Date basalprofilecreationdate;
	
	

public BasalProfile(){
		
	}
public BasalProfile(String basalStartTime,String basalEndTime,String basalInsulinDose ){
	this.basalStartTime =basalStartTime;
	this.basalEndTime =basalEndTime;
	this.basalInsulinDose =basalInsulinDose;
}
@Id
@GeneratedValue(generator="increment")
@GenericGenerator(name="increment", strategy="increment")
@Column(name="basal_profile_id")
	public int getBasalProfileId() {
		return basalProfileId;
	}


	public void setBasalProfileId(int basalProfileId) {
		this.basalProfileId = basalProfileId;
	}

	@Column(name="basal_start_time")
	public String getBasalStartTime() {
		return basalStartTime;
	}


	public void setBasalStartTime(String basalStartTime) {
		this.basalStartTime = basalStartTime;
	}

	@Column(name="basal_end_time")
	public String getBasalEndTime() {
		return basalEndTime;
	}


	public void setBasalEndTime(String basalEndTime) {
		this.basalEndTime = basalEndTime;
	}

	@Column(name="insulin_amount")
	public String getBasalInsulinDose() {
		return basalInsulinDose;
	}


	public void setBasalInsulinDose(String basalInsulinDose) {
		this.basalInsulinDose = basalInsulinDose;
	}

	

	@Column(name="pofile_name")
	public String getBasalProfileName() {
		return basalProfileName;
	}


	public void setBasalProfileName(String basalProfileName) {
		this.basalProfileName = basalProfileName;
	}
	

	
}
