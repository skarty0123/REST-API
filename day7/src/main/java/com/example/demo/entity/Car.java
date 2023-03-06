package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="CarDetails")
public class Car {
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="CARNAME")
	private String carname;
	
	@Column(name="CARTYPE")
	private String cartype;
	
	@Column(name="OWNERS")
	private int owners;
	
	@Column(name="CURRENTOWNERNAME")
	private String currentownername;
	
	@Column(name="MOBILE")
	private long mobile;
	
	@Column(name="ADDRESS")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public int getOwners() {
		return owners;
	}

	public void setOwners(int owners) {
		this.owners = owners;
	}

	public String getCurrentownername() {
		return currentownername;
	}

	public void setCurrentownername(String currentownername) {
		this.currentownername = currentownername;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    public Car() {}
	public Car(int id, String carname, String cartype, int owners, String currentownername, long mobile,
			String address) {
		super();
		this.id = id;
		this.carname = carname;
		this.cartype = cartype;
		this.owners = owners;
		this.currentownername = currentownername;
		this.mobile = mobile;
		this.address = address;
	}
	
	
}