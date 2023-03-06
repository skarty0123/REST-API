package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Car;
public interface repoInterface extends JpaRepository<Car,Integer>{
	
	@Query("FROM Car c WHERE c.owners=:owners")
	List<Car> findByOwners(@Param("owners") int owners);
	
	@Query("FROM Car c WHERE c.address=:address")
	List<Car> findByAddress(@Param("address") String address);
	
	@Query("FROM Car c WHERE c.carname=:carname")
	List<Car> findByCarname(@Param("carname") String carname);
	
	@Query("FROM Car c WHERE c.owners=:owners AND c.cartype=:cartype")
	List<Car> findByOwnersAndCartype(@Param("owners") int owners,@Param("cartype") String cartype );
}