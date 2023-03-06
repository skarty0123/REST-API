package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
@RestController
public class Controller {
	@Autowired
	private CarService Sserve;

	@GetMapping("/owners/{owners}")
	public List<Car> showDetails1(@PathVariable int owners) {
		List<Car> a = new ArrayList<>();
		a = Sserve.findByOwners(owners);
		return a;
	}
	@GetMapping("/address/{address}")
	public List<Car> showDetails2(@PathVariable String address) {
		List<Car> a = new ArrayList<>();
		a = Sserve.findByAddress(address);
		return a;
	}
	@GetMapping("/carname/{carname}")
	public List<Car> showDetails3(@PathVariable String carname) {
		List<Car> a = new ArrayList<>();
		a = Sserve.findByCarname(carname);
		return a;
	}
	@GetMapping("/owners/{owners}/cartype/{cartype}")
	public List<Car> showDetails4(@PathVariable int owners,@PathVariable String cartype) {
		List<Car> a = new ArrayList<>();
		a = Sserve.findByOwnersAndCartype(owners,cartype);
		return a;
	}
	@PostMapping("/")
	public boolean postStudent(@RequestBody Car stu) {
		if(Sserve.saveDetails(stu))
			return true;
		else
			return false;
	}
}