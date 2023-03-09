package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Courier;
import com.example.demo.service.CourierService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller
{ @Autowired
	private CourierService cService;

	@PostMapping("/book")
	public Courier bookParcel(@RequestBody Courier p)
	{
		return cService.addParcel(p);
	}
	
	@GetMapping("/showAll")
	@CrossOrigin(origins = "*")
	public List<Courier> showDetails()
	{
		List<Courier> alist= new ArrayList<>();
		alist=cService.getDetails();
		return alist;
	}
	
	@DeleteMapping("/cancel/{id}")
	public void cancelParcel(@PathVariable int id) {
		cService.cancelParcel(id);
	}
	@PutMapping("/update/{id}")
	public Courier updateDetails(@PathVariable int id, @RequestBody Courier p) {
		return cService.updateDetails(id, p);
	}
  
  
}