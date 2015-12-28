package com.fh.his.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CARBOHYDRATE_INTAKE_HISTORY")
public class CarbohydrateReadings {
	
public CarbohydrateReadings(){
	
}
		private String cabohydratereadings;
		private Date carbohydratetime;
		private int carbohydratereadingsid;
		
		@Id
		@GeneratedValue(generator="increment")
		@GenericGenerator(name="increment", strategy="increment")
		@Column(name="carbohydrate_intake_id")
		public int getCarbohydratereadingsid() {
			return carbohydratereadingsid;
		}

		public void setCarbohydratereadingsid(int carbohydratereadingsid) {
			this.carbohydratereadingsid = carbohydratereadingsid;
		}

		@Column(name="carbohydrate_amount")
		public String getCabohydratereadings() {
			return cabohydratereadings;
		}

		public void setCabohydratereadings(String cabohydratereadings) {
			this.cabohydratereadings = cabohydratereadings;
		}
		@Column(name="time")
		public Date getCarbohydratetime() {
			return carbohydratetime;
		}

		public void setCarbohydratetime(Date carbohydratetime) {
			this.carbohydratetime = carbohydratetime;
		}

		public CarbohydrateReadings(String carbohydratereading, Date carbohydratereadingtime){
			this.cabohydratereadings = carbohydratereading;
			this.carbohydratetime =carbohydratereadingtime;
		}
		
		





}
