package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Courier")
public class Courier {
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="senderName")
	private String senderName;
	
	@Column(name="senderAddress")
	private String senderAddress;
	
	@Column(name="senderPhone")
	private long senderPhone;
	
	@Column(name="receiverName")
	private String receiverName;
	
	@Column(name="receiverAddress")
	private String receiverAddress;
	
	@Column(name="receiverPhone")
	private long receiverPhone;

	//getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public long getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(long senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public long getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(long receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	
	//constructors

	public Courier(int id, String senderName, String senderAddress, long senderPhone, String receiverName,
			String receiverAddress, long receiverPhone) {
		super();
		this.id = id;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderPhone = senderPhone;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverPhone = receiverPhone;
	}
	
	public Courier() {
		
	}
}

