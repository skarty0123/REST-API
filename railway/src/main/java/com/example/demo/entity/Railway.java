package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Railway")
public class Railway {
	
	@Id
	@Column(name="PassId")
	private int pass_id;
	@Column(name="TrainNo")
	private int trainno;
	
	@Column(name="SeatNo")
	private int seatno;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="age")
	private int age;

	//getters and setters
	
	public int getPassId() {
		return pass_id;
	}
	public void setPassId(int pass_id) {
		this.pass_id=pass_id;
	}
	public int getTrainNo() {
		return trainno;
	}
	public void setTrainNo(int trainno) {
		this.trainno=trainno;
	}
	
	public int getSeatNo() {
		return seatno;
	}
	public void setSeatNo(int seatno) {
		this.seatno=seatno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	//constructors
	public Railway(int pass_id, int trainno, int seatno, String name, int age) {
		super();
		this.pass_id=pass_id;
		this.trainno=trainno;
		this.seatno=seatno;
		this.name=name;
		this.age=age;
	}
	public Railway() {
		
	}
}
