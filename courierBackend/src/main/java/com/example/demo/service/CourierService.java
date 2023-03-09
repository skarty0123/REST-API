package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Courier;
import com.example.demo.repository.repoInterface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CourierService 
{
	@Autowired
	private repoInterface repo1;
	
	public Courier addParcel(Courier obj) {
		return repo1.save(obj);
	}
	public List<Courier> getDetails()
	{
		List<Courier> arr= new ArrayList<>();
		arr=repo1.findAll();
		return arr;
	}
	public void cancelParcel(int id)
	{
		repo1.deleteById(id);
	}
	public Courier updateDetails(int id, Courier obj) {
		return repo1.saveAndFlush(obj);
	}
	
}