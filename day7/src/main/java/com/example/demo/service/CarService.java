package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Car;
import com.example.demo.repo.repoInterface;
@Service
public class CarService {
	@Autowired
	private repoInterface det;
	public boolean saveDetails(Car s) {
		
		if ((!Objects.nonNull(s.getId())) && (!Objects.nonNull(s.getCarname()))
				&& (!Objects.nonNull(s.getCartype())) && (!Objects.nonNull(s.getOwners()))
				&& (!Objects.nonNull(s.getCurrentownername() )) && (!Objects.nonNull(s.getMobile()))
				&& (!Objects.nonNull(s.getAddress())))
			return false;
		else {
			det.save(s);
			return true;
		}
	}

	public List<Car> findByOwners(@PathVariable int owners) {
		List<Car> arr = new ArrayList<>();
		arr = det.findByOwners(owners);
		return arr;
	}
	public List<Car> findByAddress(@PathVariable String address) {
		List<Car> arr = new ArrayList<>();
		arr = det.findByAddress(address);
		return arr;
	}
	public List<Car> findByCarname(@PathVariable String carname) {
		List<Car> arr = new ArrayList<>();
		arr = det.findByCarname(carname);
		return arr;
	}
	public List<Car> findByOwnersAndCartype(@PathVariable int owners,@PathVariable String cartype) {
		List<Car> arr = new ArrayList<>();
		arr = det.findByOwnersAndCartype(owners,cartype);
		return arr;
	}

}

