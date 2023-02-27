package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Railway;
import com.example.demo.service.RailwayService;


@RestController
public class Controller
{ @Autowired
	private RailwayService rlyService;

	@PostMapping("/book")
	public Railway bookTicket(@RequestBody Railway p)
	{
		return rlyService.addPassenger(p);
	}
	
	@GetMapping("/showAll")
	public List<Railway> showTickets()
	{
		List<Railway> alist= new ArrayList<>();
		alist=rlyService.getPassenger();
		return alist;
	}
	
	@DeleteMapping("/cancel/{pass_id}")
	public void cancelTicket(@PathVariable int pass_id) {
		rlyService.cancelTicket(pass_id);
	}
	@PutMapping("/update/{pass_id}")
	public Railway updateTicket(@PathVariable int pass_id, @RequestBody Railway p) {
		return rlyService.updateTicket(pass_id, p);
	}
  
  
}