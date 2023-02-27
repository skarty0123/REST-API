package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Railway;
import com.example.demo.repository.repoInterface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RailwayService 
{
	@Autowired
	private repoInterface repo1;
	
	public Railway addPassenger(Railway obj) {
		return repo1.save(obj);
	}
	public List<Railway> getPassenger()
	{
		List<Railway> arr= new ArrayList<>();
		arr=repo1.findAll();
		return arr;
	}
	public void cancelTicket(int pass_id)
	{
		repo1.deleteById(pass_id);
	}
	public Railway updateTicket(int pass_id, Railway obj) {
		return repo1.saveAndFlush(obj);
	}
	
}
