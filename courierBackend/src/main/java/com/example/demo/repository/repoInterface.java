package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Courier;

public interface repoInterface extends JpaRepository<Courier, Integer>{

}
