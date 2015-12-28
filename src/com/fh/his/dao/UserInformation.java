package com.fh.his.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="USER_INFO")
public class UserInformation {
	private int userid;
	private String name;
	private String gender;
	private int age;
	private String insulin_type;
	private int weight;
	
	
	public UserInformation(){
		
	}
public UserInformation(String name, String gender, int age, String insulin_type, int weight){
		this.name = name;
		this.gender= gender;
		this.age =age;
		this.insulin_type =insulin_type;
		this.weight = weight;
	}
@Column(name="user_name")
public String getName() {
	return name;
}

/*@Id
@Column(name="user_info_id" )
@GeneratedValue(strategy=GenerationType.IDENTITY)*/
@Id
@GeneratedValue(generator="increment")
@GenericGenerator(name="increment", strategy="increment")
@Column(name="user_info_id")
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}

public void setName(String name) {
	this.name = name;
}
@Column(name="gender")
public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

@Column(name="age")
public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}
@Column(name="insulin_type")
public String getInsulin_type() {
	return insulin_type;
}

public void setInsulin_type(String insulin_type) {
	this.insulin_type = insulin_type;
}
@Column(name="weight")
public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

}
