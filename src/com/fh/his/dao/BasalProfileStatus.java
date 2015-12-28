package com.fh.his.dao;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BASAL_PROFILE_STATUS")
public class BasalProfileStatus {
	
	private int basalProfileId;	
	private String basalProfilestatus;
	private String basalProfileName;
	
	
	

public BasalProfileStatus(){
		
	}

public BasalProfileStatus(int basalProfileId, String basalProfilestatus,
		String basalProfileName) {
	super();
	this.basalProfileId = basalProfileId;
	this.basalProfilestatus = basalProfilestatus;
	this.basalProfileName = basalProfileName;
}

@Id
@GeneratedValue(generator="increment")
@GenericGenerator(name="increment", strategy="increment")
@Column(name="profile_status_id")
	public int getBasalProfileId() {
		return basalProfileId;
	}


	public void setBasalProfileId(int basalProfileId) {
		this.basalProfileId = basalProfileId;
	}

	

	@Column(name="status")
	public String getBasalProfilestatus() {
		return basalProfilestatus;
	}


	public void setBasalProfilestatus(String basalProfilestatus) {
		this.basalProfilestatus = basalProfilestatus;
	}

	@Column(name="profile_name")
	public String getBasalProfileName() {
		return basalProfileName;
	}


	public void setBasalProfileName(String basalProfileName) {
		this.basalProfileName = basalProfileName;
	}
	


	
}
